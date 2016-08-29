package com.ai.bss.api.base;

public class CharacteristicValue{
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
