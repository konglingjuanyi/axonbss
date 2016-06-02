package com.ai.bss.api.party.command;

import com.ai.bss.api.party.PartyId;

public class TerminateIndividualCommand extends TerminatePartyCommand {

	public TerminateIndividualCommand(PartyId partyId) {
		super(partyId);
	}
}
