package com.ai.bss.api.shoppingcart.command;

import com.ai.bss.api.base.BaseCommand;

public class DeleteShoppingCartCommand extends BaseCommand{
	private String customerId; 
	private String shoppingCartId;
	public DeleteShoppingCartCommand() {
	}
	public String getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(String shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}
