package com.ai.bss.api.shoppingcart.event;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.api.base.CharacteristicValue;
import com.ai.bss.api.product.dto.ProductCharacteristicValue;

public class ShoppingCartItemAddedEvent extends ShoppingCartItemEvent{
	public ShoppingCartItemAddedEvent() {
		// TODO Auto-generated constructor stub
	}
	private String offeringId;
	private int quantity;
	private long price;  
	private long offeringUnitPrice;
	private Set<CharacteristicValue> offerCharacterValues = new LinkedHashSet<CharacteristicValue>();
	private Set<ProductCharacteristicValue> productCharacterValues = new LinkedHashSet<ProductCharacteristicValue>();

	public String getOfferingId() {
		return offeringId;
	}
	public void setOfferingId(String offeringId) {
		this.offeringId = offeringId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	public void setOfferCharacterValues(Set<CharacteristicValue> offerCharacterValues){
		this.offerCharacterValues=offerCharacterValues;
	}
	
	public Set<CharacteristicValue> getOfferCharacterValues(){
		return this.offerCharacterValues;
	}
	
	public void setProductCharacterValues(Set<ProductCharacteristicValue> productCharacterValues){
		this.productCharacterValues=productCharacterValues;
	}
	
	public Set<ProductCharacteristicValue> getProductCharacterValues(){
		return this.productCharacterValues;
	}
	public long getOfferingUnitPrice() {
		return offeringUnitPrice;
	}
	public void setOfferingUnitPrice(long offeringUnitPrice) {
		this.offeringUnitPrice = offeringUnitPrice;
	}

}
