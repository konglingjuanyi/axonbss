package com.ai.bss.api.policy.dto;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class AbstractPolicy {
	private String policyId;
	private String name;
	private String code;
	private AbstractAction elseAction;
	private Set<Parameter> inputParameteres= new LinkedHashSet<>();
	private Parameter outputParameter;
	public AbstractPolicy() {
		
	}
	public AbstractAction getElseAction() {
		return elseAction;
	}
	public void setElseAction(AbstractAction elseAction) {
		this.elseAction = elseAction;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
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
	public Parameter getOutputParameter() {
		return outputParameter;
	}
	public void setOutputParameter(Parameter outputParameter) {
		this.outputParameter = outputParameter;
	}
	public Set<Parameter> getInputParameteres() {
		return inputParameteres;
	}
	public void addInputParameter(Parameter parameter){
		if(!inputParameteres.contains(parameter)){
			inputParameteres.add(parameter);
		}
	}
	public abstract boolean isComposite();
}
