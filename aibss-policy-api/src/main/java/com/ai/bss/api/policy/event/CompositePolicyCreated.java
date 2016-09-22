package com.ai.bss.api.policy.event;

import com.ai.bss.api.policy.dto.CompositePolicy;

public class CompositePolicyCreated extends AbstractPolicyEvent{
	private CompositePolicy policy;	
	public CompositePolicyCreated() {
		
	}
	public CompositePolicy getPolicy() {
		return policy;
	}
	public void setPolicy(CompositePolicy policy) {
		this.policy = policy;
	}

}
