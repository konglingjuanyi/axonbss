package com.ai.bss.query.policy;

import javax.persistence.Entity;

@Entity
public class PolicyOperatorStringEqualsEntry extends PolicyConditionOperatorEntry{

	public PolicyOperatorStringEqualsEntry() {
		super.setCode("equalsIgnoreCase");
	}
	
	
	public String toBodyString(String a,String b) {
		StringBuffer sb=new StringBuffer();
		sb.append(a)
			.append(".")
			.append(this.getCode())
			.append("(")
			.append(b)
			.append(")");
		return sb.toString();
	}
}
