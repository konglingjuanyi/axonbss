package com.ai.bss.api.product.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.api.base.CharacteristicValue;

public class BuyOffer {

	public BuyOffer() {
	}
	private String productOfferingId;

	private Set<CharacteristicValue> characterValues = new LinkedHashSet<CharacteristicValue>();
	private Set<Price> oneTimeFees = new LinkedHashSet<Price>();
	private Set<Product> products = new LinkedHashSet<Product>();

	public String getProductOfferingId() {
		return productOfferingId;
	}

	public void setProductOfferingId(String productOfferingId) {
		this.productOfferingId = productOfferingId;
	}

	public Set<CharacteristicValue> getOfferCharacterValues() {
		return characterValues;
	}

	public void setOfferCharacterValues(Set<CharacteristicValue> offerCharacterValues) {
		this.characterValues = offerCharacterValues;
	}
	
	public void addOfferCharacterValue(CharacteristicValue offerCharacterValue) {
		if (!this.characterValues.contains(offerCharacterValue)){
			this.characterValues.add(offerCharacterValue);
		}
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product) {
		if (!this.products.contains(product)){
			this.products.add(product);
		}
	}
	
	public Set<Price> getOneTimeFees() {
		return oneTimeFees;
	}
	public void addOneTimeFee(Price oneTimeFee) {
		oneTimeFees.add(oneTimeFee);
	}
	
	public void setOneTimeFees(Set<Price> oneTimeFees) {
		this.oneTimeFees = oneTimeFees;
	}
}
