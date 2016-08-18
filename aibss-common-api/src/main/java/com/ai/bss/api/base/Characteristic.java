package com.ai.bss.api.base;

import java.util.Set;

public class Characteristic{	
	private Set<CharacteristicValue> values=new java.util.LinkedHashSet<CharacteristicValue>();	
	private CharacteristicSpec charSpec;
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<CharacteristicValue> getValues() {
		return this.values;
	}

	
	public void addValue(CharacteristicValue value) {
		if (null!=value){
			values.add(value);
			if (null==value.getCharacteristic()){
				value.setCharacteristic(this);
			}
		}
	}

	public CharacteristicSpec getCharSpec() {
		return charSpec;
	}

	public void setCharSpec(CharacteristicSpec charSpec) {
		this.charSpec = charSpec;
	}
}
