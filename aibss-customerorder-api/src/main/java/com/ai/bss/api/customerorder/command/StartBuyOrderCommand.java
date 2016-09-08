package com.ai.bss.api.customerorder.command;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.api.product.dto.BuyOffer;

public class StartBuyOrderCommand  extends AbstractOrderCommand {
	private Set<BuyOffer> offers=new LinkedHashSet<>();
	private long amount;

	public Set<BuyOffer> getOffers() {
		return offers;
	}

	public void setOffers(Set<BuyOffer> offers) {
		this.offers = offers;
	}
	
	public void addOffer(BuyOffer offer) {
		this.offers.add(offer);
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}


}
