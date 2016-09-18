package com.ai.bss.query.policy;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="PL_VALUE")
@DiscriminatorColumn(name="VALUE_TYPE",discriminatorType=DiscriminatorType.STRING)
public abstract class PolicyValueEntry{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private String name;
	private String code;
	private String type;
	private String value;
	@Column(insertable = false, updatable = false,name="VALUE_TYPE")
	private String valueType;
	@ManyToOne(cascade=CascadeType.ALL)
	private PolicySetEntry policyset;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	protected PolicyValueEntry( PolicySetEntry policyset) {
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
	
	
	public String getValue() {
		return this.value;
	}

	
	public void setValue(String value) {
		this.value=value;
	}	

	
	public abstract String toBodyString();
	
	
	public abstract Set<PolicyVariableEntry> getVariables();

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
