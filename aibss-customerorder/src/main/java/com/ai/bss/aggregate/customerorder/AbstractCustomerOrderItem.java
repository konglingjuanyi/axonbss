package com.ai.bss.aggregate.customerorder;

import com.ai.bss.api.customerorder.CustomerOrderId;
import com.ai.bss.api.customerorder.CustomerOrderItemId;

public abstract class AbstractCustomerOrderItem {
	private CustomerOrderId customerOrderId;
	private CustomerOrderItemId customerOrderItemId;
	public AbstractCustomerOrderItem() {
	}
	
	protected AbstractCustomerOrderItem(CustomerOrderId customerOrderId,CustomerOrderItemId customerOrderItemId) {
		this.customerOrderId=customerOrderId;
		this.customerOrderItemId=customerOrderItemId;
	}
	public CustomerOrderItemId getCustomerOrderItemId() {
		return customerOrderItemId;
	}
	public void setCustomerOrderItemId(CustomerOrderItemId customerOrderItemId) {
		this.customerOrderItemId = customerOrderItemId;
	}

	public CustomerOrderId getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(CustomerOrderId customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
}
