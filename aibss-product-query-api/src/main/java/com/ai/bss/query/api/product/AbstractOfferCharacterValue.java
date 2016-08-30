package com.ai.bss.query.api.product;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.ai.bss.api.base.CharacteristicValue;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractOfferCharacterValue extends CharacteristicValue{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@ManyToOne
	private AbstractOffer offerInstance;
	public AbstractOfferCharacterValue() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AbstractOffer getOfferInstance() {
		return offerInstance;
	}

	public void setOfferInstance(AbstractOffer offerInstance) {
		this.offerInstance = offerInstance;
	}
	
	

}
