package com.ai.bss.query.policy;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
@Entity
@DiscriminatorValue("COMPOSITE")
public class PolicyCompositeCondition extends PolicyConditionEntry{
	@OneToMany(mappedBy="parent",fetch=FetchType.LAZY)
	private Set<PolicyCompositeConditionOption> children=new HashSet<PolicyCompositeConditionOption>();
	private boolean isOr;
	public PolicyCompositeCondition(PolicySetEntry policyset) {
		super(policyset);
	}
	
	public Set<PolicyCompositeConditionOption> getChildren() {
		return this.children;
	}

	
	public void addChild(PolicyCompositeConditionOption child) {
		if(child!=null){
			this.children.add(child);
			child.setParentCondition(this);
		}

	}

	
	public String toBodyString() {
		StringBuffer sb=new StringBuffer();
		Set<PolicyCompositeConditionOption> children=this.getChildren();
		if(children.size()>0){
			for (PolicyCompositeConditionOption PolicyCompositeConditionOption : children) {
				sb.append("(");
				sb.append(PolicyCompositeConditionOption.getChildCondition().toBodyString());
				sb.append(")");
				if(this.isOr()){
					sb.append(" || ");
				}else{
					sb.append(" && ");
				}
			}
			int lastIdx=sb.lastIndexOf(" && ");
			if(lastIdx==0){
				lastIdx=sb.lastIndexOf(" || ");
			}
			if(lastIdx>0){
				sb.delete(lastIdx, sb.length());
			}
		}
		
		return sb.toString();
	}

	
	public Set<PolicyVariableEntry> getVariables() {
		Set<PolicyVariableEntry> variables=new HashSet<PolicyVariableEntry>();
		for (PolicyCompositeConditionOption PolicyCompositeConditionOption : children) {
			variables.addAll(PolicyCompositeConditionOption.getChildCondition().getVariables());
		}
		return variables;
	}
	
	
	public boolean isOr() {
		return this.isOr;
	}

	
	public void setOr() {
		this.isOr=true;
	}

	
	public void setAnd() {
		this.isOr=false;
	}
	

}
