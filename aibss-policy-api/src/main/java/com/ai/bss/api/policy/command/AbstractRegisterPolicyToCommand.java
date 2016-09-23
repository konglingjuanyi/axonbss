package com.ai.bss.api.policy.command;

public abstract class AbstractRegisterPolicyToCommand extends AbstractPolicyCommand {
	private String commandName;
	private String commandPropertyName;
	private String commandPropertyValue;
	public AbstractRegisterPolicyToCommand() {
		
	}
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String command) {
		this.commandName = command;
	}
	public String getCommandPropertyValue() {
		return commandPropertyValue;
	}
	public void setCommandPropertyValue(String commandPropertyValue) {
		this.commandPropertyValue = commandPropertyValue;
	}
	public String getCommandPropertyName() {
		return commandPropertyName;
	}
	public void setCommandPropertyName(String commandPropertyName) {
		this.commandPropertyName = commandPropertyName;
	}
}
