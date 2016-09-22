package com.ai.bss.api.policy.command;

import com.ai.bss.api.policy.dto.AtomicPolicy;

public class RegisterNewAtomicPolicyToCommand extends AbstractRegisterPolicyToCommand {
	private AtomicPolicy policy;
	public RegisterNewAtomicPolicyToCommand() {
		
	}
	public AtomicPolicy getPolicy() {
		return policy;
	}
	public void setPolicy(AtomicPolicy policy) {
		this.policy = policy;
	}

}
