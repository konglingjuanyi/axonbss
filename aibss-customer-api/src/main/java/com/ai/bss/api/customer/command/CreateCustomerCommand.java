package com.ai.bss.api.customer.command;

import com.ai.bss.api.customer.CustomerId;

public abstract class CreateCustomerCommand {
	private CustomerId customerId;
	private String serviceCode;
	private String servicePassword;
	public CreateCustomerCommand(CustomerId customerId) {
		this.customerId=customerId;
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
}
