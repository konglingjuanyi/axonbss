package com.ai.bss.api.customer.event;

import com.ai.bss.api.customer.CustomerId;
import com.ai.bss.api.party.PartyId;

public class CustomerCreatedEvent {
	private CustomerId customerId;
	private String serviceCode;
	private String servicePassword;
	private PartyId partyId;
	public CustomerCreatedEvent() {
		// TODO Auto-generated constructor stub
	}
	public CustomerId getCustomerId() {
		return customerId;
	}
	public void setCustomerId(CustomerId customerId) {
		this.customerId = customerId;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getServicePassword() {
		return servicePassword;
	}
	public void setServicePassword(String servicePassword) {
		this.servicePassword = servicePassword;
	}
	public PartyId getPartyId() {
		return partyId;
	}
	public void setPartyId(PartyId partyId) {
		this.partyId = partyId;
	}

}
