package com.ai.bss.api.policy.event;

import com.ai.bss.api.policy.dto.AtomicPolicy;

public class AtomicPolicyCreated extends AbstractPolicyEvent{
	private AtomicPolicy policy;	
	public AtomicPolicyCreated() {
		
	}
	public AtomicPolicy getPolicy() {
		return policy;
	}
	public void setPolicy(AtomicPolicy policy) {
		this.policy = policy;
	}

}
