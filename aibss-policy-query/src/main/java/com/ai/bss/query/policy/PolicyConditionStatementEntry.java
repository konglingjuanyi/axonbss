package com.ai.bss.query.policy;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PolicyConditionStatementEntry extends PolicyStatementEntry{
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private PolicyConditionOperatorEntry operator;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private PolicyAtomicConditionEntry condition;
	
	
	public PolicyConditionStatementEntry(PolicyAtomicConditionEntry condition) {
		this.setCondition(condition);
		condition.setStatement(this);
	}

	
	public PolicyOperatorEntry getOperator() {
		return this.operator;
	}

	
	public void setOperator(PolicyOperatorEntry operator) {
		this.operator=(PolicyConditionOperatorEntry)operator;
	}


	public PolicyAtomicConditionEntry getCondition() {
		return condition;
	}


	public void setCondition(PolicyAtomicConditionEntry condition) {
		this.condition = condition;
	}

}
