package com.ai.bss.webapp.policy.model;

public class BaseCondition extends AbstractPolicyUnit {
	String conditionType;
	public BaseCondition(String conditionType) {
		this.conditionType=conditionType;
	}
	public String getConditionType() {
		return conditionType;
	}
}
