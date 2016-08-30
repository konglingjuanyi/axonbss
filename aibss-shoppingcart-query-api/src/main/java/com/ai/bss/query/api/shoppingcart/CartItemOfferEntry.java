package com.ai.bss.query.api.shoppingcart;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.ai.bss.query.api.product.AbstractOffer;
import com.ai.bss.query.api.product.AbstractOfferProductRel;
import com.ai.bss.query.api.product.AbstractPrice;
@Entity
public class CartItemOfferEntry extends AbstractOffer {
	@OneToMany(mappedBy="offerInstance",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<AbstractPrice> oneTimeFees=new LinkedHashSet<AbstractPrice>();
	private long totalOneTimeFee; 
	
	public CartItemOfferEntry() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AbstractOfferProductRel newOfferInstanceProductRel() {
		return new CartItemOfferProductRelEntry();
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
	
	public Set<CartItemOfferProductRelEntry> getRelProducts() {
		Set<CartItemOfferProductRelEntry> products=new LinkedHashSet<>();
		Set<AbstractOfferProductRel> parentProducts=super.getProducts();
		for (AbstractOfferProductRel productRel : parentProducts) {
			products.add((CartItemOfferProductRelEntry)productRel);
		}
		return products;
	}
}
