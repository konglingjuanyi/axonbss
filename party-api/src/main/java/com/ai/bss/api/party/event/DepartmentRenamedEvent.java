package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;

public class DepartmentRenamedEvent extends PartyRenamedEvent{
	private String departmentName;
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
	public String getPartyName() {
		return this.departmentName;
	}
}
