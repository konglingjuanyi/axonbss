package com.ai.bss.aggregate.customer;

import java.sql.Timestamp;

import org.axonframework.eventhandling.annotation.EventHandler;

import com.ai.bss.aggregate.party.PartyRole;
import com.ai.bss.api.customer.CustomerId;
import com.ai.bss.api.customer.event.CustomerCreatedEvent;
import com.ai.bss.api.party.PartyId;

public class Customer extends PartyRole {
	private CustomerId customerId;
	private String custSegmentId;
	private String serviceCode;
	private String servicePassword;
	private String brand;
	private Timestamp activeDate;
	private Timestamp terminateDate;
	private String status;
	
	private Customer(){
		
	}
	
	public Customer(CustomerId customerId,PartyId partyId,String serviceCode,String servicePassword){
		super(customerId, partyId);		
		CustomerCreatedEvent event=new CustomerCreatedEvent();
		event.setPartyId(partyId);
		event.setCustomerId(customerId);
		event.setServiceCode(serviceCode);
		event.setServicePassword(servicePassword);
		apply(event);
	}
	
	@EventHandler
	public void onCustomerCreated(CustomerCreatedEvent event){
		this.customerId=event.getCustomerId();
		this.serviceCode=event.getServiceCode();
		this.servicePassword=event.getServicePassword();
	}

	public String getCustSegmentId() {
		return custSegmentId;
	}

	public void setCustSegmentId(String custSegmentId) {
		this.custSegmentId = custSegmentId;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Timestamp getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Timestamp activeDate) {
		this.activeDate = activeDate;
	}

	public Timestamp getTerminateDate() {
		return terminateDate;
	}

	public void setTerminateDate(Timestamp terminateDate) {
		this.terminateDate = terminateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CustomerId getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerId customerId) {
		this.customerId = customerId;
	}
}
