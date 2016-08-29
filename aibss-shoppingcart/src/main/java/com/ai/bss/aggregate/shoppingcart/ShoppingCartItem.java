package com.ai.bss.aggregate.shoppingcart;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.bss.api.base.CharacteristicValue;
import com.ai.bss.api.product.ProductCharacteristicValue;
import com.ai.bss.api.shoppingcart.ShoppingCartItemId;

public class ShoppingCartItem {
	private ShoppingCartItemId shoppingCartItemId;
	private String offeringId;
	private int quantity;
	private long price;
	private String state;
	private Set<CharacteristicValue> offerCharacteristicValues=new LinkedHashSet<CharacteristicValue>();
	private Set<ProductCharacteristicValue> productCharacteristicValues=new LinkedHashSet<ProductCharacteristicValue>();
	
	public ShoppingCartItem(){
		
	}
	
	public ShoppingCartItem(ShoppingCartItemId shoppingCartItemId){
		this.shoppingCartItemId=shoppingCartItemId;
	}
	
	public ShoppingCartItem(ShoppingCartItemId shoppingCartItemId,
			String offeringId,//tobe changed to OfferId Object
			int quantity,
			long price,
			Set<CharacteristicValue> offerCharacteristicValues,
			Set<ProductCharacteristicValue> productCharacteristicValues
			){
		this.offeringId=offeringId;
		this.quantity=quantity;
		this.price=price;
		if (null!=offerCharacteristicValues&&offerCharacteristicValues.size()>0){
			for (CharacteristicValue offerCharacterist : offerCharacteristicValues) {
				this.addOfferCharacteristicValue(offerCharacterist);
			}
		}
		if (null!=productCharacteristicValues&&productCharacteristicValues.size()>0){
			for (ProductCharacteristicValue productCharacterist : productCharacteristicValues) {
				this.addProductCharacteristicValue(productCharacterist);
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
	
	public void modifyProductCharacter(String productSpecId,
			String productCharacterSpecId,
			String characterValueSpecId,
			String value){
		ProductCharacteristicValue characterValue=new ProductCharacteristicValue();
		this.addProductCharacteristicValue(characterValue);
		characterValue.setProductSpecId(productSpecId);
		characterValue.setCharacteristicSpecId(productCharacterSpecId);
		characterValue.setValueSpecId(characterValueSpecId);
		characterValue.setValue(value);
		this.addProductCharacteristicValue(characterValue);
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

	public Set<CharacteristicValue> getOfferCharacteristicValues() {
		return offerCharacteristicValues;
	}
	
	private void addOfferCharacteristicValue(CharacteristicValue aCharacteristicValue){
		this.offerCharacteristicValues.add(aCharacteristicValue);
	}
	
	private void addProductCharacteristicValue(ProductCharacteristicValue aCharacteristicValue){
		this.productCharacteristicValues.add(aCharacteristicValue);
	}


	public Set<ProductCharacteristicValue> getProductCharacteristicValues() {
		return productCharacteristicValues;
	}

	public String getOfferingId() {
		return offeringId;
	}

	public void setOfferingId(String offeringId) {
		this.offeringId = offeringId;
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
