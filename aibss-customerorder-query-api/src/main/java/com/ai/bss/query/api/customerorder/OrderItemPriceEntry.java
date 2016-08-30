package com.ai.bss.query.api.customerorder;

import javax.persistence.Entity;

import com.ai.bss.query.api.product.AbstractPrice;
import com.ai.bss.query.api.product.AbstractProductPriceRel;

@Entity
public class OrderItemPriceEntry extends AbstractPrice{

	@Override
	protected AbstractProductPriceRel newProductPriceRel() {
		return new OrderItemProductPriceRelEntry();
	}

}
