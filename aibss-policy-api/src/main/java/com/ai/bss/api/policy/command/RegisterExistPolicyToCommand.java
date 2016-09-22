package com.ai.bss.api.policy.command;

public class RegisterExistPolicyToCommand extends AbstractRegisterPolicyToCommand {
	private String policyId;
	public RegisterExistPolicyToCommand() {
		
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

}
