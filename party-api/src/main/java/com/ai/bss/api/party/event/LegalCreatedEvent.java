package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class LegalCreatedEvent extends PartyCreatedEvent{
	private String tradingName;
	public LegalCreatedEvent(){}
	public LegalCreatedEvent(PartyId partyId){
		super(partyId);
	}

	public LegalCreatedEvent(PartyId partyId,String tradingName) {
		super(partyId);
		this.tradingName=tradingName;
	}


	@Override
	@JsonIgnore
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
