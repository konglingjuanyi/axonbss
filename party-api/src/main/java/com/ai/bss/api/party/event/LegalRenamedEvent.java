package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;

public class LegalRenamedEvent extends PartyRenamedEvent{
	private String tradingName;
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
	public String getPartyName() {
		return this.tradingName;
	}
}
