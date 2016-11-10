package com.ai.bss.webapp.policy.model;

public class AtomicCondition extends BaseCondition {
	private Statement statement;	
	public AtomicCondition(){
		super("Atomic");
	}
	public Statement getStatement() {
		return statement;
	}
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
}
