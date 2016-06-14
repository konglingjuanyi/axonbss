package com.ai.bss.api.customer.command;

import com.ai.bss.api.customer.CustomerId;
import com.ai.bss.api.party.PartyId;

public class CreateCustomerFromPartyCommand extends CreateCustomerCommand{
	private PartyId partyId;

	public CreateCustomerFromPartyCommand(CustomerId customerId,PartyId partyId) {
		super(customerId);
		this.partyId=partyId;
	}

	public PartyId getPartyId() {
		return partyId;
	}

	public void setPartyId(PartyId partyId) {
		this.partyId = partyId;
	}

}
