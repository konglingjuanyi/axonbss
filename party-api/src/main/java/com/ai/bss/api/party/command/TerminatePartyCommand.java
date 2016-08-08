package com.ai.bss.api.party.command;

import com.ai.bss.api.party.PartyId;

public abstract class TerminatePartyCommand extends PartyCommand {

	public TerminatePartyCommand(){}
	public TerminatePartyCommand(PartyId partyId) {
		super(partyId);
	}

}
