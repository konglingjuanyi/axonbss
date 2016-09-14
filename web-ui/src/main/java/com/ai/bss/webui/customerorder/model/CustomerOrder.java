package com.ai.bss.webui.customerorder.model;

import java.util.Set;

import com.ai.bss.api.base.CharacteristicValue;
import com.ai.bss.api.customer.CustomerId;
import com.ai.bss.api.customerorder.CustomerOrderId;

public class CustomerOrder {
	private CustomerId customerId;
	private CustomerOrderId customerOrderId;
	private Set<CustomerOrderItem> orderItems;
	private Set<CharacteristicValue> characterValues;
	public CustomerOrder() {
		// TODO Auto-generated constructor stub
	}
	public CustomerOrderId getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(CustomerOrderId customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public Set<CustomerOrderItem> getOrderItems() {
		return orderItems;
	}
	
	public void addOrderItem(CustomerOrderItem item){
		if (!orderItems.contains(item)){
			orderItems.add(item);
		}
	}
	
	public Set<CharacteristicValue> getCharacterValues() {
		return characterValues;
	}
	
	public void addOCharacterValue(CharacteristicValue value){
		if (!characterValues.contains(value)){
			characterValues.add(value);
		}
	}
	public CustomerId getCustomerId() {
		return customerId;
	}
	public void setCustomerId(CustomerId customerId) {
		this.customerId = customerId;
	}

}
