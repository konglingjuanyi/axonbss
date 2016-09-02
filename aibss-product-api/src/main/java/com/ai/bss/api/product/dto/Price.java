package com.ai.bss.api.product.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.api.base.CharacteristicValue;

public class Price {

	public Price() {
	}
	
	private String priceSpecificationId;
	private long priceAfterDiscount;
	private long discount;
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
	public long getPriceAfterDiscount() {
		return priceAfterDiscount;
	}
	public void setPriceAfterDiscount(long price) {
		this.priceAfterDiscount = price;
	}
	public long getDiscount() {
		return discount;
	}
	public void setDiscount(long discount) {
		this.discount = discount;
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
