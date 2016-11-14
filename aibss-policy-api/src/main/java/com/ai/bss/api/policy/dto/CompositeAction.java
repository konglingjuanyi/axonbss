package com.ai.bss.api.policy.dto;

import java.util.LinkedHashSet;
import java.util.Set;

public class CompositeAction extends AbstractAction {
	private boolean isAnd;
	private Set<AbstractAction> childActions = new LinkedHashSet<>();
	public CompositeAction() {
		// TODO Auto-generated constructor stub
	}
	public boolean isAnd() {
		return isAnd;
	}
	public void setAnd(boolean isAnd) {
		this.isAnd = isAnd;
	}
	public Set<AbstractAction> getChildActions() {
		return childActions;
	}
	public void addChildAction(AbstractAction action){
		if(!childActions.contains(action)){
			childActions.add(action);
		}
	}

}
