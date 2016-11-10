package com.ai.bss.webapp.policy.model;

public class BaseAction extends AbstractPolicyUnit {
	String actionType;
	public BaseAction(String actionType) {
		this.actionType=actionType;
	}
	public String getActionType() {
		return actionType;
	}
	
}
