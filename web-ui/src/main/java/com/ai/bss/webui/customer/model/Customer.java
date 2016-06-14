package com.ai.bss.webui.customer.model;

import java.sql.Timestamp;

public class Customer {
	private String customerId;
	private String partyId;
	private String customerName;
	private String serviceCode;
	private String servicePassword;
	private String state;
	private String custSegmentId;
	private String serviceLevel;
	private String brand;
	private Timestamp createDate;
	private Timestamp terminateDate;

	public Customer() {
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCustSegmentId() {
		return custSegmentId;
	}

	public void setCustSegmentId(String custSegmentId) {
		this.custSegmentId = custSegmentId;
	}

	public String getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getTerminateDate() {
		return terminateDate;
	}

	public void setTerminateDate(Timestamp terminateDate) {
		this.terminateDate = terminateDate;
	}

}
