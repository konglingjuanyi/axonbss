package com.ai.bss.webapp.policy.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class CompositePolicy extends AbstractPolicyUnit {
	private Set<AtomicPolicy> children =new LinkedHashSet<>();
	public CompositePolicy() {
		
	}
	public Set<AtomicPolicy> getChildren() {
		return children;
	}
	
	public void addChild(AtomicPolicy child){
		if(!children.contains(child)){
			children.add(child);
		}
	}

}
