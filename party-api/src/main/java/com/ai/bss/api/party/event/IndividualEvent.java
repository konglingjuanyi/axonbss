package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;

public abstract class IndividualEvent extends PartyEvent{
	private String firstName;
	private String lastName;	
	
	public IndividualEvent(PartyId partyId){
		super(partyId);
	}

	public IndividualEvent(PartyId partyId,String firstName,String lastName) {
		super(partyId);
		this.firstName=firstName;
		this.lastName=lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String getPartyName() {
		StringBuffer name=new StringBuffer();
		name.append(this.getLastName()).append(" ").append(this.getFirstName());
		return name.toString();
	}
	
	@Override
	public String getPartyType() {
		return "Individual";
	}

}
