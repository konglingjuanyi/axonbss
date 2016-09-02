package com.ai.bss.api.product.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.api.base.CharacteristicValue;

public abstract class Offer {

	public Offer() {
	}
	private String productOfferingId;

	private Set<CharacteristicValue> characterValues = new LinkedHashSet<CharacteristicValue>();
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
}
