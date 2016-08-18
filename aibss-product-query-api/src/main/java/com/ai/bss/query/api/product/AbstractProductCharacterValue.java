package com.ai.bss.query.api.product;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractProductCharacterValue {
	@Id
	private String id;
	private String valueSpecId;
	private String valueSpecCode;
	private String value;
	
	@ManyToOne
	private  AbstractProductCharacter  productCharacter;
		
	public AbstractProductCharacter getProductCharacter() {
		return productCharacter;
	}

	public void setProductCharacter(AbstractProductCharacter productCharacter) {
		this.productCharacter = productCharacter;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValueSpecCode() {
		return valueSpecCode;
	}

	public void setValueSpecCode(String code) {
		this.valueSpecCode = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValueSpecId() {
		return valueSpecId;
	}

	public void setValueSpecId(String valueSpecId) {
		this.valueSpecId = valueSpecId;
	}
	
}
