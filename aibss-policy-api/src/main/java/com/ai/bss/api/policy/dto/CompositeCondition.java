package com.ai.bss.api.policy.dto;

import java.util.LinkedHashSet;
import java.util.Set;

public class CompositeCondition extends AbstractCondition{
	private boolean isAnd;
	private Set<AbstractCondition> childConditions = new LinkedHashSet<>();
	
	public CompositeCondition( ) {}
	
	public boolean isAnd() {
		return isAnd;
	}
	public void setAnd(boolean isAnd) {
		this.isAnd = isAnd;
	}
	public Set<AbstractCondition> getChildConditions() {
		return childConditions;
	}
	public void addChildCondition(AbstractCondition childCondition){
		if (!childConditions.contains(childCondition)){
			childConditions.add(childCondition);
		}
	}
	//@Override
	public boolean isComposite() {
		return true;
	}

}
