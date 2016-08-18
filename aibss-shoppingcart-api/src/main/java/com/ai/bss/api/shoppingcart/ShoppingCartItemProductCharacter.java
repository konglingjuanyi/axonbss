package com.ai.bss.api.shoppingcart;

import com.ai.bss.api.base.Characteristic;

public class ShoppingCartItemProductCharacter extends Characteristic {
	private String productSpecId;
	public ShoppingCartItemProductCharacter() {
	}
	public String getProductSpecId() {
		return productSpecId;
	}
	public void setProductSpecId(String productSpecId) {
		this.productSpecId = productSpecId;
	}

}
