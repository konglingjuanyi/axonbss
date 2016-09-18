package com.ai.bss.query.policy;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
@MappedSuperclass
@DiscriminatorValue("Variable")
public class PolicyVariablePanEntry extends PolicyPanEntry{
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="VARIABLE_ID")
	private PolicyVariableEntry panVariable;
	
	public PolicyVariablePanEntry(){
		super("Variable");
	}
		
	public PolicyVariablePanEntry(PolicyVariableEntry panValue) {		
		super("Variable");
		this.panVariable=panValue;
	}	
	
	public String toBodyString(){
		return this.getPolicyVariable().toBodyString();
	}
	
	public Set<PolicyVariableEntry> getVariables(){
		Set<PolicyVariableEntry> variables=new LinkedHashSet<PolicyVariableEntry>();
		variables.add(this.getPolicyVariable());
		return variables;
	}

	public PolicyVariableEntry getPolicyVariable() {
		return panVariable;
	}

	public void setPolicyVariable(PolicyVariableEntry panVariable) {
		this.panVariable = panVariable;
	}
}
