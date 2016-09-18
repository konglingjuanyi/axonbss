package com.ai.bss.api.policy.dto;

public abstract class AbstractPolicy {
	private String policyId;
	private String name;
	private String code;
	private AbstractAction elseAction;
	public AbstractPolicy() {
		
	}
	public AbstractAction getElseAction() {
		return elseAction;
	}
	public void setElseAction(AbstractAction elseAction) {
		this.elseAction = elseAction;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
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
