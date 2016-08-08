package com.ai.bss.api.party.event;

import com.ai.bss.api.party.PartyId;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class IndividualCreatedEvent extends PartyCreatedEvent{
	private String firstName;
	private String lastName;	
	public IndividualCreatedEvent(){}
	
	public IndividualCreatedEvent(PartyId partyId){
		super(partyId);
	}

	public IndividualCreatedEvent(PartyId partyId,String firstName,String lastName) {
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
	@JsonIgnore
	public String getPartyName() {
		StringBuffer name=new StringBuffer();
		name.append(this.getLastName()).append(" ").append(this.getFirstName());
		return name.toString();
	}

}
