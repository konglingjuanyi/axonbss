package com.ai.bss.api.policy.dto;

public class Variable {
	private String variableId;
	private AbstractValue defaultValue;
	private String name;
	private String code;
	public Variable() {
		
	}
	public String getVariableId() {
		return variableId;
	}
	public void setVariableId(String variableId) {
		this.variableId = variableId;
	}
	public AbstractValue getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(AbstractValue defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
