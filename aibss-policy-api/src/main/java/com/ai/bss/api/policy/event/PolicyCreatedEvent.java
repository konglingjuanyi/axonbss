package com.ai.bss.api.policy.event;

import com.ai.bss.api.policy.dto.AbstractPolicy;

public class PolicyCreatedEvent extends AbstractPolicyEvent{
	private AbstractPolicy policy;	
	public PolicyCreatedEvent() {
		
	}
	public AbstractPolicy getPolicy() {
		return policy;
	}
	public void setPolicy(AbstractPolicy policy) {
		this.policy = policy;
	}

}
