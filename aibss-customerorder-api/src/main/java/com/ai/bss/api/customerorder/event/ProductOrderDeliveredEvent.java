package com.ai.bss.api.customerorder.event;
import java.sql.Timestamp;

public class ProductOrderDeliveredEvent extends AbstractCustomerOrderItemEvent {
	private Timestamp deliveredTime;
	private String receiverSign;
	private String expressNumber;

	public Timestamp getDeliveredTime() {
		return deliveredTime;
	}

	public void setDeliveredTime(Timestamp deliveredTime) {
		this.deliveredTime = deliveredTime;
	}

	public String getReceiverSign() {
		return receiverSign;
	}

	public void setReceiverSign(String receiverSign) {
		this.receiverSign = receiverSign;
	}

	public String getExpressNumber() {
		return expressNumber;
	}

	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}
	
}
