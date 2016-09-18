package com.ai.bss.api.policy.dto;

import java.util.LinkedHashSet;
import java.util.Set;

public class FunctionValuePan extends AbstractPan {
	private String functionId;
	private Set<FunctionValuePanParamter> parameterValues= new LinkedHashSet<>();
	public FunctionValuePan() {
		
	}
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	public Set<FunctionValuePanParamter> getParameterValues() {
		return parameterValues;
	}
	
	public void addParameterValue(FunctionValuePanParamter value){
		if (!parameterValues.contains(value)){
			parameterValues.add(value);
		}
	}


}
