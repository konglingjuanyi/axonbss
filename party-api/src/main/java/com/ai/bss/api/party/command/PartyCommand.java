package com.ai.bss.api.party.command;

import org.axonframework.common.Assert;

import com.ai.bss.api.party.PartyId;

public abstract class PartyCommand {
	private PartyId partyId;

	
	public PartyCommand(PartyId partyId) {
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
