package com.ai.bss.commandhandler.customerorder;

import java.util.Set;

import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.saga.annotation.EndSaga;
import org.axonframework.saga.annotation.SagaEventHandler;
import org.axonframework.saga.annotation.StartSaga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ai.bss.api.customerorder.CustomerOrderItemId;
import com.ai.bss.api.customerorder.command.CancelOrderCommand;
import com.ai.bss.api.customerorder.command.CreateBuyOrderItemCommand;
import com.ai.bss.api.customerorder.command.FinishDeliverOrderCommand;
import com.ai.bss.api.customerorder.command.FinishOrderCommand;
import com.ai.bss.api.customerorder.command.RefundOrderCommand;
import com.ai.bss.api.customerorder.command.RequestCompleteOrderCommand;
import com.ai.bss.api.customerorder.command.RequestConfirmCancelOrderCommand;
import com.ai.bss.api.customerorder.command.RequestCustomerOrderCommand;
import com.ai.bss.api.customerorder.command.RequestDeliverOrderCommand;
import com.ai.bss.api.customerorder.command.RequestReturnGoodsOrderCommand;
import com.ai.bss.api.customerorder.event.BuyOrderItemCreatedEvent;
import com.ai.bss.api.customerorder.event.OrderCancelConfirmedEvent;
import com.ai.bss.api.customerorder.event.OrderCancelRequestedEvent;
import com.ai.bss.api.customerorder.event.OrderCanceledEvent;
import com.ai.bss.api.customerorder.event.OrderCompletedEvent;
import com.ai.bss.api.customerorder.event.OrderDeliveredEvent;
import com.ai.bss.api.customerorder.event.OrderRealObjectReturnedEvent;
import com.ai.bss.api.customerorder.event.OrderInitializedEvent;
import com.ai.bss.api.customerorder.event.ProductOrderDeliveredEvent;
import com.ai.bss.api.customerorder.event.OrderPaidEvent;
import com.ai.bss.api.customerorder.event.OrderRefundedEvent;
import com.ai.bss.api.product.dto.BuyOffer;
public class BuyCustomerOrderSaga extends CustomerOrderSaga {
	private final static Logger logger = LoggerFactory.getLogger(BuyCustomerOrderSaga.class);
	@StartSaga
	@SagaEventHandler(associationProperty = "customerOrderId")
	public void handle(OrderInitializedEvent event) {
		if (logger.isDebugEnabled()) {
            logger.debug(
                    "A new buy order is started with identifier {}",
                    new Object[]{event.getCustomerOrderId()});
        }
        this.setCustomerOrderId(event.getCustomerOrderId());
        Set<BuyOffer> buyOffers=event.getOffers();
        this.setOrderItemCount(buyOffers.size());
        for (BuyOffer buyOffer : buyOffers) {
			CreateBuyOrderItemCommand command=new CreateBuyOrderItemCommand();
			command.setCustomerOrderId(event.getCustomerOrderId());
			CustomerOrderItemId customerOrderItemId =new CustomerOrderItemId();
			command.setCustomerOrderItemId(customerOrderItemId);
			command.setBuyOffer(buyOffer);
			getCommandBus().dispatch(new GenericCommandMessage<CreateBuyOrderItemCommand>(command));
		}
	}
	   
	@SagaEventHandler(associationProperty = "customerOrderId")
	public void handle(BuyOrderItemCreatedEvent event) {
		if (event.getBuyOffer().getProducts().size()>0){
			this.setHasProducts(true);
		}
		if (this.getOrderItemCreatedCount()==this.getOrderItemCount()){
			RequestCustomerOrderCommand command=new  RequestCustomerOrderCommand();
			command.setCustomerOrderId(event.getCustomerOrderId());
			getCommandBus().dispatch(new GenericCommandMessage<RequestCustomerOrderCommand>(command));
		}
	}
	
//	@SagaEventHandler(associationProperty = "customerOrderId")
//	public void handle(BuyOrderConfirmedEvent event) {
//		//wait for customer to pay order
//	}
	
