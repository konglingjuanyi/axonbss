package com.ai.bss.query.api.product;

import javax.persistence.Entity;

@Entity
public class OfferInstanceEntry extends AbstractOfferInstance{	
	
	public OfferInstanceEntry() {
	}

	@Override
	protected AbstractOfferInstanceProductRel newOfferInstanceProductRel() {
		return new OfferInstanceProductRelEntry();
	}
	

}
