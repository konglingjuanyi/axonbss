package com.ai.bss.api.product.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.api.base.CharacteristicValue;

public class Product {
	
	public Product() {
		
	}
	private String productSpecificationId;
	private Set<CharacteristicValue> characterValues = new LinkedHashSet<CharacteristicValue>();
	public Set<CharacteristicValue> getProductCharacterValues() {
		return characterValues;
	}

	public void setProductCharacterValues(Set<CharacteristicValue> characterValues) {
		this.characterValues = characterValues;
	}
	
	public void addProductCharacterValue(CharacteristicValue characterValue) {
		if (!this.characterValues.contains(characterValue)){
			this.characterValues.add(characterValue);
		}
	}

	public String getProductSpecificationId() {
		return productSpecificationId;
	}

	public void setProductSpecificationId(String productSpecificationId) {
		this.productSpecificationId = productSpecificationId;
	}
}
