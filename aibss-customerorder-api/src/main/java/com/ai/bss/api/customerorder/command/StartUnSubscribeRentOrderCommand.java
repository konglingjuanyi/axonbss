package com.ai.bss.api.customerorder.command;

import com.ai.bss.api.product.dto.UnsubscribeRentOffer;

public class StartUnSubscribeRentOrderCommand  extends AbstractOrderCommand {
	private UnsubscribeRentOffer unsubscribeOffer;
	public StartUnSubscribeRentOrderCommand() {
		// TODO Auto-generated constructor stub
	}
	public UnsubscribeRentOffer getUnsubscribeOffer() {
		return unsubscribeOffer;
	}
	public void setUnsubscribeOffer(UnsubscribeRentOffer unsubscribeOffer) {
		this.unsubscribeOffer = unsubscribeOffer;
	}
	

}
