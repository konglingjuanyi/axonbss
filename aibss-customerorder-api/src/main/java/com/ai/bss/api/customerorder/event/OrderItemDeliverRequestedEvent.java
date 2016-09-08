package com.ai.bss.api.customerorder.event;

public class OrderItemDeliverRequestedEvent extends AbstractCustomerOrderItemEvent {
	private String expressNumber;

	public String getExpressNumber() {
		return expressNumber;
	}

	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	};
	
}
