package com.ai.bss.api.shoppingcart.command;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.query.api.shoppingcart.ShoppingCartOfferInstanceCharacterEntry;
import com.ai.bss.query.api.shoppingcart.ShoppingCartProductCharacterEntry;

public class AddShoppingCartItemCommand extends ShoppingCartCommand {
	private String offerId;
	private int quantity;
	private long price;  
	private Set<ShoppingCartOfferInstanceCharacterEntry> offerInstanceCharacters = new LinkedHashSet<ShoppingCartOfferInstanceCharacterEntry>();
	private Set<ShoppingCartProductCharacterEntry> productCharacters = new LinkedHashSet<ShoppingCartProductCharacterEntry>();
	public AddShoppingCartItemCommand() {
	}
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
	
	public void addOfferInstanceCharacter(ShoppingCartOfferInstanceCharacterEntry offerCharacter){
		this.offerInstanceCharacters.add(offerCharacter);
	}
	
	public Set<ShoppingCartOfferInstanceCharacterEntry> getOfferInstanceCharacters(){
		return this.offerInstanceCharacters;
	}
	
	public void addProductCharacter(ShoppingCartProductCharacterEntry productCharacter){
		this.productCharacters.add(productCharacter);
	}
	
	public Set<ShoppingCartProductCharacterEntry> getOProductCharacters(){
		return this.productCharacters;
	}

}
