package com.ai.bss.query.api.shoppingcart;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.ai.bss.query.api.product.AbstractOfferInstance;
import com.ai.bss.query.api.product.AbstractOfferInstanceProductRel;
@Entity
public class ShoppingCartOfferInstanceEntry extends AbstractOfferInstance {
	@OneToOne(mappedBy="shoppingCartItem")
	private ShoppingCartItemEntry shoppingCartItem;
	
	public ShoppingCartOfferInstanceEntry() {
		
	}
	public ShoppingCartItemEntry getShoppingCartItem() {
		return shoppingCartItem;
	}
	public void setShoppingCartItem(ShoppingCartItemEntry shoppingCartItem) {
		this.shoppingCartItem = shoppingCartItem;
	}
	@Override
	protected AbstractOfferInstanceProductRel newOfferInstanceProductRel() {
		return null;
	}
}
