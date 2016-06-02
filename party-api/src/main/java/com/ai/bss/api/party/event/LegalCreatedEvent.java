package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;

public class LegalCreatedEvent extends PartyCreatedEvent{
	private String tradingName;
	
	public LegalCreatedEvent(PartyId partyId){
		super(partyId);
	}

	public LegalCreatedEvent(PartyId partyId,String tradingName) {
		super(partyId);
		this.tradingName=tradingName;
	}


	@Override
	public String getPartyName() {
		return tradingName;
	}

	public String getTradingName() {
		return tradingName;
	}

	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}

}
