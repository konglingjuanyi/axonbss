package com.ai.bss.api.customerorder.event;
import java.sql.Timestamp;

public class ProductOrderActivatedEvent extends AbstractCustomerOrderItemEvent {
	private Timestamp activatedTime;

	public Timestamp getActivatedTime() {
		return activatedTime;
	}

	public void setActivatedTime(Timestamp activatedTime) {
		this.activatedTime = activatedTime;
	}

}
