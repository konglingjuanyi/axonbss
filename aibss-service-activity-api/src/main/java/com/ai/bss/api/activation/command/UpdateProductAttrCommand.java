package com.ai.bss.api.activation.command;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.query.api.customerorder.ProductOrderCharacterValueEntry;

public class UpdateProductAttrCommand extends AbstractActivateProductCommand {
	private Set<ProductOrderCharacterValueEntry>  ProductOrderCharacterValues= new LinkedHashSet<>();

	public Set<ProductOrderCharacterValueEntry> getProductOrderCharacterValues() {
		return ProductOrderCharacterValues;
	}
	
	public void addProductOrderCharacterValues(ProductOrderCharacterValueEntry productCharValue){
		if (!ProductOrderCharacterValues.contains(productCharValue)){
			ProductOrderCharacterValues.add(productCharValue);
		}
	}
}
