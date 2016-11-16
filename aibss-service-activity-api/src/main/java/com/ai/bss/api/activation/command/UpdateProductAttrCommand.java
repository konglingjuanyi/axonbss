package com.ai.bss.api.activation.command;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.query.api.customerorder.ProductOrderCharacterValueEntry;

public class UpdateProductAttrCommand extends AbstractActivateProductCommand {
	private Set<ProductOrderCharacterValueEntry>  ProductOrderCharacterValues= new LinkedHashSet<>();

	public Set<ProductOrderCharacterValueEntry> getProductOrderCharacterValues() {
		return ProductOrderCharacterValues;
	}
	
	public void addProductOrderCharacterValue(ProductOrderCharacterValueEntry productCharValue){
		if (!ProductOrderCharacterValues.contains(productCharValue)){
			ProductOrderCharacterValues.add(productCharValue);
		}
	}

	public void setProductOrderCharacterValues(Set<ProductOrderCharacterValueEntry> productOrderCharacterValues) {
		ProductOrderCharacterValues = productOrderCharacterValues;
	}
	
}
