package com.ai.bss.query.api.shoppingcart;

import javax.persistence.Entity;

import com.ai.bss.query.api.product.AbstractPricePlanInstance;
import com.ai.bss.query.api.product.AbstractProductPriceRel;

@Entity
public class ShoppingCartPricePlanInstanceEntry extends AbstractPricePlanInstance{

	@Override
	protected AbstractProductPriceRel newProductPriceRel() {
		return new ShoppingCartProductPriceRelEntry();
	}

}
