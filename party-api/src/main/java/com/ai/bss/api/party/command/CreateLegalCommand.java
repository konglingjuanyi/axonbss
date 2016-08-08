package com.ai.bss.api.party.command;

import com.ai.bss.api.party.PartyId;
public class CreateLegalCommand extends CreatePartyCommand{
	private String parentLegalId;
	private String legalName;
	
	public CreateLegalCommand(){}
	
	public CreateLegalCommand(PartyId partyId, String legalName) {
		super(partyId);
		this.legalName=legalName;
	}
	public String getParentLegalId() {
		return parentLegalId;
	}
	public void setParentLegalId(String parentLegalId) {
		this.parentLegalId = parentLegalId;
	}
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}


}
