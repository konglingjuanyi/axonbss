package com.ai.bss.api.shoppingcart.event;

import com.ai.bss.api.base.BaseEvent;
import com.ai.bss.api.shoppingcart.ShoppingCartId;
import com.ai.bss.api.shoppingcart.ShoppingCartItemId;

public abstract class ShoppingCartItemEvent extends BaseEvent {
	private ShoppingCartId shoppingCartId;
	private ShoppingCartItemId shoppingCartItemId;	
	public ShoppingCartId getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(ShoppingCartId shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public ShoppingCartItemId getShoppingCartItemId() {
		return shoppingCartItemId;
	}
	public void setShoppingCartItemId(ShoppingCartItemId shoppingCartItemId) {
		this.shoppingCartItemId = shoppingCartItemId;
	}
	
	public ShoppingCartItemEvent() {
	}

}
