package com.ai.bss.webui.party.model;

public class Individual extends Party {
	private String firstName;
	private String lastName;	

	public Individual(){
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
