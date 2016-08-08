package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class DepartmentRenamedEvent extends PartyRenamedEvent{
	private String departmentName;
	public DepartmentRenamedEvent(){}
	public DepartmentRenamedEvent(PartyId partyId,String departmentName) {
		super(partyId);
		this.departmentName=departmentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String tradingName) {
		this.departmentName = tradingName;
	}

	@Override
	@JsonIgnore
	public String getPartyName() {
		return this.departmentName;
	}
}
