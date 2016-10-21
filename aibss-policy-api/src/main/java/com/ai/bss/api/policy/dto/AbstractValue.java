package com.ai.bss.api.policy.dto;

public abstract class AbstractValue {
	private String valueId;
	private String type;
	private String name;
	private String code;
	protected AbstractValue(String type) {
		this.type=type;
	}
	public String getValueId() {
		return valueId;
	}
	public void setValueId(String valueId) {
		this.valueId = valueId;
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

}
