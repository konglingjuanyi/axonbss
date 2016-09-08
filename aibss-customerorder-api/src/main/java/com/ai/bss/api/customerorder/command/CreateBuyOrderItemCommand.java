package com.ai.bss.api.customerorder.command;

import com.ai.bss.api.product.dto.BuyOffer;

public class CreateBuyOrderItemCommand extends AbstractOrderItemCommand{
	private BuyOffer buyOffer;
	public CreateBuyOrderItemCommand() {
		
	}
	public BuyOffer getBuyOffer() {
		return buyOffer;
	}
	public void setBuyOffer(BuyOffer buyOffer) {
		this.buyOffer = buyOffer;
	}

}
