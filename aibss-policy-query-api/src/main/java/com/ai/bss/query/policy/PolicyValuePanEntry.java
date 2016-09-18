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
@DiscriminatorValue("Value")
public class PolicyValuePanEntry extends PolicyPanEntry{
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="VALUE_ID")
	private PolicyValueEntry panValue;
	
	public PolicyValuePanEntry(){
		super("Value");
	}
		
	public PolicyValuePanEntry(PolicyValueEntry panValue) {		
		super("Value");
		this.panValue=panValue;
	}	
	
	public String toBodyString(){
		return this.getPolicyValue().toBodyString();
	}	

	public Set<PolicyVariableEntry> getVariables(){
		Set<PolicyVariableEntry> variables=new LinkedHashSet<PolicyVariableEntry>();
		if (null!=this.getPolicyValue().getVariables()){
			variables.addAll(this.getPolicyValue().getVariables());
		}	
		return variables;
	}
	
	public PolicyValueEntry getPolicyValue() {
		return panValue;
	}

	public void setPolicyValue(PolicyValueEntry value) {
		this.panValue = value;
	}
}
