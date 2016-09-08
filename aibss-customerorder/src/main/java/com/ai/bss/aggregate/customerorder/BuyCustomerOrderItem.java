package com.ai.bss.aggregate.customerorder;

import com.ai.bss.api.customerorder.CustomerOrderId;
import com.ai.bss.api.customerorder.CustomerOrderItemId;
import com.ai.bss.api.product.dto.BuyOffer;

public class BuyCustomerOrderItem extends AbstractCustomerOrderItem{
	private BuyOffer buyOffer;
		
	public BuyCustomerOrderItem(CustomerOrderId customerOrderId,CustomerOrderItemId customerOrderItemId,BuyOffer buyOffer) {
		super(customerOrderId,customerOrderItemId);
		this.buyOffer=buyOffer;
	}
	
	public BuyOffer getBuyOffer() {
		return buyOffer;
	}
	public void setBuyOffer(BuyOffer buyOffer) {
		this.buyOffer = buyOffer;
	}
}
