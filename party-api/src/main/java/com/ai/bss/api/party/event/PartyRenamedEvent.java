package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;

public abstract class PartyRenamedEvent extends PartyEvent {

	public PartyRenamedEvent(PartyId partyId) {
		super(partyId);
	}

	public abstract String getPartyName();
}
