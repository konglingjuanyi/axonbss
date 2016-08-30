package com.ai.bss.query.api.customerorder;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.ai.bss.query.api.product.AbstractOffer;
import com.ai.bss.query.api.product.AbstractOfferProductRel;
import com.ai.bss.query.api.product.AbstractPrice;
@Entity
public class OrderItemOfferEntry extends AbstractOffer {
	@OneToOne
	private OrderItem orderItem;
	
	@OneToMany(mappedBy="offerInstance",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<AbstractPrice> oneTimeFees=new LinkedHashSet<AbstractPrice>();

	private long totalOneTimeFee; 
	
	public OrderItemOfferEntry() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AbstractOfferProductRel newOfferInstanceProductRel() {
		return new OrderItemOfferProductRelEntry();
	}
	
	
	public Set<AbstractPrice> getOneTimeFees() {
		return oneTimeFees;
	}

	public void addOneTimeFee(AbstractPrice oneTimeFee) {
		if (null!=oneTimeFee){
			oneTimeFees.add(oneTimeFee);
			if (null==oneTimeFee.getOfferInstance()){
				oneTimeFee.setOfferInstance(this);
			}
		}
	}

	public long getUnitPrice() {
		return totalOneTimeFee;
	}

	public void setUnitPrice(long unitPrice) {
		this.totalOneTimeFee = unitPrice;
	}
	
	public Set<OrderItemOfferProductRelEntry> getRelProducts() {
		Set<OrderItemOfferProductRelEntry> products=new LinkedHashSet<>();
		Set<AbstractOfferProductRel> parentProducts=super.getProducts();
		for (AbstractOfferProductRel productRel : parentProducts) {
			products.add((OrderItemOfferProductRelEntry)productRel);
		}
		return products;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
}
