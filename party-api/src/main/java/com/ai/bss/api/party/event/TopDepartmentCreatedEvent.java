package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;

public class TopDepartmentCreatedEvent extends PartyCreatedEvent {
	private String legalId;
	private String departmentName;
	public TopDepartmentCreatedEvent(PartyId partyId) {
		super(partyId);
	}

	public TopDepartmentCreatedEvent(PartyId partyId, String departmentName,String legalId) {
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

	@Override
	public String getPartyName() {
		return this.departmentName;
	}

}
