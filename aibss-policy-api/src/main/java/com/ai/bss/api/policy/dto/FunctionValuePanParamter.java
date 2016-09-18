package com.ai.bss.api.policy.dto;

public class FunctionValuePanParamter {
	private String parameterId;
	private AbstractPan parameterValue;
	public FunctionValuePanParamter() {
		// TODO Auto-generated constructor stub
	}
	public String getParameterId() {
		return parameterId;
	}
	public void setParameterId(String parameterId) {
		this.parameterId = parameterId;
	}
	public AbstractPan getParameterValue() {
		return parameterValue;
	}
	public void setParameterValue(AbstractPan parameterValue) {
		this.parameterValue = parameterValue;
	}

}
