package com.ai.bss.aggregate.shoppingcart;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.api.base.CharacteristicValue;
import com.ai.bss.api.shoppingcart.ShoppingCartItemCharacter;
import com.ai.bss.api.shoppingcart.ShoppingCartItemId;
import com.ai.bss.api.shoppingcart.ShoppingCartItemProductCharacter;

public class ShoppingCartItem {
	private ShoppingCartItemId shoppingCartItemId;
	private String offerId;
	private int quantity;
	private long price;
	private String state;
	private Set<ShoppingCartItemCharacter> offerCharacteristics=new LinkedHashSet<ShoppingCartItemCharacter>();
	private Set<ShoppingCartItemProductCharacter> productCharacteristics=new LinkedHashSet<ShoppingCartItemProductCharacter>();
	
	public ShoppingCartItem(ShoppingCartItemId shoppingCartItemId){
		this.shoppingCartItemId=shoppingCartItemId;
	}
	
	public ShoppingCartItem(ShoppingCartItemId shoppingCartItemId,
			String offerId,//tobe changed to OfferId Object
			int quantity,
			long price,
			Set<ShoppingCartItemCharacter> offerCharacteristics,
			Set<ShoppingCartItemProductCharacter> productCharacteristics
			){
		this.offerId=offerId;
		this.quantity=quantity;
		this.price=price;
		if (null!=offerCharacteristics&&offerCharacteristics.size()>0){
			for (ShoppingCartItemCharacter offerCharacterist : offerCharacteristics) {
				this.addOfferCharacteristic(offerCharacterist);
			}
		}
		if (null!=productCharacteristics&&productCharacteristics.size()>0){
			for (ShoppingCartItemProductCharacter productCharacterist : productCharacteristics) {
				this.addProductCharacteristic(productCharacterist);
			}
		}
	}
	
	public void increaseQuantity(int quantity,long price){
		this.quantity=quantity;
		this.price=price;
	}
	
	public void decreaseQuantity(int quantity,long price){
		this.quantity=quantity;
		this.price=price;
	}
	
	public void modifyProductCharacter(CharacteristicValue produtcCharacterValue){
		this.addProductCharacteristic((ShoppingCartItemProductCharacter)produtcCharacterValue.getCharacteristic());
	}
	
	public ShoppingCartItemId getShoppingCartItemId() {
		return shoppingCartItemId;
	}
	public void setShoppingCartItemId(ShoppingCartItemId shoppingCartItemId) {
		this.shoppingCartItemId = shoppingCartItemId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public Set<ShoppingCartItemCharacter> getOfferCharacteristics() {
		return offerCharacteristics;
	}
	
	private void addOfferCharacteristic(ShoppingCartItemCharacter aCharacteristic){
		this.offerCharacteristics.add(aCharacteristic);
	}
	
	private void addProductCharacteristic(ShoppingCartItemProductCharacter aCharacteristic){
		this.productCharacteristics.add(aCharacteristic);
	}


	public Set<ShoppingCartItemProductCharacter> getProductCharacteristics() {
		return productCharacteristics;
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


}
