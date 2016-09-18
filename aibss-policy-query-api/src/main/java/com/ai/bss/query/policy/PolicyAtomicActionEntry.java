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
public class PolicyAtomicActionEntry extends PolicyActionEntry{
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="action")
	private PolicyActionStatementEntry statement;
	public PolicyAtomicActionEntry(PolicySetEntry policyset) {
		super(policyset);
	}

	
	public String toBodyString() {
		return this.getStatement().toBodyString()+";\n";
	}

	
	public PolicyActionStatementEntry getStatement() {
		return this.statement;
	}

	
	public void setStatement(PolicyActionStatementEntry statement) {
		this.statement=statement;
	}

	
	public Set<PolicyVariableEntry> getVariables() {
		Set<PolicyVariableEntry> variables=new HashSet<PolicyVariableEntry>();
		if (null!=this.getStatement().getVariables()){
			variables.addAll(this.getStatement().getVariables());
		}		
		return variables;
	}

}
