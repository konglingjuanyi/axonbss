package com.ai.bss.query.policy;

import javax.persistence.Entity;

@Entity
public class PolicyOperatorNotEntry extends PolicyConditionOperatorEntry{

	public PolicyOperatorNotEntry() {
		super.setCode("!");
	}

	@Override
	public String toBodyString(String a,String b) {
		StringBuffer sb=new StringBuffer();
		sb.append(this.getCode()).append(a);
		return sb.toString();
	}
}
