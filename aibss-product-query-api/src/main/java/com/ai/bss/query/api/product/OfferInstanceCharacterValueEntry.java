package com.ai.bss.query.api.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ai.bss.api.base.CharacteristicValue;

@Entity
public class OfferInstanceCharacterValueEntry extends CharacteristicValue{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@ManyToOne
	private AbstractOfferInstance offerInstance;
	public OfferInstanceCharacterValueEntry() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AbstractOfferInstance getOfferInstance() {
		return offerInstance;
	}

	public void setOfferInstance(AbstractOfferInstance offerInstance) {
		this.offerInstance = offerInstance;
	}
	
	

}
