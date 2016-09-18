package com.ai.bss.query.policy;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embeddable;
@Embeddable
@DiscriminatorColumn(name="PAN_TYPE",discriminatorType=DiscriminatorType.STRING)
public abstract class PolicyPanEntry {
	@Column(name="PAN_TYPE")
	private String panType;
			
	public PolicyPanEntry() {
		
	}
	
	public PolicyPanEntry(String panType) {
		this.panType=panType;
	}
	
	public abstract String toBodyString();
		
	public abstract Set<PolicyVariableEntry> getVariables();
}
