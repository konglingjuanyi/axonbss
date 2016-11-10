package com.ai.bss.webapp.policy.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class CompositeCondition extends BaseCondition {
	private Set<BaseCondition> children =new LinkedHashSet<>();
	public CompositeCondition() {
		super("Composite");
	}
	public Set<BaseCondition> getChildren() {
		return children;
	}
	
	public void addChild(BaseCondition child){
		if(!children.contains(child)){
			children.add(child);
		}
	}

}
