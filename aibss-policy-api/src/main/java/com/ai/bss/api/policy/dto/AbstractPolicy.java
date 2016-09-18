package com.ai.bss.api.policy.dto;

public abstract class AbstractPolicy {
	private AbstractAction elseAction;
	public AbstractPolicy() {
		
	}
	public AbstractAction getElseAction() {
		return elseAction;
	}
	public void setElseAction(AbstractAction elseAction) {
		this.elseAction = elseAction;
	}

}
