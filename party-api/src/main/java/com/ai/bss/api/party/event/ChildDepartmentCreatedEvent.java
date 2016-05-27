package com.ai.bss.api.party.event;

import javax.validation.constraints.NotNull;

import com.ai.bss.api.party.PartyId;

public class ChildDepartmentCreatedEvent extends OrganizationEvent {
	@NotNull
	private String parentDepartmentId;
	public ChildDepartmentCreatedEvent(PartyId partyId) {
		super(partyId);
	}

	public ChildDepartmentCreatedEvent(PartyId partyId, String departmentName,String parentDepartmentId) {
		super(partyId, departmentName);
		this.parentDepartmentId=parentDepartmentId;
	}

	@Override
	public String getPartyType() {
		return "Department";
	}

	public String getParentDepartmentId() {
		return parentDepartmentId;
	}

	public void setParentDepartmentId(String parentDepartmentId) {
		this.parentDepartmentId = parentDepartmentId;
	}


}
