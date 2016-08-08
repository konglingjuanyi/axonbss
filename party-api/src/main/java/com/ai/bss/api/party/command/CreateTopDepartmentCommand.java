package com.ai.bss.api.party.command;

import javax.validation.constraints.NotNull;

import com.ai.bss.api.party.PartyId;
public class CreateTopDepartmentCommand extends CreatePartyCommand{
	@NotNull
	private String legalId;
	private String departmentName;
	public CreateTopDepartmentCommand(){}
	
	public CreateTopDepartmentCommand(PartyId partyId, String departmentName,String legalId) {
		super(partyId);
		this.legalId=legalId;
		this.departmentName=departmentName;
	}
	public String getLegalId() {
		return legalId;
	}
	public void setLegalId(String legalId) {
		this.legalId = legalId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
