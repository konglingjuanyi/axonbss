package com.ai.bss.aggregate.customer;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import com.ai.bss.api.customer.CustomerAccountId;
import com.ai.bss.api.party.PartyRoleId;

public class CustomerAccount extends AbstractAnnotatedAggregateRoot {
	@AggregateIdentifier
	private CustomerAccountId customerAccountId;
	private String name;
	public CustomerAccountId getCustomerAccountId() {
		return customerAccountId;
	}
	public void setCustomerAccountId(CustomerAccountId customerAccountId) {
		this.customerAccountId = customerAccountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
