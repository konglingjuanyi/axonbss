package com.ai.bss.api.product.dto;

import java.sql.Timestamp;

public class UnsubscribeRentOffer extends UnsubscribeBuyOffer{

	public UnsubscribeRentOffer() {
	}
	private Timestamp expireTime;
	

	public Timestamp getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Timestamp expireTime) {
		this.expireTime = expireTime;
	}


}
