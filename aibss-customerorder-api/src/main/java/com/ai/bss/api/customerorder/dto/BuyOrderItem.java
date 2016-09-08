package com.ai.bss.api.customerorder.dto;

import com.ai.bss.api.product.dto.BuyOffer;

public class BuyOrderItem {

	public BuyOrderItem() {
		
	}
	private BuyOffer offer;
	private int quantity;
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BuyOffer getOffer() {
		return offer;
	}

	public void setOffer(BuyOffer offer) {
		this.offer = offer;
	}

}
