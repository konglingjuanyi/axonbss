package com.ai.bss.api.customerorder.command;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.api.product.dto.RentOffer;

public class StartRentOrderCommand  extends AbstractOrderCommand {
	private Set<RentOffer> offers=new LinkedHashSet<>();
	private long amount;

	public Set<RentOffer> getOffers() {
		return offers;
	}

	public void setOffers(Set<RentOffer> offers) {
		this.offers = offers;
	}
	
	public void addOffer(RentOffer offer) {
		this.offers.add(offer);
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
}
