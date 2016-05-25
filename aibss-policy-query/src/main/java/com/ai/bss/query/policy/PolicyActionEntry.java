package com.ai.bss.query.policy;

import java.util.Set;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="PL_ACTION")
@DiscriminatorColumn(name="TYPE",discriminatorType=DiscriminatorType.STRING)
public abstract class PolicyActionEntry{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String code;
	@Column(insertable = false, updatable = false,name="TYPE")
	private String type;
	
	@ManyToOne
	private PolicyActionEntry parentAction;
	
	@OneToOne
	private PolicySetEntry policyset;
	
	protected PolicyActionEntry(PolicySetEntry policyset){
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

	
	public abstract String toBodyString();
	
	
	public abstract Set<PolicyVariableEntry> getVariables();


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public PolicyActionEntry getParentAction() {
		return parentAction;
	}


	public void setParentAction(PolicyActionEntry parentAction) {
		this.parentAction = parentAction;
	}


	public PolicySetEntry getPolicyset() {
		return policyset;
	}


	public void setPolicyset(PolicySetEntry policyset) {
		this.policyset = policyset;
	}

}
