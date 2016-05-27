package com.ai.bss.aggregate.party;

import com.ai.bss.api.party.PartyId;

public abstract class Organization extends Party {

	private String tradingName;
	
	public Organization(PartyId partId,String tradingName){
		this.setPartyId(partyId);
	}

	public String getTradingName() {
		return tradingName;
	}

	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}	

	@Override
	public String getName() {
		return this.getTradingName();
	}
}
