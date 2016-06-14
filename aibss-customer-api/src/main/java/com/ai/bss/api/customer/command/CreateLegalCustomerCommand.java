package com.ai.bss.api.customer.command;

import com.ai.bss.api.customer.CustomerId;

public class CreateLegalCustomerCommand extends CreateCustomerCommand {
	private String parentLegalId;
	private String legalName;
	public CreateLegalCustomerCommand(CustomerId customerId,String legalName) {
		super(customerId);
		this.legalName=legalName;
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

}
