package com.ai.bss.webapp.policy.model;

public class EnumValue extends AbstractPolicyUnit {
	private String enumSpecCode;
	private String enumValueSpecCode;
	public EnumValue() {
		
	}
	public String getEnumSpecCode() {
		return enumSpecCode;
	}
	public void setEnumSpecCode(String enumSpecCode) {
		this.enumSpecCode = enumSpecCode;
	}
	public String getEnumValueSpecCode() {
		return enumValueSpecCode;
	}
	public void setEnumValueSpecCode(String enumValueSpecCode) {
		this.enumValueSpecCode = enumValueSpecCode;
	}

}
