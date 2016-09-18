package com.ai.bss.query.policy;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class PolicyFunctionValueEntry extends PolicyValueEntry {
	@OneToOne
	private PolicyFunctionEntry function;
	@OneToMany(mappedBy="functionValue")
	Set<PolicyFunctionValueParamRelEntry> params=new LinkedHashSet<PolicyFunctionValueParamRelEntry>();
	public PolicyFunctionValueEntry(PolicySetEntry policyset) {
		super(policyset);
	}


	
	public PolicyFunctionEntry getFunction() {
		return this.function;
	}

	
	public void setFunction(PolicyFunctionEntry function) {
		this.function=function;		
	}


	
	public String toBodyString() {
		StringBuffer sb=new StringBuffer();
		sb.append(this.getFunction().getClassName())
		.append(".")
		.append(this.getFunction().getMethodName())
		.append("(");
		Set<PolicyFunctionValueParamRelEntry> params=this.getParams();
		for (PolicyFunctionValueParamRelEntry paramRel : params) {
			sb.append(paramRel.toBodyString());
			sb.append(",");
		}
		int lastIdx=sb.lastIndexOf(",");
		if(lastIdx>0){
			sb.delete(lastIdx, sb.length());
		}
		sb.append(")");
		return sb.toString();
	}


	
	public Set<PolicyFunctionValueParamRelEntry> getParams() {
		return this.params;
	}


	
	public void addParam(PolicyFunctionValueParamRelEntry param) {
		if(null!=param){
			params.add(param);
			if (null==param.getFunctionValue()){
				param.setFunctionValue(this);
			}
		}
		
	}
	
	
	public String getValue() {
		return this.toBodyString();
	}

	
	public void setValue(String value) {
		// do nothing
	}
	
	
	public Set<PolicyVariableEntry> getVariables() {
		Set<PolicyVariableEntry> variables=new HashSet<PolicyVariableEntry>();
		Set<PolicyFunctionValueParamRelEntry> params=this.getParams();
		for (PolicyFunctionValueParamRelEntry paramRel : params) {
			Set<PolicyVariableEntry> paramVariables=paramRel.getParamValuePan().getVariables();
			if (null!=paramVariables){
				variables.addAll(paramVariables);
			}			
		}
		return variables;
	}

}
