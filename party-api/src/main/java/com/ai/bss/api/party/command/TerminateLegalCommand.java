package com.ai.bss.api.party.command;

import com.ai.bss.api.party.PartyId;

public class TerminateLegalCommand extends TerminatePartyCommand {
	public TerminateLegalCommand(){}
	public TerminateLegalCommand(PartyId partyId) {
		super(partyId);
	}
}
