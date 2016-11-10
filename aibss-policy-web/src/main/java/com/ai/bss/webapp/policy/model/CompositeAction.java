package com.ai.bss.webapp.policy.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class CompositeAction extends BaseAction {
	private Set<AtomicAction> children =new LinkedHashSet<>();
	public CompositeAction() {
		super("Composite");
	}
	public Set<AtomicAction> getChildren() {
		return children;
	}
	
	public void addChild(AtomicAction child){
		if(!children.contains(child)){
			children.add(child);
		}
	}

}
