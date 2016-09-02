package com.ai.bss.query.api.customerorder;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ai.bss.query.api.bizinteraction.BizInteractionItem;
@Entity
@DiscriminatorValue("CUSTOMER.ORDER.ITEM")
@Access(AccessType.FIELD) 
public class OrderItemEntry extends BizInteractionItem  {
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
		
	public OrderItemEntry(CustomerOrderEntry customerOrder) {
		super(customerOrder);
		customerOrder.addItem(this);
	}	

	public CustomerOrderEntry getCustomerOrder() {
		return (CustomerOrderEntry)super.getBizInteraction();
	}
	
	public void setCustomerOrder(CustomerOrderEntry customerOrder) {
		super.setBizInteraction(customerOrder);	
	}

	public OrderItemOfferEntry getItemOffer() {
		return toBeOfferInstance;
	}

	public void setItemOffer(OrderItemOfferEntry toBeOfferInstance) {
		this.toBeOfferInstance = toBeOfferInstance;
	}

}
