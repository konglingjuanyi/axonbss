package com.ai.bss.webapp.policy.model;

public class AtomicPolicy extends AbstractPolicyUnit{
	private boolean isActomicCondition;
	private boolean isAtomicAction;
	private boolean isAtomicElseAction;
	private AtomicCondition atomicCondition;
	private CompositeCondition compositeCondition;
	private AtomicAction atomicAction;
	private CompositeAction compositeAction;
	private AtomicAction atomicElseAction;
	private CompositeAction compositeElseAction;
	public AtomicPolicy(){
	}
	public boolean getIsActomicCondition() {
		return isActomicCondition;
	}
	public void setIsActomicCondition(boolean isActomicCondition) {
		this.isActomicCondition = isActomicCondition;
	}
	public boolean getIsAtomicAction() {
		return isAtomicAction;
	}
	public void setIsAtomicAction(boolean isAtomicAction) {
		this.isAtomicAction = isAtomicAction;
	}
	public boolean getIsAtomicElseAction() {
		return isAtomicElseAction;
	}
	public void setIsAtomicElseAction(boolean isAtomicElseAction) {
		this.isAtomicElseAction = isAtomicElseAction;
	}
	public AtomicCondition getAtomicCondition() {
		return atomicCondition;
	}
	public void setAtomicCondition(AtomicCondition atomicCondition) {
		this.isActomicCondition=true;
		this.atomicCondition = atomicCondition;
	}
	public CompositeCondition getCompositeCondition() {
		return compositeCondition;
	}
	public void setCompositeCondition(CompositeCondition compositeCondition) {
		this.isActomicCondition=false;
		this.compositeCondition = compositeCondition;
	}
	public AtomicAction getAtomicAction() {
		return atomicAction;
	}
	public void setAtomicAction(AtomicAction atomicAction) {
		this.isAtomicAction=true;
		this.atomicAction = atomicAction;
	}
	public CompositeAction getCompositeAction() {
		return compositeAction;
	}
	public void setCompositeAction(CompositeAction compositeAction) {
		this.isAtomicAction=false;
		this.compositeAction = compositeAction;
	}
	public AtomicAction getAtomicElseAction() {
		return atomicElseAction;
	}
	public void setAtomicElseAction(AtomicAction atomicElseAction) {
		this.isAtomicElseAction=true;
		this.atomicElseAction = atomicElseAction;
	}
	public CompositeAction getCompositeElseAction() {
		return compositeElseAction;
	}
	public void setCompositeElseAction(CompositeAction compositeElseAction) {
		this.isAtomicElseAction=false;
		this.compositeElseAction = compositeElseAction;
	}

}
