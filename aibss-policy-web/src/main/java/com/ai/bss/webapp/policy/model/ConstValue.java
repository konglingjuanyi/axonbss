package com.ai.bss.webapp.policy.model;

public class ConstValue extends AbstractPolicyUnit {
	private String dataType;
	private String value;
	public ConstValue() {
		
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
