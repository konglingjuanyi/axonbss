package com.ai.bss.api.product.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.api.base.CharacteristicValue;

public class Price {

	public Price() {
	}
	
	private String priceSpecificationId;
	private String subjectsCode;
	private long unitPrice;//discount=SpecificationPrice-unitPrice
	private Set<CharacteristicValue> characterValues = new LinkedHashSet<CharacteristicValue>();
	private Set<Product> products = new LinkedHashSet<Product>();
	public String getPriceSpecificationId() {
		return priceSpecificationId;
	}
	public void setPriceSpecificationId(String priceSpecificationId) {
		this.priceSpecificationId = priceSpecificationId;
	}
	public Set<CharacteristicValue> getCharacterValues() {
		return characterValues;
	}
	public void setCharacterValues(Set<CharacteristicValue> characterValues) {
		this.characterValues = characterValues;
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
	public long getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getSubjectsCode() {
		return subjectsCode;
	}
	public void setSubjectsCode(String subjectsCode) {
		this.subjectsCode = subjectsCode;
	}

}
