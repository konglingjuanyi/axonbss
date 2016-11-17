package com.ai.bss.api.delivery.event;

import java.sql.Timestamp;

import com.ai.bss.api.base.BaseCommand;
import com.ai.bss.api.base.BaseEvent;

public abstract class AbstractDeliveryProductEvent extends BaseEvent {
	private String customerOrderId;
	private String offerOrderId;
	private String productOrderId;
	private String productId;
	private Timestamp effectiveTime;
	private Timestamp expireTime;
	public AbstractDeliveryProductEvent() {
		
	}
	public String getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(String customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public String getOfferOrderId() {
		return offerOrderId;
	}
	public void setOfferOrderId(String offerOrderId) {
		this.offerOrderId = offerOrderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Timestamp getEffectiveTime() {
		return effectiveTime;
	}
	public void setEffectiveTime(Timestamp effectiveTime) {
		this.effectiveTime = effectiveTime;
	}
	public Timestamp getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Timestamp expireTime) {
		this.expireTime = expireTime;
	}
	public String getProductOrderId() {
		return productOrderId;
	}
	public void setProductOrderId(String productOrderId) {
		this.productOrderId = productOrderId;
	}

}
