package com.ai.bss.api.policy.event;

import com.ai.bss.api.base.BaseEvent;
import com.ai.bss.api.policy.PolicyId;

public class PolicyRegisteredToCommandEvent extends BaseEvent{
	private String commandName;
	private String commandPropertyValue;
	private PolicyId policyId;
	public PolicyRegisteredToCommandEvent() {
		// TODO Auto-generated constructor stub
	}
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	public String getCommandPropertyValue() {
		return commandPropertyValue;
	}
	public void setCommandPropertyValue(String commandPropertyValue) {
		this.commandPropertyValue = commandPropertyValue;
	}
	public PolicyId getPolicyId() {
		return policyId;
	}
	public void setPolicyId(PolicyId policyId) {
		this.policyId = policyId;
	}

}
