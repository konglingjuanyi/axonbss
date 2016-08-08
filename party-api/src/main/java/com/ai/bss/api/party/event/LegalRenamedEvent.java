package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class LegalRenamedEvent extends PartyRenamedEvent{
	private String tradingName;
	public LegalRenamedEvent(){}
	public LegalRenamedEvent(PartyId partyId,String tradingName) {
		super(partyId);
		this.tradingName=tradingName;
	}

	public String getTradingName() {
		return tradingName;
	}

	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}

	@Override
	@JsonIgnore
	public String getPartyName() {
		return this.tradingName;
	}
}
