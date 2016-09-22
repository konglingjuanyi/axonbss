package com.ai.bss.api.policy.dto;

public class Parameter {
	private String parameterId;
	private String type;
	private AbstractPan paremeterValue;
	private String name;
	private String code;
	public Parameter() {
		
	}
	public String getParameterId() {
		return parameterId;
	}
	public void setParameterId(String parameterId) {
		this.parameterId = parameterId;
	}
	public AbstractPan getValue() {
		return paremeterValue;
	}
	public void setValue(AbstractPan value) {
		this.paremeterValue = value;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
