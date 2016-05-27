package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;

public abstract class OrganizationEvent extends PartyEvent{
	private String tradingName;
	
	public OrganizationEvent(PartyId partyId){
		super(partyId);
	}

	public OrganizationEvent(PartyId partyId,String tradingName) {
		super(partyId);
		this.tradingName=tradingName;
	}


	@Override
	public String getPartyName() {
		return tradingName;
	}

}
