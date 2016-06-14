package com.ai.bss.api.customer.command;

import com.ai.bss.api.customer.CustomerId;

public class CreateIndividualCustomerCommand extends CreateCustomerCommand {
	private String firstName;
	private String lastName;
	//TODO add more attributes copy from CreateIndividualommand
	
	public CreateIndividualCustomerCommand(CustomerId customerId) {
		super(customerId);
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

}
