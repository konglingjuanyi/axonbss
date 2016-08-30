package com.ai.bss.query.api.product;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractProduct{
	private String customerId;
	private String userId;
	private String productSpecificationId;
		
	@Id
	private String id;	
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<AbstractProductSuspendReason> suspenfReasons=new LinkedHashSet<AbstractProductSuspendReason>();
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<AbstractOfferProductRel> participantOfferInstances=new LinkedHashSet<AbstractOfferProductRel>();
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<AbstractProductPriceRel> assignedPrices=new LinkedHashSet<AbstractProductPriceRel>();
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<AbstractProductCharacterValue> characterValues=new LinkedHashSet<AbstractProductCharacterValue>();
	
	public  Set<AbstractProductCharacterValue> getCharacterValues(){
		return this.characterValues;
	}
	
	public void addCharacterValue(AbstractProductCharacterValue characterValue){
		if(null!=characterValue){
			this.characterValues.add(characterValue);
		}
	}
		
	public Set<AbstractProductSuspendReason> getSuspendReasons() {
		return suspenfReasons;
	}

	
	public void addSuspendReason(AbstractProductSuspendReason productSuspendReason) {
		if (null!=productSuspendReason){
			suspenfReasons.add(productSuspendReason);
			if (null==productSuspendReason.getProduct()){
				productSuspendReason.setProduct(this);
			}
		}
	}
	
	public void deleteSuspendReason(AbstractProductSuspendReason productSuspendReason) {
		if (null!=productSuspendReason&&(productSuspendReason.getProduct().equals(this))){
			suspenfReasons.remove(productSuspendReason);
		}
	}
		
	public Set<AbstractOfferProductRel> getParticipantOfferInstances() {
		return participantOfferInstances;
	}

	
	public Set<AbstractProductPriceRel> getAssignedPrices() {
		return assignedPrices;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	


	public AbstractProduct() {
	}
	
	public String getCustomerId() {
		return customerId;
	}

	
	public void setCustomerId(String customerId) {
		this.customerId=customerId;		
	}

	
	public String getUserId() {
		return userId;
	}

	
	public void setUserId(String userId) {
		this.userId=userId;
	}

	
	public String getProductSpecificationId() {
		return productSpecificationId;
	}

	
	public void setProductSpecificationId(String productSpecificationId) {
		this.productSpecificationId=productSpecificationId;
	}

}
