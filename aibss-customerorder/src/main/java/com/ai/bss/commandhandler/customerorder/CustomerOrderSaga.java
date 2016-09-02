package com.ai.bss.commandhandler.customerorder;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.saga.annotation.AbstractAnnotatedSaga;

import com.ai.bss.api.customerorder.CustomerOrderId;
import com.ai.bss.api.customerorder.CustomerOrderItemId;

public class CustomerOrderSaga extends AbstractAnnotatedSaga {
	private transient CommandBus commandBus;
	private CustomerOrderId orderIdentifier;
	private CustomerOrderItemId ordertemIdentifier;

	public CustomerOrderSaga() {
		// TODO Auto-generated constructor stub
	}

	public CustomerOrderSaga(String identifier) {
		super(identifier);
		// TODO Auto-generated constructor stub
	}

	public CommandBus getCommandBus() {
		return commandBus;
	}

	public void setCommandBus(CommandBus commandBus) {
		this.commandBus = commandBus;
	}

	public CustomerOrderId getCustomerOrdferIdentifier() {
		return orderIdentifier;
	}

	public void setCustomerOrdferIdentifier(CustomerOrderId customerOrderIdentifier) {
		this.orderIdentifier = customerOrderIdentifier;
	}


	public CustomerOrderItemId getCustomerOrdferItemIdentifier() {
		return ordertemIdentifier;
	}

	public void setCustomerOrdferItemIdentifier(CustomerOrderItemId customerOrderItemIdentifier) {
		this.ordertemIdentifier = customerOrderItemIdentifier;
	}

}
