package com.ai.bss.api.party.command;

import com.ai.bss.api.party.PartyId;

public class RenameIndividualCommand extends IndividualCommand {

	public RenameIndividualCommand(PartyId partyId, String firstName,String lastName) {
		super(partyId,firstName,lastName);
	}

}
