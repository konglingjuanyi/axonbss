package com.ai.bss.api.policy.dto;

import java.util.LinkedHashSet;
import java.util.Set;

public class FunctionValue extends AbstractValue {
	private String functionId;
	private Set<Parameter> parameterValues= new LinkedHashSet<>();
	public FunctionValue() {
		super("Function");
	}
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	public Set<Parameter> getParameterValues() {
		return parameterValues;
	}
	
	public void addParameterValue(Parameter value){
		if (!parameterValues.contains(value)){
			parameterValues.add(value);
		}
	}


}
