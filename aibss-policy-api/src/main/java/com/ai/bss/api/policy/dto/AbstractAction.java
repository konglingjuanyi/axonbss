package com.ai.bss.api.policy.dto;

public abstract class AbstractAction {
	private String actionId;
	private String name;
	private String code;

	public AbstractAction() {
		// TODO Auto-generated constructor stub
	}

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public abstract boolean isComposite();
}
