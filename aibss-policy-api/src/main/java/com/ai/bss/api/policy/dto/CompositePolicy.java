package com.ai.bss.api.policy.dto;

import java.util.LinkedHashSet;
import java.util.Set;

public class CompositePolicy extends AbstractPolicy{ 
	private Set<AbstractPolicy> childPolicies = new LinkedHashSet<>();
	public CompositePolicy() {
	}
	public Set<AbstractPolicy> getChildPolicies() {
		return childPolicies;
	}
	
	public void addChildPolicy(AbstractPolicy policy){
		if (!childPolicies.contains(policy)){
			childPolicies.add(policy);
		}
	}
	@Override
	public boolean isComposite() {
		return true;
	}

}
