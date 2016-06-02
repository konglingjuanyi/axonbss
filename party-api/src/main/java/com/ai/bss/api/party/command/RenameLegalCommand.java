package com.ai.bss.api.party.command;

import com.ai.bss.api.party.PartyId;

public class RenameLegalCommand extends RenamePartyCommand {
	private String oldLegalName;
	private String newLegalName;
	public RenameLegalCommand(PartyId partyId, String newTradingName) {
		super(partyId);
		this.newLegalName=newTradingName;
	}
	public String getOldLegalName() {
		return oldLegalName;
	}
	public void setOldLegalName(String oldLegalName) {
		this.oldLegalName = oldLegalName;
	}
	public String getNewLegalName() {
		return newLegalName;
	}
	public void setNewLegalName(String newLegalName) {
		this.newLegalName = newLegalName;
	}


}
