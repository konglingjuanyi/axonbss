package com.ai.bss.webapp.policy.model;

public class AtomicAction extends BaseAction {
	private Statement statement;	
	public AtomicAction(){
		super("Atomic");
	}
	public Statement getStatement() {
		return statement;
	}
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
}
