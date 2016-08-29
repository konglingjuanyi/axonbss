package com.ai.bss.webui.shoppingcart.model;

import com.ai.bss.webui.productsale.model.OfferDetail;

public class ShoppingCartItem {
	private String shoppingCartId;
	private String shoppingCartItemId;
	private OfferDetail offerDetail;
	private int quantity;
	private long price;  
	public String getShoppingCartItemId() {
		return shoppingCartItemId;
	}
	public void setShoppingCartItemId(String itemId) {
		this.shoppingCartItemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	public OfferDetail getOfferDetail() {
		return offerDetail;
	}
	public void setOfferDetail(OfferDetail offerDetail) {
		this.offerDetail = offerDetail;
	}
	public String getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(String shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
}
