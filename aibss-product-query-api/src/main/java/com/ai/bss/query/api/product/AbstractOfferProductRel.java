package com.ai.bss.query.api.product;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ai.bss.api.base.TimePeriod;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractOfferProductRel{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id;
	
	private String role;
	
	private String relType;//CREATE,REFRENCE
	
	@Embedded
	private TimePeriod validPeriod;
	
	@ManyToOne
	@JoinColumn(name="OFFER_INSTANCE_ID")
	private AbstractOffer offerInstance;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private AbstractProduct product;
	

	public AbstractProduct getProduct() {
		return product;
	}

	public void setProduct(AbstractProduct product) {
		this.product = product;
	}
	
	public AbstractOffer getOfferInstance() {
		return offerInstance;
	}

	public void setOfferInstance(AbstractOffer offerInstance) {
		this.offerInstance = offerInstance;
	}

	public AbstractOfferProductRel() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRelType() {
		return relType;
	}
	

	public void setRelType(String relType) {
		this.relType = relType;
	}
	
	public TimePeriod getValidPeriod() {
		return this.validPeriod;
	}

	
	public void setValidPeriod(TimePeriod validPeriod) {
		this.validPeriod=validPeriod;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
