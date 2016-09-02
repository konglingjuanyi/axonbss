package com.ai.bss.api.customerorder.command;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.api.base.BaseCommand;
import com.ai.bss.api.base.CharacteristicValue;
import com.ai.bss.api.customerorder.CustomerOrderItemId;

public abstract class AbstractOrderItemCommand extends BaseCommand {
	private CustomerOrderItemId customerOrderItemId;
	private Set<CharacteristicValue> orderCharacterValues =new LinkedHashSet<>();
	private long totalPriceAfterDiscount;
	private long discount;
	
	public AbstractOrderItemCommand() {
		
	}
	public Set<CharacteristicValue> getOrderCharacterValues() {
		return orderCharacterValues;
	}
	public void setOrderCharacterValues(Set<CharacteristicValue> orderCharacterValues) {
		this.orderCharacterValues = orderCharacterValues;
	}
	public CustomerOrderItemId getCustomerOrderItemId() {
		return customerOrderItemId;
	}
	public void setCustomerOrderItemId(CustomerOrderItemId customerOrderItemId) {
		this.customerOrderItemId = customerOrderItemId;
	}
	public long getTotalPriceAfterDiscount() {
		return totalPriceAfterDiscount;
	}
	public void setTotalPriceAfterDiscount(long totalPrice) {
		this.totalPriceAfterDiscount = totalPrice;
	}
	public long getDiscount() {
		return discount;
	}
	public void setDiscount(long discount) {
		this.discount = discount;
	}

}
