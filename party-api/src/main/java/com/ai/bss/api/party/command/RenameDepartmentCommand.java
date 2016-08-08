package com.ai.bss.api.party.command;

import com.ai.bss.api.party.PartyId;

public class RenameDepartmentCommand extends RenamePartyCommand {
	private String oldDepartmentName;
	private String newDepartmentName;
	
	public RenameDepartmentCommand(){}
	
	public RenameDepartmentCommand(PartyId partyId, String newTradingName) {
		super(partyId);
		this.newDepartmentName=newTradingName;
	}
	public String getOldDepartmentName() {
		return oldDepartmentName;
	}
	public void setOldDepartmentName(String oldDepartmentName) {
		this.oldDepartmentName = oldDepartmentName;
	}
	public String getNewDepartmentName() {
		return newDepartmentName;
	}
	public void setNewDepartmentName(String newDepartmentName) {
		this.newDepartmentName = newDepartmentName;
	}


}
