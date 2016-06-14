package com.ai.bss.webui.party.model;

public class Party {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String partyId;
	private String name;
	private String state;
	public Party() {
    }
	
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
