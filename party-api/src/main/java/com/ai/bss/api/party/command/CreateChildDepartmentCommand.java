package com.ai.bss.api.party.command;

import javax.validation.constraints.NotNull;

import com.ai.bss.api.party.PartyId;
public class CreateChildDepartmentCommand extends OrganizationCommand{
	@NotNull
	private String parentDepartmentId;
	public CreateChildDepartmentCommand(PartyId partyId, String tradingName,String parentDepartmentId) {
		super(partyId,tradingName);
		this.parentDepartmentId=parentDepartmentId;
	}
	public String getParentDepartmentId() {
		return parentDepartmentId;
	}
	public void setParentDepartmentId(String parentDepartmentId) {
		this.parentDepartmentId = parentDepartmentId;
	}


}
