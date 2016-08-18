package com.ai.bss.query.api.product;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractProductCharacter {
	@Id
	private String id;
	private String charSpecId;
	private String charSpecCode;
	
	@ManyToOne
	private AbstractProduct product;
	@OneToMany(mappedBy="productCharacter",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<AbstractProductCharacterValue> productCharacterValues=new LinkedHashSet<AbstractProductCharacterValue>();
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCharSpecCode() {
		return charSpecCode;
	}

	public void setCharSpecCode(String code) {
		this.charSpecCode = code;
	}
	
	public AbstractProduct getProduct() {
		return product;
	}
	public void setProduct(AbstractProduct product) {
		this.product = product;
	}
	public Set<AbstractProductCharacterValue> getproductCharacterValues() {
		return this.productCharacterValues;
	}
	
	public void addproductCharacterValue(AbstractProductCharacterValue characteristicInstanceValue) {
		this.productCharacterValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getProductCharacter()){
			characteristicInstanceValue.setProductCharacter(this);
		}

	}

	public String getCharSpecId() {
		return charSpecId;
	}

	public void setCharSpecId(String charSpecId) {
		this.charSpecId = charSpecId;
	}
}
