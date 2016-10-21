package com.ai.bss.api.policy.dto;

public class AtomicPolicy extends AbstractPolicy{
	private AbstractCondition condition;
	private AbstractAction action;
	public AtomicPolicy() {
	}
	public AbstractCondition getCondition() {
		return condition;
	}
	public void setCondition(AbstractCondition condition) {
		this.condition = condition;
	}
	public AbstractAction getAction() {
		return action;
	}
	public void setAction(AbstractAction action) {
		this.action = action;
	}
	@Override
	public boolean isComposite() {
		return false;
	}

}
