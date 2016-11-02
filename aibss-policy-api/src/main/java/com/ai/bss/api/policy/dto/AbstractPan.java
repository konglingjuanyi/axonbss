package com.ai.bss.api.policy.dto;

public class AbstractPan {	  
	private String type;	
	public AbstractPan(){
		
	}
	public AbstractPan(String panType) {
		this.type = panType;
	}
	public String getType() {
		return type;
	}
}
