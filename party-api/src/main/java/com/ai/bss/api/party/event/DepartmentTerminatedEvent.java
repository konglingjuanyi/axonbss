package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;

public class DepartmentTerminatedEvent extends PartyTerminatedEvent {

	public DepartmentTerminatedEvent(PartyId partyId) {
		super(partyId);
	}
	
}
