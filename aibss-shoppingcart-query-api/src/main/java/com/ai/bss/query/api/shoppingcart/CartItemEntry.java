package com.ai.bss.query.api.shoppingcart;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CartItemEntry {
	@Id
	private String Id;
	private int quantity;
	private long price; 

	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="SHOPPING_CART_ID")
	private ShoppingCartEntry shoppingCart;
	
	@OneToOne
	private CartItemOfferEntry offerInstance;
		
	public CartItemEntry() {
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
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
	public ShoppingCartEntry getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCartEntry shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	public CartItemOfferEntry getOfferInstance() {
		return offerInstance;
	}
	public void setOfferInstance(CartItemOfferEntry offerInstance) {
		this.offerInstance = offerInstance;
	}
}
