package com.ai.bss.query.policy;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PL_FUNCTION_VALUE_PARAM_REL")
public class PolicyFunctionValueParamRelEntry{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	@ManyToOne
	private PolicyFunctionValueEntry functionValue;
	@OneToOne
	private PolicyFunctionParameterEntry param;
	@Embedded
	private PolicyPanEntry paramValuePan;
	public PolicyFunctionValueParamRelEntry() {
	}

	
	public PolicyFunctionValueEntry getFunctionValue() {
		return this.functionValue;
	}

	
	public void setFunctionValue(PolicyFunctionValueEntry functionValue) {
		this.functionValue=functionValue;
	}

	
	public PolicyFunctionParameterEntry getParameter() {
		return this.param;
	}

	
	public void setParameter(PolicyFunctionParameterEntry param) {
		this.param=param;
	}

	
	public String toBodyString() {
		return this.getParamValuePan().toBodyString();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public PolicyPanEntry getParamValuePan() {
		return paramValuePan;
	}


	public void setParamValuePan(PolicyPanEntry paramValuePan) {
		this.paramValuePan = paramValuePan;
	}

}
