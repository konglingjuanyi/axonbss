package com.ai.bss.query.api.customerorder;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.ai.bss.query.api.product.AbstractOffer;
import com.ai.bss.query.api.product.AbstractOfferProductRel;
import com.ai.bss.query.api.product.AbstractPrice;
@Entity
public class OfferOrderEntry extends AbstractOffer {
	@OneToOne
	private OrderItemEntry orderItem;
	
	@OneToMany(mappedBy="offerInstance",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<AbstractPrice> oneTimeFees=new LinkedHashSet<AbstractPrice>();

	private String action;
	
	private long totalOneTimeFee; 	
	
	private long asisVersion;
	
	//updated after the offer is archived
	private long tobeVersion;
	
	public long getAsisVersion() {
		return asisVersion;
	}

	public void setAsisVersion(long asisVersion) {
		this.asisVersion = asisVersion;
	}

	public long getTobeVersion() {
		return tobeVersion;
	}

	public void setTobeVersion(long tobeVersion) {
		this.tobeVersion = tobeVersion;
	}
	
	public OfferOrderEntry() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AbstractOfferProductRel newOfferInstanceProductRel() {
		return new OfferOrderProductRelEntry();
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
	
	public Set<OfferOrderProductRelEntry> getRelProducts() {
		Set<OfferOrderProductRelEntry> products=new LinkedHashSet<>();
		Set<AbstractOfferProductRel> parentProducts=super.getProducts();
		for (AbstractOfferProductRel productRel : parentProducts) {
			products.add((OfferOrderProductRelEntry)productRel);
		}
		return products;
	}

	public OrderItemEntry getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItemEntry orderItem) {
		this.orderItem = orderItem;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
