package com.ai.bss.query.policy;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PL_VARIABLE")
public class PolicyVariableEntry{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private String name;
	private String code;
	private String type;

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private PolicyValueEntry value;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private PolicySetEntry policyset;
	
	public PolicyVariableEntry(PolicySetEntry policyset) {
		this.setPolicyset(policyset);
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

	
	public Object getVariableType() {
		return this.type;
	}

	
	public void setVariableType(String type) {
		this.type=type;
	}

	
	public String toBodyString(){
		return this.getCode();
	}

	
	public PolicyValueEntry getValue() {
		return this.value;
	}

	
	public void setValue(PolicyValueEntry value) {
		this.value=value;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public PolicySetEntry getPolicyset() {
		return policyset;
	}


	public void setPolicyset(PolicySetEntry policyset) {
		this.policyset = policyset;
	}

}
