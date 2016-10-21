package com.ai.bss.api.policy.dto;

public class ValuePan extends AbstractPan {
	private AbstractValue value;
	public ValuePan() {
		super("Value");
	}
	public AbstractValue getValue() {
		return value;
	}
	public void setValue(AbstractValue value) {
		this.value = value;
	}

}
