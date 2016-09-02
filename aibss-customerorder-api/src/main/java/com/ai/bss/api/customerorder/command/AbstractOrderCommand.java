package com.ai.bss.api.customerorder.command;

import com.ai.bss.api.base.BaseCommand;
import com.ai.bss.api.customerorder.CustomerOrderId;

public abstract class AbstractOrderCommand extends BaseCommand {
	private CustomerOrderId customerOrderId;
	public AbstractOrderCommand() {
		// TODO Auto-generated constructor stub
	}
	public CustomerOrderId getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(CustomerOrderId customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

}
