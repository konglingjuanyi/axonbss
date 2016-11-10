package com.ai.bss.webapp.policy.model;

public abstract class AbstractPolicyUnit {
	private String name;
	private String code;
	public AbstractPolicyUnit() {
		
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
