package com.ai.bss.query.api.product;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.ai.bss.api.base.TimePeriod;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractProductPriceRel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;	
	
	@ManyToOne
	private AbstractProduct product;
	@ManyToOne
	private AbstractPrice price;
	
	@Embedded
	private TimePeriod validPeriod;
	
	public AbstractProductPriceRel() {
	}
	
	public AbstractProduct getProduct() {
		return this.product;
	}

	
	public void setProduct(AbstractProduct product) {
		this.product=product;
	}

	
	public AbstractPrice getPricePlanInstance() {
		return this.price;
	}

	
	public void setPricePlanInstance(AbstractPrice price) {
		this.price=price;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public TimePeriod getValidPeriod() {
		return this.validPeriod;
	}

	
	public void setValidPeriod(TimePeriod validPeriod) {
		this.validPeriod=validPeriod;
	}

}
