package com.ai.bss.query.api.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import com.ai.bss.api.base.CharacteristicValue;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractOfferCharacterValue extends CharacteristicValue{
	@ManyToOne
	private AbstractOffer offerInstance;
	public AbstractOfferCharacterValue() {
	}


	public AbstractOffer getOfferInstance() {
		return offerInstance;
	}

	public void setOfferInstance(AbstractOffer offerInstance) {
		this.offerInstance = offerInstance;
	}
	
	

}
