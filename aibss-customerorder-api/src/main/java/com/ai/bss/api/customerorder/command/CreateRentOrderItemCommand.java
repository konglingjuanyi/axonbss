package com.ai.bss.api.customerorder.command;

import com.ai.bss.api.product.dto.RentOffer;

public class CreateRentOrderItemCommand extends AbstractOrderItemCommand{
	private RentOffer rentOffer;
	public CreateRentOrderItemCommand() {
		
	}
	public RentOffer getRentOffer() {
		return rentOffer;
	}
	public void setRentOffer(RentOffer rentOffer) {
		this.rentOffer = rentOffer;
	}

}
