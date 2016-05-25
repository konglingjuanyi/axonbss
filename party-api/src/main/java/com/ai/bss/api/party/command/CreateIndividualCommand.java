package com.ai.bss.api.party.command;

import com.ai.bss.api.party.PartyId;
import com.ai.bss.services.policy.executor.ICommandHasPolicy;

public class CreateIndividualCommand extends IndividualCommand implements ICommandHasPolicy{
	public CreateIndividualCommand(PartyId partyId, String firstName,String lastName) {
		super(partyId,firstName,lastName);
	}

	@Override
	public String getPolicyPropertyValue() {
		return null;
	}

}
