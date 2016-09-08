package com.ai.bss.api.product.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.api.product.OfferInstanceId;

public class UnsubscribeBuyOffer {

	public UnsubscribeBuyOffer() {
		// TODO Auto-generated constructor stub
	}
	private OfferInstanceId offerInstanceId;
	private Set<Price> oneTimeFees = new LinkedHashSet<Price>();
	
	public OfferInstanceId getOfferInstanceId() {
		return offerInstanceId;
	}
	public void setOfferInstanceId(OfferInstanceId offerInstanceId) {
		this.offerInstanceId = offerInstanceId;
	}
	public Set<Price> getOneTimeFees() {
		return oneTimeFees;
	}
	public void addOneTimeFee(Price oneTimeFee) {
		oneTimeFees.add(oneTimeFee);
	}
	
	public void setOneTimeFees(Set<Price> oneTimeFees) {
		this.oneTimeFees = oneTimeFees;
	}

}
