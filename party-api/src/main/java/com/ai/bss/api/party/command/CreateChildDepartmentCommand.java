package com.ai.bss.api.party.command;

import javax.validation.constraints.NotNull;

import com.ai.bss.api.party.PartyId;
public class CreateChildDepartmentCommand extends CreatePartyCommand{
	@NotNull
	private String parentDepartmentId;
	private String departmentName;
	public CreateChildDepartmentCommand(PartyId partyId,String departmentName,String parentDepartmentId) {
		super(partyId);
		this.parentDepartmentId=parentDepartmentId;
		this.departmentName=departmentName;
	}
	public String getParentDepartmentId() {
		return parentDepartmentId;
	}
	public void setParentDepartmentId(String parentDepartmentId) {
		this.parentDepartmentId = parentDepartmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
