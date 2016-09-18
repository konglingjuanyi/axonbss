package com.ai.bss.query.policy;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("ATOMIC")
public class PolicyAtomicConditionEntry extends PolicyConditionEntry {
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="condition")
	private PolicyConditionStatementEntry statement;
	public PolicyAtomicConditionEntry(PolicySetEntry policyset) {
		super(policyset);
	}

	
	public PolicyConditionStatementEntry getStatement() {
		return this.statement;
	}

	
	public void setStatement(PolicyConditionStatementEntry statement) {
		this.statement=statement;
	}

	
	public String toBodyString() {
		return this.getStatement().toBodyString();
	}

	
	public Set<PolicyVariableEntry> getVariables() {
		Set<PolicyVariableEntry> variables=new HashSet<PolicyVariableEntry>();
		variables.addAll(this.getStatement().getVariables());
		return variables;
	}
}
