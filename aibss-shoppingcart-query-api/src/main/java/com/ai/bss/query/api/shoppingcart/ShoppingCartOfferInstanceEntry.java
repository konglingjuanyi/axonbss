package com.ai.bss.query.api.shoppingcart;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.ai.bss.query.api.product.AbstractOfferInstance;
import com.ai.bss.query.api.product.AbstractOfferInstanceProductRel;
import com.ai.bss.query.api.product.AbstractPricePlanInstance;
@Entity
public class ShoppingCartOfferInstanceEntry extends AbstractOfferInstance {
	@OneToMany(mappedBy="offerInstance",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<AbstractPricePlanInstance> oneTimeFees=new LinkedHashSet<AbstractPricePlanInstance>();
	private long totalOneTimeFee; 
	
	public ShoppingCartOfferInstanceEntry() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AbstractOfferInstanceProductRel newOfferInstanceProductRel() {
		return new ShoppingCartOfferInstanceProductRelEntry();
	}
	public Set<AbstractPricePlanInstance> getOneTimeFees() {
		return oneTimeFees;
	}

	public void addOneTimeFee(AbstractPricePlanInstance oneTimeFee) {
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
	
	public Set<ShoppingCartOfferInstanceProductRelEntry> getRelProducts() {
		Set<ShoppingCartOfferInstanceProductRelEntry> products=new LinkedHashSet<>();
		Set<AbstractOfferInstanceProductRel> parentProducts=super.getProducts();
		for (AbstractOfferInstanceProductRel productRel : parentProducts) {
			products.add((ShoppingCartOfferInstanceProductRelEntry)productRel);
		}
		return products;
	}
}
