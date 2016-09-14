package com.ai.bss.query.api.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractProductSuspendReason{
	private String suspendCode;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id;
	
	@ManyToOne
	private AbstractProduct product;
	public AbstractProduct getProduct() {
		return this.product;
	}

	
	public void setProduct(AbstractProduct product) {
		this.product=product;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public AbstractProductSuspendReason() {
	}

	
	public String getSuspendCode() {
		return this.suspendCode;
	}

	
	public void setSuspendCode(String suspendCode) {
		this.suspendCode=suspendCode;
	}
}
