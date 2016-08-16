package com.ai.bss.query.api.product;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class PricePlanInstanceEntry extends AbstractPricePlanInstance{

	@Override
	protected AbstractProductPriceRel newProductPriceRel() {
		return new ProductPriceRelEntry();
	}

}
