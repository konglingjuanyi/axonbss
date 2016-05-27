package com.ai.bss.api.party.command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ai.bss.api.party.PartyId;

public abstract class IndividualCommand extends PartyCommand{
	@NotNull
    @Size(min = 1)	
	private String firstName;
	@NotNull
    @Size(min = 1)	
	private String lastName;
	
	protected IndividualCommand(PartyId partyId){
		super(partyId);
	}

	protected IndividualCommand(PartyId partyId, String firstName,String lastName) {
		super(partyId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
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
