package com.ai.bss.api.party.command;

import com.ai.bss.api.party.PartyId;

public class TerminateDepartmentCommand extends TerminatePartyCommand {

	public TerminateDepartmentCommand(PartyId partyId) {
		super(partyId);
	}
}
