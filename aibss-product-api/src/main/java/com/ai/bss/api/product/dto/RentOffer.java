package com.ai.bss.api.product.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.api.base.TimePeriod;

public class RentOffer extends Offer{

	public RentOffer() {
	}
	private Set<Price> prices = new LinkedHashSet<Price>();
	private TimePeriod validPeriod;
	public Set<Price> getPrices() {
		return prices;
	}
	public void setPrices(Set<Price> prices) {
		this.prices = prices;
	}
	public TimePeriod getValidPeriod() {
		return validPeriod;
	}
	public void setValidPeriod(TimePeriod validPeriod) {
		this.validPeriod = validPeriod;
	}
}
