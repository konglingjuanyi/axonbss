package com.ai.bss.api.customerorder.command;

import com.ai.bss.api.product.dto.RentOffer;

public class StartRentOrderItemCommand  extends AbstractOrderItemCommand {
	private RentOffer offer;
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public RentOffer getOffer() {
		return offer;
	}

	public void setOffer(RentOffer offer) {
		this.offer = offer;
	}
}
