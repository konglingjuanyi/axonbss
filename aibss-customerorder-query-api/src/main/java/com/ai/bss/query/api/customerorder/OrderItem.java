package com.ai.bss.query.api.customerorder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ai.bss.query.api.bizinteraction.BizInteractionItem;
@Entity
public class OrderItem extends BizInteractionItem  {
	public enum OrderItemState {
		INITIATED(0),
		CREATED(1),
		SUBMITTED(2),
		CHARGE_ASSIGNED(9),
		COMPLETED(6),
		CLOSED(7),
		CANCLED(8);
		private int value;  

	    private OrderItemState(int value){ 
	        this.value=value; 
	    } 
 
	    public int getValue(){ 
	        return value; 
	    } 
	}	
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="RELAT_ENTITY_ID")
	private OrderItemOfferEntry  toBeOfferInstance;
		
	public OrderItem(CustomerOrder customerOrder) {
		super(customerOrder);
		customerOrder.addItem(this);
	}	

	public CustomerOrder getCustomerOrder() {
		return (CustomerOrder)super.getBizInteraction();
	}
	
	public void setCustomerOrder(CustomerOrder customerOrder) {
		super.setBizInteraction(customerOrder);	
	}

	public OrderItemOfferEntry getItemOffer() {
		return toBeOfferInstance;
	}

	public void setItemOffer(OrderItemOfferEntry toBeOfferInstance) {
		this.toBeOfferInstance = toBeOfferInstance;
	}

}
