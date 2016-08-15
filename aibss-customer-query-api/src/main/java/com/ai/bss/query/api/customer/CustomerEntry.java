package com.ai.bss.query.api.customer;


import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

import com.ai.bss.query.api.party.IndividualEntry;
import com.ai.bss.query.api.party.PartyEntry;
import com.ai.bss.query.api.party.PartyRoleEntry;


@Entity
@PrimaryKeyJoinColumn(name="CUST_ID")
@SecondaryTable(
	    name = "CM_CUSTOMER",
	    pkJoinColumns = @PrimaryKeyJoinColumn(name = "CUST_ID")
	)
@DiscriminatorValue("Customer")
public class CustomerEntry  extends PartyRoleEntry{
	
	@Basic
	@Column(table="CM_CUSTOMER",name="IS_INDIVIDUAL")
	private String type;
	@Basic
	@Column(table="CM_CUSTOMER",name="CUSTOMER_NAME")
	private String customerName;
	private String serviceCode;
	private String servicePassword;
	private String state;
	private String custSegmentId;
	private String serviceLevel;
	private String brand;
	private Timestamp createDate;
	private Timestamp terminateDate;
	
	public CustomerEntry(){

	}

	public CustomerEntry(String customerId,PartyEntry party) {
		super(customerId,party);
		if (party instanceof IndividualEntry){
			this.type="INDIVIDUAL";
			super.setPartyRoleType("CUSRTOMER.INDIVIDUAL");
		}else{
			this.type="LEGAL";
			super.setPartyRoleType("CUSTOMER.LEGAL");
		}
		customerName= super.getParty().getName();
	}

	public String getCustomerName() {
		return customerName;
	}
	
	public String getCustomerId(){
		return this.getPartyRoleId();
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