	@SagaEventHandler(associationProperty = "customerOrderId")
	public void handle(OrderPaidEvent event) {
		this.setPaid(true);
		RequestDeliverOrderCommand command = new RequestDeliverOrderCommand();
		command.setCustomerOrderId(event.getCustomerOrderId());
		getCommandBus().dispatch(new GenericCommandMessage<RequestDeliverOrderCommand>(command));
	}
	
	@SagaEventHandler(associationProperty = "customerOrderId")
	public void handle(ProductOrderDeliveredEvent event) {
		if (this.getOrderItemDeliveredCount()==this.getOrderItemCount()){
			FinishDeliverOrderCommand command=new  FinishDeliverOrderCommand();
			command.setCustomerOrderId(event.getCustomerOrderId());
			getCommandBus().dispatch(new GenericCommandMessage<FinishDeliverOrderCommand>(command));
			//next event is BuyOrderDeliveredEvent.
		}
	}
	
	@SagaEventHandler(associationProperty = "customerOrderId")
	public void handle(OrderDeliveredEvent event) {
		this.setDelivered(true);
		RequestCompleteOrderCommand command=new  RequestCompleteOrderCommand();
		command.setCustomerOrderId(event.getCustomerOrderId());
		getCommandBus().dispatch(new GenericCommandMessage<RequestCompleteOrderCommand>(command));
	}
	
	@SagaEventHandler(associationProperty = "customerOrderId")
	@EndSaga
    public void handle(OrderCompletedEvent event) {
		FinishOrderCommand command = new FinishOrderCommand();
		command.setCustomerOrderId(event.getCustomerOrderId());
		getCommandBus().dispatch(new GenericCommandMessage<FinishOrderCommand>(command));
		//next event is OrderFinishedEvent.
    }
	
	@SagaEventHandler(associationProperty = "customerOrderId")	
	public void handle(OrderCancelRequestedEvent event) {		
		RequestConfirmCancelOrderCommand command=new  RequestConfirmCancelOrderCommand();
		command.setCustomerOrderId(event.getCustomerOrderId());
		getCommandBus().dispatch(new GenericCommandMessage<RequestConfirmCancelOrderCommand>(command));
	}
	
	@SagaEventHandler(associationProperty = "customerOrderId")
	public void handle(OrderCancelConfirmedEvent event) {
		//if have products then request return goods
		//else request refund
		//else cancel directly
		if (this.isHasProducts()&&this.isDelivered()){
			RequestReturnGoodsOrderCommand command=new RequestReturnGoodsOrderCommand();
			command.setCustomerOrderId(event.getCustomerOrderId());
			getCommandBus().dispatch(new GenericCommandMessage<RequestReturnGoodsOrderCommand>(command));
		}else if(this.isPaid()){
			RefundOrderCommand command=new RefundOrderCommand();
			command.setCustomerOrderId(event.getCustomerOrderId());
			getCommandBus().dispatch(new GenericCommandMessage<RefundOrderCommand>(command));			
		}else{
			CancelOrderCommand command = new CancelOrderCommand();
			command.setCustomerOrderId(event.getCustomerOrderId());
			getCommandBus().dispatch(new GenericCommandMessage<CancelOrderCommand>(command));
		}		
	}
	
	@SagaEventHandler(associationProperty = "customerOrderId")
	public void handle(OrderRealObjectReturnedEvent event) {
		RefundOrderCommand command=new  RefundOrderCommand();
		command.setCustomerOrderId(event.getCustomerOrderId());
		getCommandBus().dispatch(new GenericCommandMessage<RefundOrderCommand>(command));
	}
	
	@SagaEventHandler(associationProperty = "customerOrderId")
    public void handle(OrderRefundedEvent event) {
		CancelOrderCommand command = new CancelOrderCommand();
		command.setCustomerOrderId(event.getCustomerOrderId());
		getCommandBus().dispatch(new GenericCommandMessage<CancelOrderCommand>(command));
		//next event is OrderCanceledEvent.
    }
	
	@SagaEventHandler(associationProperty = "customerOrderId")
    @EndSaga
    public void handle(OrderCanceledEvent event) {
		
    }
}
