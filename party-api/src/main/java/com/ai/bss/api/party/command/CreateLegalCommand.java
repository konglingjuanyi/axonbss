package com.ai.bss.api.party.command;

import com.ai.bss.api.party.PartyId;
public class CreateLegalCommand extends OrganizationCommand{
	private String parentLegalId;
	public CreateLegalCommand(PartyId partyId, String tradingName) {
		super(partyId,tradingName);
	}
	public String getParentLegalId() {
		return parentLegalId;
	}
	public void setParentLegalId(String parentLegalId) {
		this.parentLegalId = parentLegalId;
	}

}
