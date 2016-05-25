package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;

public class IndividualCreatedEvent extends IndividualEvent{

	public IndividualCreatedEvent(PartyId partyId,String firstName,String lastName) {
		super(partyId,firstName,lastName);
	}
}
