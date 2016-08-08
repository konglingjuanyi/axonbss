package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;

public class IndividualTerminatedEvent extends PartyTerminatedEvent {
	public IndividualTerminatedEvent(){}
	public IndividualTerminatedEvent(PartyId partyId) {
		super(partyId);
	}

}
