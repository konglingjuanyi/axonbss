package com.ai.bss.webui.customerorder.model;

import com.ai.bss.api.customerorder.CustomerOrderItemId;
import com.ai.bss.api.product.dto.BuyOffer;

public class CustomerOrderItem {
	private CustomerOrderItemId customerOrderItemId;
	private BuyOffer offer;
	public CustomerOrderItem() {
		// TODO Auto-generated constructor stub
	}
	public BuyOffer getOffer() {
		return offer;
	}
	public void setOffer(BuyOffer offer) {
		this.offer = offer;
	}
	public CustomerOrderItemId getCustomerOrderItemId() {
		return customerOrderItemId;
	}
	public void setCustomerOrderItemId(CustomerOrderItemId customerOrderItemId) {
		this.customerOrderItemId = customerOrderItemId;
	}

}
