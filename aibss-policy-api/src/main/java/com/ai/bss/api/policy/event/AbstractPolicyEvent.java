package com.ai.bss.api.policy.event;

import com.ai.bss.api.base.BaseEvent;
import com.ai.bss.api.policy.PolicyId;

public abstract class AbstractPolicyEvent extends BaseEvent {
	private PolicyId policyId;
	public AbstractPolicyEvent() {
		// TODO Auto-generated constructor stub
	}
	public PolicyId getPolicyId() {
		return policyId;
	}
	public void setPolicyId(PolicyId policyId) {
		this.policyId = policyId;
	}

}
