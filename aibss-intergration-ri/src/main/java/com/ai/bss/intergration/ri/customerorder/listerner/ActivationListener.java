package com.ai.bss.intergration.ri.customerorder.listerner;

import java.util.Set;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.commandhandling.callbacks.FutureCallback;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.ai.bss.api.activation.command.AbstractActivateProductCommand;
import com.ai.bss.api.customerorder.event.OrderPaidEvent;
import com.ai.bss.api.party.command.CreateIndividualCommand;
import com.ai.bss.intergration.ri.customerorder.util.IProductOrderUtil;
import com.ai.bss.query.api.customerorder.CustomerOrderEntry;
import com.ai.bss.query.api.customerorder.OrderItemEntry;
import com.ai.bss.query.api.customerorder.OfferOrderEntry;
import com.ai.bss.query.api.customerorder.OfferOrderProductRelEntry;

public class ActivationListener {
	@Autowired
	public RestTemplate client;
	@Autowired
	private IProductOrderUtil productOrderUtil;
	@Autowired
	private CommandBus commandBus;
	public ActivationListener() {
		
	}
	
	@EventHandler
	public void onOrderPaidEvent(OrderPaidEvent event) throws Exception{
		CustomerOrderEntry customerOrder=client.getForObject("http://customerorder-query-service/customerorder/customerOrderId/"+event.getCustomerOrderId(),CustomerOrderEntry.class);
		Set<OrderItemEntry> orderItems=customerOrder.getOrderItems();
		if(orderItems.size()>0){
			for (OrderItemEntry orderItemEntry : orderItems) {
				OfferOrderEntry offerOrder=orderItemEntry.getItemOffer();
				Set<OfferOrderProductRelEntry> offerProducts=offerOrder.getRelProducts();
				if (!offerProducts.isEmpty()){
					for (OfferOrderProductRelEntry orderItemOfferProductRel : offerProducts) {						
						if (productOrderUtil.needDelivery(orderItemOfferProductRel)){
							
						}else if (productOrderUtil.needActivation(orderItemOfferProductRel)){
							AbstractActivateProductCommand command= productOrderUtil.getActivateCommand(orderItemEntry,orderItemOfferProductRel);
							if (null!=command){
								FutureCallback callback = new FutureCallback();
								commandBus.dispatch(new GenericCommandMessage<AbstractActivateProductCommand>(command),callback);
							}
						}
					}
				}
			}
		}
	}

}
