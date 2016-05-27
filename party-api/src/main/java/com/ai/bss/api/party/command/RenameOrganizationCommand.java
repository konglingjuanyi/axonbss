package com.ai.bss.api.party.command;

import com.ai.bss.api.party.PartyId;

public class RenameOrganizationCommand extends OrganizationCommand {
	private String oldTradingName;
	public RenameOrganizationCommand(PartyId partyId, String tradingName) {
		super(partyId,tradingName);
	}
	public String getOldTradingName() {
		return oldTradingName;
	}
	public void setOldTradingName(String oldTradingName) {
		this.oldTradingName = oldTradingName;
	}

}
