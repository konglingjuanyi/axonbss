package com.ai.bss.api.party.command;

import com.ai.bss.api.party.PartyId;

public abstract class CreatePartyCommand extends PartyCommand {

	public CreatePartyCommand(PartyId partyId) {
		super(partyId);
	}
}
