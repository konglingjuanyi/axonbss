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
public abstract class AbstractPriceCharacterValue extends CharacteristicValue{
	@ManyToOne
	private AbstractPrice price;


	public AbstractPrice getPrice() {
		return price;
	}

	public void setPrice(AbstractPrice price) {
		this.price = price;
	}
}
