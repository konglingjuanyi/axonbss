package com.ai.bss.api.party.command;

import com.ai.bss.api.party.PartyId;

public abstract class RenamePartyCommand extends PartyCommand {

	protected RenamePartyCommand(){}
	public RenamePartyCommand(PartyId partyId) {
		super(partyId);
	}
}
