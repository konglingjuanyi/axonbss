package com.ai.bss.api.party.event;

import javax.validation.constraints.NotNull;

import com.ai.bss.api.party.PartyId;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ChildDepartmentCreatedEvent extends PartyCreatedEvent {
	@NotNull
	private String parentDepartmentId;
	private String departmentName;
	public ChildDepartmentCreatedEvent(){}
	
	public ChildDepartmentCreatedEvent(PartyId partyId) {
		super(partyId);
	}

	public ChildDepartmentCreatedEvent(PartyId partyId, String departmentName,String parentDepartmentId) {
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

	@Override
	@JsonIgnore
	public String getPartyName() {
		return this.departmentName;
	}


}
