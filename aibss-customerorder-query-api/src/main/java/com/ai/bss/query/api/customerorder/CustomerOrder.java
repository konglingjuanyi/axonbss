package com.ai.bss.query.api.customerorder;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import com.ai.bss.query.api.bizinteraction.BizInteraction;
import com.ai.bss.query.api.bizinteraction.BizInteractionItem;

@Entity
//@DiscriminatorValue("1000")
@Access(AccessType.FIELD) 
public class CustomerOrder extends BizInteraction {	
	public enum OrderAction {
		NEW(1),
		UPDATE(2),
		DELETE(3),
		OLD(4);
		private int value;  

	    private OrderAction(int value){ 
	        this.value=value; 
	    } 
 
	    public int getValue(){ 
	        return value; 
	    } 
	}	
	public enum CustomerOrderState {
		INITIATED(0),
		CREATED(1),
		SUBMITTED(2),
		PAID(3),
		DELIVERING(4),
		DELIVERED(5),
		COMPLETED(6),
		CLOSED(7),
		CANCLED(8);
		private int value;  

	    private CustomerOrderState(int value){ 
	        this.value=value; 
	    } 
 
	    public int getValue(){ 
	        return value; 
	    } 
	}	
	
	public CustomerOrder() {
		super("BIZ_CUSTOMER_ORDER");
	}

	
	public long getCustomerOrderId() {
		return super.getId();
	}

	
	public String getCustomerOrderCode() {
		return this.getCode();
	}

	
	public Set<OrderItem> getOrderItems() {
		Set<OrderItem> OrderItems=new LinkedHashSet<OrderItem>();
		Set<BizInteractionItem> items=super.getItems();
		if (items!=null&&items.size()>0) {
			for (BizInteractionItem businessInteractionItem : items) {
				OrderItems.add((OrderItem)businessInteractionItem);

			}
		}
		return OrderItems;
	}

	
	public void addOrderItem(OrderItem orderItem) {
		if (null!=orderItem){
			super.addItem(orderItem);
		}
	}

	
	public void setCustomerOrderId(long customerOrderId) {
		super.setId(customerOrderId);
		
	}

	
	public void setCustomerOrderCode(String customerOrderCode) {
		this.setCode(customerOrderCode);
		
	}
}
