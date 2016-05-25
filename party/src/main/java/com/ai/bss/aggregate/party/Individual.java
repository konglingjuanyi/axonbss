package com.ai.bss.aggregate.party;

import org.axonframework.eventhandling.annotation.EventHandler;

import com.ai.bss.api.party.PartyId;
import com.ai.bss.api.party.event.IndividualCreatedEvent;

public class Individual extends Party {
	private String firstName;
	private String lastName;	

	public Individual(){
		
	}
	
	public Individual(PartyId partyId,String firstName,String lastName){
		apply(new IndividualCreatedEvent(partyId, firstName,lastName));
	}

	@EventHandler
	public void onIndividualCreated(IndividualCreatedEvent event){
		this.setPartyId(event.getPartyId());
		this.setState("Initial");
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
	public String getName() {
		StringBuffer name=new StringBuffer();
		name.append(this.getLastName()).append(" ").append(this.getFirstName());
		return name.toString();
	}
}
