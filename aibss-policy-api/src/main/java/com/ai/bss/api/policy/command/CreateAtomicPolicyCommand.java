package com.ai.bss.api.policy.command;

import com.ai.bss.api.policy.dto.AtomicPolicy;

public class CreateAtomicPolicyCommand extends AbstractPolicyCommand {
	private AtomicPolicy policy;
	public CreateAtomicPolicyCommand() {
		
	}
	public AtomicPolicy getPolicy() {
		return policy;
	}
	public void setPolicy(AtomicPolicy policy) {
		this.policy = policy;
	}
}
