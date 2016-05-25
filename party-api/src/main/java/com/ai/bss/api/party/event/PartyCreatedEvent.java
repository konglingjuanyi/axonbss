package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;

public abstract class PartyCreatedEvent {
	private PartyId partyId;
	protected PartyCreatedEvent(PartyId partyId,String partyType) {
		this.partyId=partyId;
	}
	
	
	public PartyId getPartyId() {
		return partyId;
	}
	public void setPartyId(PartyId partyId) {
		this.partyId = partyId;
	}
	
	public abstract String getPartyName();
	public abstract String getPartyType();
}
