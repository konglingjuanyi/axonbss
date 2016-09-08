package com.ai.bss.api.customerorder.event;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.api.base.BaseEvent;
import com.ai.bss.api.base.CharacteristicValue;
import com.ai.bss.api.customerorder.CustomerOrderId;

public abstract class AbstractCustomerOrderEvent extends BaseEvent {
	private CustomerOrderId customerOrderId;
	private Set<CharacteristicValue> characterValues = new LinkedHashSet<CharacteristicValue>();
	public AbstractCustomerOrderEvent() {
		// TODO Auto-generated constructor stub
	}
	public CustomerOrderId getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(CustomerOrderId customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public Set<CharacteristicValue> getCharacterValues() {
		return characterValues;
	}
	public void setCharacterValues(Set<CharacteristicValue> characterValues) {
		this.characterValues = characterValues;
	}
	
	public void addCharacterValues(CharacteristicValue characterValue) {
		this.characterValues.add(characterValue);
	}

}
