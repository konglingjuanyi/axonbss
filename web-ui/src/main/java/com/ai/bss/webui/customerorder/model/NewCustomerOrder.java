package com.ai.bss.webui.customerorder.model;

import java.util.Set;

import com.ai.bss.api.base.CharacteristicValue;
import com.ai.bss.api.customer.CustomerId;
import com.ai.bss.api.customerorder.CustomerOrderId;
import com.ai.bss.api.product.dto.BuyOffer;

public class NewCustomerOrder {
	private CustomerId customerId;
	private CustomerOrderId customerOrderId;
	private Set<BuyOffer> offers;
	private Set<CharacteristicValue> characterValues;
	public NewCustomerOrder() {
		// TODO Auto-generated constructor stub
	}
	public CustomerOrderId getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(CustomerOrderId customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public Set<BuyOffer> getOffers() {
		return offers;
	}
	
	public void addOffer(BuyOffer offer){
		if (!offers.contains(offer)){
			offers.add(offer);
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
