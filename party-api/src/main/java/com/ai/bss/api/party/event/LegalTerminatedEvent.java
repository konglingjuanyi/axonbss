package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;

public class LegalTerminatedEvent extends PartyTerminatedEvent {

	public LegalTerminatedEvent(PartyId partyId) {
		super(partyId);
	}

}
