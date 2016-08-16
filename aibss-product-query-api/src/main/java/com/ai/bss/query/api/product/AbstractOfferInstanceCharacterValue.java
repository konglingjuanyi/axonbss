package com.ai.bss.query.api.product;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractOfferInstanceCharacterValue{
	@Id
	private String id;
	@ManyToOne
	private AbstractOfferInstanceCharacter offerInstanceCharacter;
	
	public AbstractOfferInstanceCharacterValue() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AbstractOfferInstanceCharacter getOfferInstanceCharacter(){
		return offerInstanceCharacter;
	}

	public void setOfferInstanceCharacter(AbstractOfferInstanceCharacter offerInstanceCharacter){
		this.offerInstanceCharacter=offerInstanceCharacter;
	}


}
