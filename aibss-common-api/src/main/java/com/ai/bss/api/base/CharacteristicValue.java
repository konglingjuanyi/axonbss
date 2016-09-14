package com.ai.bss.api.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class CharacteristicValue{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	private String characteristicSpecId;
	private String characteristicSpecName;
	private String valueSpecId;	
	private String value;

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

	public String getCharacteristicSpecId() {
		return characteristicSpecId;
	}

	public void setCharacteristicSpecId(String characteristicSpecId) {
		this.characteristicSpecId = characteristicSpecId;
	}

	public String getCharacteristicSpecName() {
		return characteristicSpecName;
	}

	public void setCharacteristicSpecName(String characteristicSpecName) {
		this.characteristicSpecName = characteristicSpecName;
	}
}
