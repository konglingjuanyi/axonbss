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
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractOfferInstanceCharacter{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@ManyToOne
	private AbstractOfferInstance offerInstance;
	@OneToMany(mappedBy="OfferInstanceEntryCharacter",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<AbstractOfferInstanceCharacterValue> offerInstanceCharacterValues=new LinkedHashSet<AbstractOfferInstanceCharacterValue>();
	
	public AbstractOfferInstance getOfferInstance() {
		return offerInstance;
	}
	protected void setOfferInstance(AbstractOfferInstance offerInstance) {
		this.offerInstance = offerInstance;
	}
	public Set<AbstractOfferInstanceCharacterValue> getOfferInstanceCharacterValues() {
		return offerInstanceCharacterValues;
	}
	protected void addOfferInstanceCharacterValue(AbstractOfferInstanceCharacterValue characteristicInstanceValue) {
		this.offerInstanceCharacterValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getOfferInstanceCharacter()){
			characteristicInstanceValue.setOfferInstanceCharacter(this);
		}
	}		
}
