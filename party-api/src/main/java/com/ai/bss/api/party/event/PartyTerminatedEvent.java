package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;

public abstract class PartyTerminatedEvent extends PartyEvent{
	protected PartyTerminatedEvent(){}
	public PartyTerminatedEvent(PartyId partyId) {
		super(partyId);
	}

}
