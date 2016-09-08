package com.ai.bss.api.customerorder.event;
import com.ai.bss.api.product.dto.BuyOffer;

public class BuyOrderItemCreatedEvent extends AbstractCustomerOrderItemEvent {
	private BuyOffer buyOffer;
	public BuyOrderItemCreatedEvent() {
		
	}
	public BuyOffer getBuyOffer() {
		return buyOffer;
	}
	public void setBuyOffer(BuyOffer buyOffer) {
		this.buyOffer = buyOffer;
	}

}
