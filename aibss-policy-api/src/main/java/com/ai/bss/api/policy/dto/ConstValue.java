package com.ai.bss.api.policy.dto;

public class ConstValue extends AbstractValue {
	private String dataType;
	private String value;
	public ConstValue() {
		super("Const");
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}


}
