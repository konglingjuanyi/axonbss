package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;

public class IndividualRenamedEvent extends IndividualEvent{

	public IndividualRenamedEvent(PartyId partyId,String firstName,String lastName) {
		super(partyId,firstName,lastName);
	}
}
