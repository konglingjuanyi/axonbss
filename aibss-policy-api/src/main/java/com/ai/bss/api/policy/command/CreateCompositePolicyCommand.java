package com.ai.bss.api.policy.command;

import com.ai.bss.api.policy.dto.CompositePolicy;

public class CreateCompositePolicyCommand extends AbstractPolicyCommand {
	private CompositePolicy policy;
	public CreateCompositePolicyCommand() {
		
	}
	public CompositePolicy getPolicy() {
		return policy;
	}
	public void setPolicy(CompositePolicy policy) {
		this.policy = policy;
	}
}
