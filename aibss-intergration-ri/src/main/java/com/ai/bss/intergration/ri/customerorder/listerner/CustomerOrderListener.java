package com.ai.bss.intergration.ri.customerorder.listerner;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.commandhandling.callbacks.FutureCallback;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.bss.api.activation.event.ProductActivateOrderCreatedEvent;
import com.ai.bss.api.activation.event.ProductOrderActivatedEvent;
import com.ai.bss.api.customerorder.command.UpdateProductOrderStateCommand;
import com.ai.bss.api.delivery.event.ProductDeliveryOrderCreatedEvent;
import com.ai.bss.api.delivery.event.ProductOrderDeliveredEvent;
import com.ai.bss.query.api.customerorder.ProductOrderStateEnum;

public class CustomerOrderListener {
	@Autowired
	private CommandBus commandBus;
	public CustomerOrderListener() {
		
	}
	
	@EventHandler
	//update productOrder state to Activating
	public void onProductActivateOrderCreated(ProductActivateOrderCreatedEvent event){
		String productOrderId=event.getProductOrderId();
		UpdateProductOrderStateCommand command = new UpdateProductOrderStateCommand();
		command.setProductOrderId(productOrderId);
		command.setState(ProductOrderStateEnum.Activating.name());
		FutureCallback callback = new FutureCallback();
		commandBus.dispatch(new GenericCommandMessage<UpdateProductOrderStateCommand>(command),callback);
	}
	
	@EventHandler
	//update productOrder state to Activated
	public void onProductOrderActivated(ProductOrderActivatedEvent event){
		String productOrderId=event.getProductOrderId();
		UpdateProductOrderStateCommand command = new UpdateProductOrderStateCommand();
		command.setProductOrderId(productOrderId);
		command.setState(ProductOrderStateEnum.Activated.name());
		FutureCallback callback = new FutureCallback();
		commandBus.dispatch(new GenericCommandMessage<UpdateProductOrderStateCommand>(command),callback);
	}
	
	@EventHandler
	//update productOrder state to Delivering
	public void onProductDeliveryOrderCreated(ProductDeliveryOrderCreatedEvent event){
		String productOrderId=event.getProductOrderId();
		UpdateProductOrderStateCommand command = new UpdateProductOrderStateCommand();
		command.setProductOrderId(productOrderId);
		command.setState(ProductOrderStateEnum.Delivering.name());
		FutureCallback callback = new FutureCallback();
		commandBus.dispatch(new GenericCommandMessage<UpdateProductOrderStateCommand>(command),callback);
	}
	
	@EventHandler
	//update productOrder state to Delivered
	public void onProductOrderDelivered(ProductOrderDeliveredEvent event){
		String productOrderId=event.getProductOrderId();
		UpdateProductOrderStateCommand command = new UpdateProductOrderStateCommand();
		command.setProductOrderId(productOrderId);
		command.setState(ProductOrderStateEnum.Activated.name());
		FutureCallback callback = new FutureCallback();
		commandBus.dispatch(new GenericCommandMessage<UpdateProductOrderStateCommand>(command),callback);
	}

}
