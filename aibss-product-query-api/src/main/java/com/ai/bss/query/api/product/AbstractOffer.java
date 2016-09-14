package com.ai.bss.query.api.product;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.ai.bss.api.base.TimePeriod;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractOffer {
	@Version
    private long version;

	private String customerId;
	private String productOfferingId;	
	@Id
	private String id;
	
	@OneToMany(mappedBy="offerInstance",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<AbstractOfferProductRel> includedProducts=new LinkedHashSet<AbstractOfferProductRel>();
	
	@OneToMany(mappedBy="offerInstance",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<AbstractPrice> appliedCharges=new LinkedHashSet<AbstractPrice>();
		
	@OneToMany(mappedBy="offerInstance",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<AbstractOfferCharacterValue> characterValues=new LinkedHashSet<AbstractOfferCharacterValue>();

		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public AbstractOffer() {
	}
	
	public String getCustomerId() {
		return customerId;
	}

	
	public void setCustomerId(String customerId) {
		this.customerId=customerId;
	}

	
	public String getProductOfferingId() {
		return productOfferingId;
	}

	
	public void setProductOfferingId(String productOfferingId) {
		this.productOfferingId=productOfferingId;
	}
	
	public  Set<AbstractOfferCharacterValue> getCharacterValues(){
		return characterValues;
	}
	public void addCharacterValue(AbstractOfferCharacterValue characterValue){
		if(null!=characterValue){
			this.characterValues.add(characterValue);
		}
	}	
	public Set<AbstractOfferProductRel> getProducts() {
		return includedProducts;
	}
	
	protected abstract AbstractOfferProductRel newOfferInstanceProductRel();
		
	public void addProduct(AbstractProduct product,TimePeriod validPeriod) {
		if (null!=product){
			AbstractOfferProductRel offerInstanceProductRel=newOfferInstanceProductRel();
			offerInstanceProductRel.setOfferInstance(this);
			offerInstanceProductRel.setProduct(product);
			offerInstanceProductRel.setValidPeriod(validPeriod);
			if(!includedProducts.contains(offerInstanceProductRel)){
				includedProducts.add(offerInstanceProductRel);
			}
			if (!product.getParticipantOfferInstances().contains(this)){
				product.getParticipantOfferInstances().add(offerInstanceProductRel);
			}
		}
	}
	public void removeProduct(AbstractProduct product) {
		if (null!=product){
			AbstractOfferProductRel offerInstanceProductRel=newOfferInstanceProductRel();
			offerInstanceProductRel.setOfferInstance(this);
			offerInstanceProductRel.setProduct(product);
			if(includedProducts.contains(offerInstanceProductRel)){
				includedProducts.remove(offerInstanceProductRel);
			}
			if (product.getParticipantOfferInstances().contains(this)){
				product.getParticipantOfferInstances().remove(offerInstanceProductRel);
			}
		}
	}	

	public Set<AbstractPrice> getAppliedCharges() {
		return appliedCharges;
	}

	public void addAppliedCharge(AbstractPrice appliedCharge) {
		if (null!=appliedCharge){
			appliedCharges.add(appliedCharge);
			if (null==appliedCharge.getOfferInstance()){
				appliedCharge.setOfferInstance(this);
			}
		}
	}
}
