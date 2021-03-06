package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;

public abstract class PartyCreatedEvent extends PartyEvent {
	protected PartyCreatedEvent(){}
	public PartyCreatedEvent(PartyId partyId) {
		super(partyId);
	}

	public abstract String getPartyName();
}
