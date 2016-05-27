package com.ai.bss.api.party.event;

import javax.validation.constraints.NotNull;

import com.ai.bss.api.party.PartyId;

public class TopDepartmentCreatedEvent extends OrganizationEvent {
	@NotNull
	private String legalId;
	public TopDepartmentCreatedEvent(PartyId partyId) {
		super(partyId);
	}

	public TopDepartmentCreatedEvent(PartyId partyId, String departmentName,String legalId) {
		super(partyId, departmentName);
		this.legalId=legalId;
	}

	@Override
	public String getPartyType() {
		return "Department";
	}

	public String getLegalId() {
		return legalId;
	}

	public void setLegalId(String legalId) {
		this.legalId = legalId;
	}

}
