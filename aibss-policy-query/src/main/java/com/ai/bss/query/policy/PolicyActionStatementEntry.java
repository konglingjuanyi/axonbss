package com.ai.bss.query.policy;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PolicyActionStatementEntry extends PolicyStatementEntry {
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private PolicyActionOperatorEntry operator;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private PolicyAtomicActionEntry action;
	
	public PolicyActionStatementEntry(PolicyAtomicActionEntry action) {
		this.setAction(action);
		action.setStatement(this);
	}

	
	public PolicyOperatorEntry getOperator() {
		return this.operator;
	}

	
	public void setOperator(PolicyOperatorEntry operator) {
		this.operator=(PolicyActionOperatorEntry)operator;
	}


	public PolicyAtomicActionEntry getAction() {
		return action;
	}


	public void setAction(PolicyAtomicActionEntry action) {
		this.action = action;
	}

}
