package com.ai.bss.api.shoppingcart.command;

import com.ai.bss.api.base.BaseCommand;

public abstract class ShoppingCartCommand extends BaseCommand{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8655436507626509446L;
	private String shoppingCartId;
	private String shopingCartItemId;	
	public ShoppingCartCommand() {
	}
	public String getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(String shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public String getShopingCartItemId() {
		return shopingCartItemId;
	}
	public void setShopingCartItemId(String shopingCartItemId) {
		this.shopingCartItemId = shopingCartItemId;
	}

}
