package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;

public class LegalCreatedEvent extends OrganizationEvent {
	private String parentLegalId;
	public LegalCreatedEvent(PartyId partyId) {
		super(partyId);
	}

	public LegalCreatedEvent(PartyId partyId, String tradingName) {
		super(partyId, tradingName);
	}

	@Override
	public String getPartyType() {
		return "Legal";
	}

	public String getParentLegalId() {
		return parentLegalId;
	}

	public void setParentLegalId(String parentLegalId) {
		this.parentLegalId = parentLegalId;
	}

}
