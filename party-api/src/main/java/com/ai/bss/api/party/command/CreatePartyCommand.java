package com.ai.bss.api.party.command;

import org.axonframework.common.Assert;

import com.ai.bss.api.party.PartyId;

public abstract class CreatePartyCommand {
	private PartyId partyId;

	
	public CreatePartyCommand(PartyId partyId) {
		Assert.notNull(partyId, "The provided partyId cannot be null");
		this.partyId=partyId;
	}

	public PartyId getPartyId() {
		return partyId;
	}

	public void setPartyId(PartyId partyId) {
		this.partyId = partyId;
	}

	public abstract String getName();

}
