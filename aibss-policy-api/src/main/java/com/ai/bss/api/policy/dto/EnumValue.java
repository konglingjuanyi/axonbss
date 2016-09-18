package com.ai.bss.api.policy.dto;

import com.ai.bss.api.base.CharacteristicSpecValue;

public class EnumValue extends AbstractValue {
	private CharacteristicSpecValue enumValue;
	public EnumValue() {
		
	}
	public CharacteristicSpecValue getEnumValue() {
		return enumValue;
	}
	public void setEnumValue(CharacteristicSpecValue enumValue) {
		this.enumValue = enumValue;
	}

}
