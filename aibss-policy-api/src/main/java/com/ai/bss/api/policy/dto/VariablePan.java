package com.ai.bss.api.policy.dto;

public class VariablePan extends AbstractPan {
	private Variable  variable;
	public VariablePan() {
		super("Variable");
	}
	public Variable getVariable() {
		return variable;
	}
	public void setVariable(Variable variable) {
		this.variable = variable;
	}

}
