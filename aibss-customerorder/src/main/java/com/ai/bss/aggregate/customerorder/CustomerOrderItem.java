package com.ai.bss.aggregate.customerorder;

import com.ai.bss.api.customerorder.CustomerOrderItemId;

public class CustomerOrderItem {
	private CustomerOrderItemId customerOrderItemId;
	public CustomerOrderItem() {
	}
	public CustomerOrderItemId getCustomerOrderItemId() {
		return customerOrderItemId;
	}
	public void setCustomerOrderItemId(CustomerOrderItemId customerOrderItemId) {
		this.customerOrderItemId = customerOrderItemId;
	}

}
