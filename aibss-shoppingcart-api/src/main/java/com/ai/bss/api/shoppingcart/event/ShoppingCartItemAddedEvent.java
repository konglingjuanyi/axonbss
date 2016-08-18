package com.ai.bss.api.shoppingcart.event;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.api.shoppingcart.ShoppingCartItemCharacter;
import com.ai.bss.api.shoppingcart.ShoppingCartItemProductCharacter;

public class ShoppingCartItemAddedEvent extends ShoppingCartItemEvent{
	public ShoppingCartItemAddedEvent() {
		// TODO Auto-generated constructor stub
	}
	private String offerId;
	private int quantity;
	private long price;  
	private Set<ShoppingCartItemCharacter> offerInstanceCharacters = new LinkedHashSet<ShoppingCartItemCharacter>();
	private Set<ShoppingCartItemProductCharacter> productCharacters = new LinkedHashSet<ShoppingCartItemProductCharacter>();

	public String getOfferId() {
		return offerId;
	}
	public void setOfferId(String offerId) {
		this.offerId = offerId;
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
	
	public void setOfferInstanceCharacters(Set<ShoppingCartItemCharacter> offerInstanceCharacters){
		this.offerInstanceCharacters=offerInstanceCharacters;
	}
	
	public Set<ShoppingCartItemCharacter> getOfferInstanceCharacters(){
		return this.offerInstanceCharacters;
	}
	
	public void setProductCharacters(Set<ShoppingCartItemProductCharacter> productCharacters){
		this.productCharacters=productCharacters;
	}
	
	public Set<ShoppingCartItemProductCharacter> getProductCharacters(){
		return this.productCharacters;
	}

}
