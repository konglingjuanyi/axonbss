package com.ai.bss.api.policy.dto;

public abstract class AbstractPan {	  
	private String type;		
	public AbstractPan(String panType) {
		this.type = panType;
	}
	public String getType() {
		return type;
	}
}
