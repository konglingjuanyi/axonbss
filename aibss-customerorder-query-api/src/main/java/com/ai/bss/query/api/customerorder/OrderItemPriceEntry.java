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
	
	private long asisVersion;
	
	//updated after archived
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

}
