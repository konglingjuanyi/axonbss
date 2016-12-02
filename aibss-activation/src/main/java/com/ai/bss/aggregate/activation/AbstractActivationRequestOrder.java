package com.ai.bss.aggregate.activation;

import java.sql.Timestamp;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;

public abstract class AbstractActivationRequestOrder extends AbstractAnnotatedAggregateRoot{

	public AbstractActivationRequestOrder() {
		// TODO Auto-generated constructor stub
	}
	
	public AbstractActivationRequestOrder(String orderId,String productOrderId,String productSpecId,String productId,
			Timestamp effectiveTime,Timestamp expireTime) {
		
	}
}
