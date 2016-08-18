package com.ai.bss.api.shoppingcart;

import com.ai.bss.api.base.Characteristic;

public class ShoppingCartItemCharacter extends Characteristic {
	private String itemSpecId;
	public ShoppingCartItemCharacter() {
	}
	public String getProductSpecId() {
		return itemSpecId;
	}
	public void setProductSpecId(String productSpecId) {
		this.itemSpecId = productSpecId;
	}

}
