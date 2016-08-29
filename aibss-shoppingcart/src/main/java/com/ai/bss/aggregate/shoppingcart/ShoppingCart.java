package com.ai.bss.aggregate.shoppingcart;

import java.util.LinkedHashSet;
import java.util.Set;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import com.ai.bss.api.base.CharacteristicValue;
import com.ai.bss.api.product.ProductCharacteristicValue;
import com.ai.bss.api.shoppingcart.ShoppingCartId;
import com.ai.bss.api.shoppingcart.ShoppingCartItemId;
import com.ai.bss.api.shoppingcart.event.ShoppingCartCreatedEvent;
import com.ai.bss.api.shoppingcart.event.ShoppingCartDeletedEvent;
import com.ai.bss.api.shoppingcart.event.ShoppingCartItemAddedEvent;
import com.ai.bss.api.shoppingcart.event.ShoppingCartItemDeletedEvent;
import com.ai.bss.api.shoppingcart.event.ShoppingCartItemProductCharacterModifiedEvent;
import com.ai.bss.api.shoppingcart.event.ShoppingCartItemQuantityDecreasedEvent;
import com.ai.bss.api.shoppingcart.event.ShoppingCartItemQuantityIncreasedEvent;

public class ShoppingCart extends AbstractAnnotatedAggregateRoot {
	@AggregateIdentifier
	private ShoppingCartId shoppingCartId;
	private String state;
	private String customerId;
	private Set<ShoppingCartItem> shoppingCartItems=new LinkedHashSet<ShoppingCartItem>();
	
	public ShoppingCart(){
		
	}
	public ShoppingCart(String customerId,ShoppingCartId shoppingCartId){
		ShoppingCartCreatedEvent event=new ShoppingCartCreatedEvent();
		event.setCustomerId(customerId);
		event.setShoppingCartId(shoppingCartId);
		apply(event);
	}
	
	@EventHandler
	public void onShoppingCartCreated(ShoppingCartCreatedEvent event){
		this.setCustomerId(event.getCustomerId());
		this.setShoppingCartId(event.getShoppingCartId());		
	}
	
	public void addShoppingCartItem(ShoppingCartItemId shoppingCartItemId,
			String offeringId,//tobe changed to OfferId Object
			int quantity,
			long price,
			Set<CharacteristicValue> offerCharacteristics,
			Set<ProductCharacteristicValue> productCharacteristics
			){
		ShoppingCartItem item=new ShoppingCartItem(shoppingCartItemId,offeringId,quantity,price,offerCharacteristics,productCharacteristics);
		this.shoppingCartItems.add(item);
		ShoppingCartItemAddedEvent event=new ShoppingCartItemAddedEvent();
		event.setShoppingCartId(shoppingCartId);
		event.setShoppingCartItemId(shoppingCartItemId);
		event.setOfferCharacterValues(item.getOfferCharacteristicValues());
		event.setProductCharacterValues(item.getProductCharacteristicValues());
		apply(event);
	}
	
	public void increaseItemQuantity(ShoppingCartItemId shoppingCartItemId,int quantity,long price){
		ShoppingCartItem item=new ShoppingCartItem(shoppingCartItemId);
		item.increaseQuantity(quantity,price);
		this.shoppingCartItems.add(item);
		ShoppingCartItemQuantityIncreasedEvent event=new ShoppingCartItemQuantityIncreasedEvent();
		event.setNewQuantity(quantity);
		event.setShoppingCartId(shoppingCartId);
		event.setShoppingCartItemId(shoppingCartItemId);
		event.setPrice(price);
		apply(event);
	}
	
	public void decreaseItemQuantity(ShoppingCartItemId shoppingCartItemId,int quantity,long price){
		ShoppingCartItem item=new ShoppingCartItem(shoppingCartItemId);
		item.decreaseQuantity(quantity,price);
		this.shoppingCartItems.add(item);
		ShoppingCartItemQuantityDecreasedEvent event=new ShoppingCartItemQuantityDecreasedEvent();
		event.setNewQuantity(quantity);
		event.setShoppingCartId(shoppingCartId);
		event.setShoppingCartItemId(shoppingCartItemId);
		event.setPrice(price);
		apply(event);
	}
	
	public void modifyItemProductCharacter(ShoppingCartItemId shoppingCartItemId,
			String productSpecId,
			String productCharacterSpecId,
			String characterValueSpecId,
			String value
			){
		ShoppingCartItem item=new ShoppingCartItem(shoppingCartItemId);
		item.modifyProductCharacter(productSpecId,productCharacterSpecId,characterValueSpecId,value);
		this.shoppingCartItems.add(item);
		ShoppingCartItemProductCharacterModifiedEvent event=new ShoppingCartItemProductCharacterModifiedEvent();
		event.setShoppingCartId(shoppingCartId);
		event.setShoppingCartItemId(shoppingCartItemId);
		event.setProductSpecId(productSpecId);
		event.setProductCharacterSpecId(productCharacterSpecId);
		event.setCharacterValueSpecId(characterValueSpecId);
		event.setValue(value);
		apply(event);
	}
	
	
	public void deleteShoppingCart(ShoppingCartId shoppingCartId){
		ShoppingCartDeletedEvent event=new ShoppingCartDeletedEvent();
		event.setShoppingCartId(shoppingCartId);
		apply(event);
	}
	
	public void deleteShoppingCartItem(ShoppingCartItemId shoppingCartItemId){
		ShoppingCartItemDeletedEvent event=new ShoppingCartItemDeletedEvent();
		event.setShoppingCartId(shoppingCartId);
		event.setShoppingCartItemId(shoppingCartItemId);
		apply(event);
	}
	
	public ShoppingCartId getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(ShoppingCartId shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
