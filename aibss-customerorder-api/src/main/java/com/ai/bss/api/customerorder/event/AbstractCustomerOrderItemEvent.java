package com.ai.bss.api.customerorder.event;

import com.ai.bss.api.base.BaseEvent;
import com.ai.bss.api.customerorder.CustomerOrderId;
import com.ai.bss.api.customerorder.CustomerOrderItemId;

public abstract class AbstractCustomerOrderItemEvent extends BaseEvent {
	private CustomerOrderId customerOrderId;
	private CustomerOrderItemId customerOrderItemId;
	private String OfferOrderId;
	private String offerInstanceId;
	public AbstractCustomerOrderItemEvent() {
		// TODO Auto-generated constructor stub
	}
	public CustomerOrderId getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(CustomerOrderId customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public CustomerOrderItemId getCustomerOrderItemId() {
		return customerOrderItemId;
	}
	public void setCustomerOrderItemId(CustomerOrderItemId customerOrderItemId) {
		this.customerOrderItemId = customerOrderItemId;
	}
	public String getOfferInstanceId() {
		return offerInstanceId;
	}
	public void setOfferInstanceId(String offerInstanceId) {
		this.offerInstanceId = offerInstanceId;
	}
	public String getOfferOrderId() {
		return OfferOrderId;
	}
	public void setOfferOrderId(String offerOrderId) {
		OfferOrderId = offerOrderId;
	}
}
