package com.ai.bss.api.product.dto;

public class BuyOffer extends Offer {
	//buyoffer can only have one priceSpec, so here no need to relate price object
	public BuyOffer() {
	}
	private long priceAfterDiscout;
	private long discount;
	public long getPriceAfterDiscout() {
		return priceAfterDiscout;
	}

	public void setPriceAfterDiscout(long unitPrice) {
		this.priceAfterDiscout = unitPrice;
	}

	public long getDiscount() {
		return discount;
	}

	public void setDiscount(long discount) {
		this.discount = discount;
	}
}
