package com.ai.bss.webui.customer.model;

public class LegalCustomer extends Customer {
	private String parentLegalId;
	private String parentLegalName;
	private String legalName;
	public LegalCustomer() {
		// TODO Auto-generated constructor stub
	}
	public String getParentLegalId() {
		return parentLegalId;
	}
	public void setParentLegalId(String parentLegalId) {
		this.parentLegalId = parentLegalId;
	}
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	public String getParentLegalName() {
		return parentLegalName;
	}
	public void setParentLegalName(String parentLegalName) {
		this.parentLegalName = parentLegalName;
	}

}
