package com.ai.bss.api.policy.dto;

public abstract class AbstractCondition {
	private String conditionId;
	private String name;
	private String code;
	public AbstractCondition(){
		
	}
	
	public String getConditionId() {
		return conditionId;
	}
	public void setConditionId(String conditionId) {
		this.conditionId = conditionId;
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
