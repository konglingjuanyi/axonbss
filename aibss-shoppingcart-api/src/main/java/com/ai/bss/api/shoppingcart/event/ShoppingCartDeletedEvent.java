package com.ai.bss.api.shoppingcart.event;

import com.ai.bss.api.base.BaseEvent;
import com.ai.bss.api.shoppingcart.ShoppingCartId;

public class ShoppingCartDeletedEvent extends BaseEvent {
	public ShoppingCartDeletedEvent() {
		// TODO Auto-generated constructor stub
	}
	private String customerId; 
	private ShoppingCartId shoppingCartId;
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
