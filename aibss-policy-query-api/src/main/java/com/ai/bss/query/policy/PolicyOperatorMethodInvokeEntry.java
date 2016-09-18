package com.ai.bss.query.policy;

import javax.persistence.Entity;

@Entity
public class PolicyOperatorMethodInvokeEntry extends PolicyActionOperatorEntry{

	public PolicyOperatorMethodInvokeEntry() {
	}
	@Override
	public String toBodyString(String a,String b) {
		StringBuffer sb=new StringBuffer();
		if (!a.isEmpty()){
			sb.append(a).append(" = ");
		}
		sb.append(b);
		return sb.toString();
	}
}
