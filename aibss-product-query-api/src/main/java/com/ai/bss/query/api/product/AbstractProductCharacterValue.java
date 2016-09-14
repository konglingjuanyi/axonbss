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
public abstract class AbstractProductCharacterValue extends CharacteristicValue {
	
	private String offerInstanceId;
	
	@ManyToOne
	private AbstractProduct product;


	public AbstractProduct getProduct() {
		return product;
	}

	public void setProduct(AbstractProduct product) {
		this.product = product;
	}

	public String getOfferInstanceId() {
		return offerInstanceId;
	}

	public void setOfferInstanceId(String offerInstanceId) {
		this.offerInstanceId = offerInstanceId;
	}
	
}
