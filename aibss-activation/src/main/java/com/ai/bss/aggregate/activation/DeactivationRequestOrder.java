package com.ai.bss.aggregate.activation;

import java.sql.Timestamp;

import com.ai.bss.api.activation.event.ProductActivateOrderCreatedEvent;

public class DeactivationRequestOrder extends AbstractActivationRequestOrder{
	
	public DeactivationRequestOrder(String orderId,String productOrderId,String productSpecId,String productId,
			Timestamp effectiveTime,Timestamp expireTime) {
		super(orderId,productOrderId,productSpecId,productId,effectiveTime,expireTime);
		ProductActivateOrderCreatedEvent event=new ProductActivateOrderCreatedEvent();
		event.setCustomerOrderId(orderId);
		event.setProductOrderId(productOrderId);
		event.setProductId(productId);
		event.setEffectiveTime(effectiveTime);
		event.setExpireTime(expireTime);
		apply(event);
	}
}
