package com.ai.bss.api.customerorder.command;

import com.ai.bss.api.product.dto.UnsubscribeBuyOffer;

public class StartUnSubscribeBuyOrderCommand  extends AbstractOrderCommand {
	private UnsubscribeBuyOffer unsubscribeOffer;
	public StartUnSubscribeBuyOrderCommand() {
		// TODO Auto-generated constructor stub
	}
	public UnsubscribeBuyOffer getUnsubscribeOffer() {
		return unsubscribeOffer;
	}
	public void setUnsubscribeOffer(UnsubscribeBuyOffer unsubscribeOffer) {
		this.unsubscribeOffer = unsubscribeOffer;
	}
	

}
