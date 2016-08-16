package com.ai.bss.query.api.product;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.ai.bss.api.base.TimePeriod;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractOfferInstance {

	private String customerId;
	private String productOfferingId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@OneToMany(mappedBy="offerInstance",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<AbstractOfferInstanceProductRel> includedProducts=new LinkedHashSet<AbstractOfferInstanceProductRel>();
	
	@OneToMany(mappedBy="offerInstance",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<AbstractPricePlanInstance> prices=new LinkedHashSet<AbstractPricePlanInstance>();
	
	@OneToMany(mappedBy="offerInstance",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<AbstractOfferInstanceCharacter> characterInstances=new LinkedHashSet<AbstractOfferInstanceCharacter>();

		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public AbstractOfferInstance() {
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
	
	public  Set<AbstractOfferInstanceCharacter> getOfferInstanceCharacters(){
		Set<AbstractOfferInstanceCharacter> characterInstances=new LinkedHashSet<AbstractOfferInstanceCharacter>();
		characterInstances.addAll(characterInstances);
		return characterInstances;
	}
	public void addOfferInstanceCharacter(AbstractOfferInstanceCharacter character){
		if(null!=character){
			this.characterInstances.add((OfferInstanceCharacterEntry)character);
		}
	}	
	public Set<AbstractOfferInstanceProductRel> getProducts() {
		return includedProducts;
	}
	
	protected abstract AbstractOfferInstanceProductRel newOfferInstanceProductRel();
	
	public void addProduct(AbstractProduct product,TimePeriod validPeriod) {
		if (null!=product){
			AbstractOfferInstanceProductRel offerInstanceProductRel=newOfferInstanceProductRel();
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
			AbstractOfferInstanceProductRel offerInstanceProductRel=newOfferInstanceProductRel();
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

	public Set<AbstractPricePlanInstance> getPricePlanInstances() {
		return prices;
	}

	public void addPricePlanInstance(AbstractPricePlanInstance pricePlanInstance) {
		if (null!=pricePlanInstance){
			prices.add(pricePlanInstance);
			if (null==pricePlanInstance.getOfferInstance()){
				pricePlanInstance.setOfferInstance(this);
			}
		}

	}

}
