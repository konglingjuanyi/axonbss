package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class IndividualRenamedEvent extends PartyCreatedEvent{
	private String oldFirstName;
	private String oldLastName;
	private String newFirstName;
	private String newLastName;
	public IndividualRenamedEvent(){}
	public IndividualRenamedEvent(PartyId partyId,String newFirstName,String newLastName) {
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
	@Override
	@JsonIgnore
	public String getPartyName() {
		StringBuffer name=new StringBuffer();
		name.append(this.getNewLastName()).append(" ").append(this.getNewFirstName());
		return name.toString();
	}
}
