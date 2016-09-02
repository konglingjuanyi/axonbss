package com.ai.bss.aggregate.customerorder;

import java.util.LinkedHashSet;
import java.util.Set;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import com.ai.bss.api.customerorder.CustomerOrderId;

public class CustomerOrder extends AbstractAnnotatedAggregateRoot {
	@AggregateIdentifier
	private CustomerOrderId customerOrderId;
	private String state;
	private String customerId;
	private Set<CustomerOrderItem> orderItems=new LinkedHashSet<CustomerOrderItem>();
	
	public CustomerOrder(){
		
	}
	
	public CustomerOrderId getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(CustomerOrderId customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Set<CustomerOrderItem> getOrderItems() {
		return orderItems;
	}
}
