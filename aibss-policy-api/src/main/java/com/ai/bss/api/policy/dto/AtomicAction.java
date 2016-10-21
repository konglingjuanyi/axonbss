package com.ai.bss.api.policy.dto;

public class AtomicAction extends AbstractAction{
	private AbstractPan left;
	private String operator;
	private AbstractPan right;
	public AtomicAction() {
		// TODO Auto-generated constructor stub
	}
	public AbstractPan getLeft() {
		return left;
	}
	public void setLeft(AbstractPan left) {
		this.left = left;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public AbstractPan getRight() {
		return right;
	}
	public void setRight(AbstractPan right) {
		this.right = right;
	}
	@Override
	public boolean isComposite() {
		return false;
	}

}
