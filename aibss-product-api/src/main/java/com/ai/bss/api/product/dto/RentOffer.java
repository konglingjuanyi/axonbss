package com.ai.bss.api.product.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.api.base.TimePeriod;

public class RentOffer extends BuyOffer{

	public RentOffer() {
	}
	
	private Set<Price> appliedCharges = new LinkedHashSet<Price>();
	private TimePeriod validPeriod;

	public TimePeriod getValidPeriod() {
		return validPeriod;
	}
	public void setValidPeriod(TimePeriod validPeriod) {
		this.validPeriod = validPeriod;
	}

	public Set<Price> getAppliedCharges() {
		return appliedCharges;
	}
	public void setAppliedCharges(Set<Price> appliedCharges) {
		this.appliedCharges = appliedCharges;
	}
	public void addAppliedCharge(Price appliedCharge) {
		appliedCharges.add(appliedCharge);
	}
}
