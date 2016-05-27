package com.ai.bss.api.party.command;

import com.ai.bss.api.party.PartyId;

public class TerminateOrganizationCommand extends OrganizationCommand {

	public TerminateOrganizationCommand(PartyId partyId) {
		super(partyId);
	}
}
