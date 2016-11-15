package com.ai.bss.query.api.customerorder;

import javax.persistence.Entity;
import javax.persistence.Version;

import com.ai.bss.query.api.product.AbstractOfferCharacterValue;

@Entity
public class OfferOrderCharacterValueEntry extends AbstractOfferCharacterValue{
	public OfferOrderCharacterValueEntry(){}
	
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
