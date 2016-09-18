package com.ai.bss.query.policy;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CONST")
public class PolicyConstValue extends PolicyValueEntry{

	public PolicyConstValue(PolicySetEntry policyset) {
		super(policyset);
	}

	@Override
	public String toBodyString() {
		return this.getValue();
	}
	@Override
	public Set<PolicyVariableEntry> getVariables() {
		return null;
	}
}
