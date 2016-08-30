package com.ai.bss.query.api.shoppingcart;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class ShoppingCartEntry {
	@Id
	private String Id;
	private String customerId;
	 @OneToMany(fetch=FetchType.LAZY,mappedBy="shoppingCart")
	private Set<CartItemEntry> items; 
	
	public ShoppingCartEntry(){
		 
	}
	 
	public ShoppingCartEntry(String customerId,String shoppingCartId) {
		this.customerId=customerId;
		this.Id=shoppingCartId;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Set<CartItemEntry> getItems() {
		return items;
	}
	public void addItem(CartItemEntry item){
		if (null!=item){
			if (null==items){
				items=new LinkedHashSet<CartItemEntry>();
			}
			items.add(item);
		}
	}
}
