package com.ai.bss.api.party.command;

import com.ai.bss.api.party.PartyId;

public class RenameIndividualCommand extends RenamePartyCommand {
	private String oldFirstName;
	private String oldLastName;
	private String newFirstName;
	private String newLastName;
	public RenameIndividualCommand(PartyId partyId, String newFirstName,String newLastName) {
		super(partyId);
		this.newFirstName=newFirstName;
		this.newLastName=newLastName;
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
	public String getNewFirstName() {
		return newFirstName;
	}
	public void setNewFirstName(String newFirstName) {
		this.newFirstName = newFirstName;
	}
	public String getNewLastName() {
		return newLastName;
	}
	public void setNewLastName(String newLastName) {
		this.newLastName = newLastName;
	}

}
