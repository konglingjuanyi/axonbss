package com.ai.bss.api.policy.dto;

import com.ai.bss.api.base.CharacteristicSpecValue;

public class EnumValuePan extends AbstractPan {
	private CharacteristicSpecValue policyValue;
	public EnumValuePan() {
		
	}
	public CharacteristicSpecValue getPolicyValue() {
		return policyValue;
	}
	public void setPolicyValue(CharacteristicSpecValue policyValue) {
		this.policyValue = policyValue;
	}

}
