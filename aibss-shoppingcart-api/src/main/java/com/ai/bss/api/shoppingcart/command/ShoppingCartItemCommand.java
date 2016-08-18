package com.ai.bss.api.shoppingcart.command;

import com.ai.bss.api.base.BaseCommand;
import com.ai.bss.api.shoppingcart.ShoppingCartId;
import com.ai.bss.api.shoppingcart.ShoppingCartItemId;

public abstract class ShoppingCartItemCommand extends BaseCommand{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8655436507626509446L;
	private ShoppingCartId shoppingCartId;
	private ShoppingCartItemId shopingCartItemId;	
	public ShoppingCartItemCommand() {
	}
	public ShoppingCartId getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(ShoppingCartId shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public ShoppingCartItemId getShopingCartItemId() {
		return shopingCartItemId;
	}
	public void setShopingCartItemId(ShoppingCartItemId shopingCartItemId) {
		this.shopingCartItemId = shopingCartItemId;
	}

}
