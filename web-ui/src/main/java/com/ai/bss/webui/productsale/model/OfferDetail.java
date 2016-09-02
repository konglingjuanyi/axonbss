package com.ai.bss.webui.productsale.model;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.api.base.CharacteristicValue;
import com.ai.bss.api.product.dto.ProductCharacteristicValue;

public class OfferDetail {
	private String offeringId;
	private String name;
	private long price;  
	private Set<CharacteristicValue> offerCharacterValues = new LinkedHashSet<CharacteristicValue>();
	private Set<ProductCharacteristicValue> productCharacterValues = new LinkedHashSet<ProductCharacteristicValue>();

	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	public void addOfferCharacterValue(CharacteristicValue offerCharacterValue){
		this.offerCharacterValues.add(offerCharacterValue);
	}
	
	public Set<CharacteristicValue> getOfferCharacterValues(){
		return this.offerCharacterValues;
	}
	
	public void addProductCharacterValue(ProductCharacteristicValue productCharacterValue){
		this.productCharacterValues.add(productCharacterValue);
	}
	
	public Set<ProductCharacteristicValue> getProductCharacterValues(){
		return this.productCharacterValues;
	}
	public String getOfferingId() {
		return offeringId;
	}
	public void setOfferingId(String offeringId) {
		this.offeringId = offeringId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
