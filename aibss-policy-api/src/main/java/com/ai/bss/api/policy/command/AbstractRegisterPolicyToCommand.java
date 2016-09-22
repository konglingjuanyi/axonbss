package com.ai.bss.api.policy.command;

import com.ai.bss.api.base.BaseCommand;

public abstract class AbstractRegisterPolicyToCommand extends BaseCommand {
	private BaseCommand command;
	private String commandPropertyValue;
	public AbstractRegisterPolicyToCommand() {
		
	}
	public BaseCommand getCommand() {
		return command;
	}
	public void setCommand(BaseCommand command) {
		this.command = command;
	}
	public String getCommandPropertyValue() {
		return commandPropertyValue;
	}
	public void setCommandPropertyValue(String commandPropertyValue) {
		this.commandPropertyValue = commandPropertyValue;
	}
}
