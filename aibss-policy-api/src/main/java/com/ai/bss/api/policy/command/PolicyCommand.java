package com.ai.bss.api.policy.command;

import com.ai.bss.api.base.BaseCommand;
import com.ai.bss.api.policy.PolicyId;

public abstract class PolicyCommand extends BaseCommand {
	private PolicyId policyId;

	public PolicyId getPolicyId() {
		return policyId;
	}

	public void setPolicyId(PolicyId policyId) {
		this.policyId = policyId;
	}
	

}
