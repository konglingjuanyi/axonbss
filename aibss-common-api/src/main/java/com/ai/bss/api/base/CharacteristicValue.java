package com.ai.bss.api.base;

public class CharacteristicValue{
	private Characteristic characteristic;
	private CharacteristicSpecValue valueSpec;	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
	public Characteristic getCharacteristic() {
		return this.characteristic;
	}

	
	public void setCharacteristic(Characteristic characteristic) {
		this.characteristic=characteristic;
	}

	public CharacteristicSpecValue getValueSpec() {
		return valueSpec;
	}

	public void setValueSpecId(CharacteristicSpecValue valueSpec) {
		this.valueSpec = valueSpec;
	}
}
