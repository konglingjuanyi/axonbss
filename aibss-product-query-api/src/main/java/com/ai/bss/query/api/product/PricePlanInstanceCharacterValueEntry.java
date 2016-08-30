package com.ai.bss.query.api.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ai.bss.api.base.CharacteristicValue;

@Entity
public class PricePlanInstanceCharacterValueEntry extends CharacteristicValue{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@ManyToOne
	private AbstractPricePlanInstance price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AbstractPricePlanInstance getPrice() {
		return price;
	}

	public void setPrice(AbstractPricePlanInstance price) {
		this.price = price;
	}
}
