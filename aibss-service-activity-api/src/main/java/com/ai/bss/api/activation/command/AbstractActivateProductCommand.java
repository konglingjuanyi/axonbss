package com.ai.bss.api.activation.command;

import java.sql.Timestamp;

import com.ai.bss.api.base.BaseCommand;

public abstract class AbstractActivateProductCommand extends BaseCommand {
	private String customerOrderId;
	private String offerOrderId;
	private String productOrderId;
	private String productSpecId;
	private String productId;
	private String action;
	private Timestamp effectiveTime;
	private Timestamp expireTime;
	public AbstractActivateProductCommand() {
		
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
	public String getProductSpecId() {
		return productSpecId;
	}
	public void setProductSpecId(String productSpecId) {
		this.productSpecId = productSpecId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

}
