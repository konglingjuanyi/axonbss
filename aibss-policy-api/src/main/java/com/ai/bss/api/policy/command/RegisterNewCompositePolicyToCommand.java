package com.ai.bss.api.policy.command;

import com.ai.bss.api.policy.dto.CompositePolicy;

public class RegisterNewCompositePolicyToCommand extends AbstractRegisterPolicyToCommand {
	private CompositePolicy policy;
	public RegisterNewCompositePolicyToCommand() {
		
	}
	public CompositePolicy getPolicy() {
		return policy;
	}
	public void setPolicy(CompositePolicy policy) {
		this.policy = policy;
	}

}
