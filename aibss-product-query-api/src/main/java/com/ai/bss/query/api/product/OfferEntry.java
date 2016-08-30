package com.ai.bss.query.api.product;

import javax.persistence.Entity;

@Entity
public class OfferEntry extends AbstractOffer{	
	
	public OfferEntry() {
	}

	@Override
	protected AbstractOfferProductRel newOfferInstanceProductRel() {
		return new OfferProductRelEntry();
	}
	
}
