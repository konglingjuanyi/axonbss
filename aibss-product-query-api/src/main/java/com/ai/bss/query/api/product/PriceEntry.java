package com.ai.bss.query.api.product;

import javax.persistence.Entity;

@Entity
public class PriceEntry extends AbstractPrice{

	@Override
	protected AbstractProductPriceRel newProductPriceRel() {
		return new ProductPriceRelEntry();
	}

}
