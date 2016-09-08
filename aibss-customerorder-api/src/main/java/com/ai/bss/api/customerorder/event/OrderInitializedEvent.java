package com.ai.bss.api.customerorder.event;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.api.product.dto.BuyOffer;

public class OrderInitializedEvent extends AbstractCustomerOrderEvent {
	private Set<BuyOffer> offers=new LinkedHashSet<>();
	public OrderInitializedEvent() {
	}
	public Set<BuyOffer> getOffers() {
		return offers;
	}

	public void setOffers(Set<BuyOffer> offers) {
		this.offers = offers;
	}
	
	public void addOffer(BuyOffer offer) {
		this.offers.add(offer);
	}

}
