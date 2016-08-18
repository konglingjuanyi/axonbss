package com.ai.bss.api.shoppingcart.command;

import com.ai.bss.api.base.BaseCommand;
import com.ai.bss.api.shoppingcart.ShoppingCartId;

public class CreateShoppingCartCommand extends BaseCommand{
	private String customerId; 
	private ShoppingCartId shoppingCartId;
	public CreateShoppingCartCommand() {
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public ShoppingCartId getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(ShoppingCartId shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

}
