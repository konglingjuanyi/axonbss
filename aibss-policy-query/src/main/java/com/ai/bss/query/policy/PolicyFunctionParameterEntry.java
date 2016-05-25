package com.ai.bss.query.policy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PL_FUNCTION_PARAMETER")
public class PolicyFunctionParameterEntry{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private String name;
	private String code;
	@ManyToOne
	private PolicyFunctionEntry function;
	private String paramType;
	
	public PolicyFunctionParameterEntry() {
	}

	
	public String getName() {
		return this.name;
	}

	
	public void setName(String name) {
		this.name=name;
	}

	
	public String getCode() {
		return this.code;
	}

	
	public void setCode(String code) {
		this.code=code;
	}

	
	public PolicyFunctionEntry getFunction() {
		return this.function;
	}

	
	public void setFunction(PolicyFunctionEntry function) {
		this.function=function;
	}

	
	public String getParameterType() {
		return this.paramType;
	}

	
	public void setParameterType(String paramType) {
		this.paramType=paramType;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

}
