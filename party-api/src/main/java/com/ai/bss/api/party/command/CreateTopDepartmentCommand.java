package com.ai.bss.api.party.command;

import javax.validation.constraints.NotNull;

import com.ai.bss.api.party.PartyId;
public class CreateTopDepartmentCommand extends OrganizationCommand{
	@NotNull
	private String legalId;
	public CreateTopDepartmentCommand(PartyId partyId, String tradingName,String legalId) {
		super(partyId,tradingName);
		this.legalId=legalId;
	}
	public String getLegalId() {
		return legalId;
	}
	public void setLegalId(String legalId) {
		this.legalId = legalId;
	}

}
