package com.ai.bss.api.party.command;

import com.ai.bss.api.party.PartyId;

public class RenameIndividualCommand extends IndividualCommand {
	private String oldFirstName;
	private String oldLastName;
	public RenameIndividualCommand(PartyId partyId, String firstName,String lastName) {
		super(partyId,firstName,lastName);
	}
	public String getOldFirstName() {
		return oldFirstName;
	}
	public void setOldFirstName(String oldFirstName) {
		this.oldFirstName = oldFirstName;
	}
	public String getOldLastName() {
		return oldLastName;
	}
	public void setOldLastName(String oldLastName) {
		this.oldLastName = oldLastName;
	}

}
