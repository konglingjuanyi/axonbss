package com.ai.bss.query.policy;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
@Entity
@DiscriminatorValue("COMPOSITE")
public class PolicyCompositeActionEntry extends PolicyActionEntry{
	@OneToMany(mappedBy="parentAction",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	Set<PolicyActionEntry> children=new LinkedHashSet<PolicyActionEntry>();
	public PolicyCompositeActionEntry(PolicySetEntry policyset) {
		super(policyset);
	}

	
	public String toBodyString() {
		StringBuffer sb=new StringBuffer();
		for (PolicyActionEntry PolicyActionEntry : children) {
			sb.append("            ").append(PolicyActionEntry.toBodyString());
		}
		return sb.toString();
	}

	
	public Set<PolicyActionEntry> getChildren() {
		return this.children;
	}

	
	public void addChild(PolicyActionEntry child) {
		if (null!=child){
			this.children.add(child);	
			child.setParentAction(this);
		}		
	}

	
	public Set<PolicyVariableEntry> getVariables() {
		Set<PolicyVariableEntry> variables=new HashSet<PolicyVariableEntry>();
		for (PolicyActionEntry PolicyActionEntry : children) {
			variables.addAll(PolicyActionEntry.getVariables());
		}
		return variables;
	}

}
