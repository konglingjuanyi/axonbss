package com.ai.bss.webui.customer.model;

public class IndividualCustomer extends Customer {
	private String firstName;
	private String lastName;
	public IndividualCustomer() {
		// TODO Auto-generated constructor stub
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
