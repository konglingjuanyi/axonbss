package com.ai.bss.webapp.policy.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class FunctionValue extends AbstractPolicyUnit {
	private String functionId;
	Set<FunctionParameter> parameters =new LinkedHashSet<>();
	public FunctionValue() {
		
	}
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	public Set<FunctionParameter> getParameters() {
		return parameters;
	}
	public void addParameter(FunctionParameter parameter){
		if(!parameters.contains(parameter)){
			parameters.add(parameter);
		}
	}

}
