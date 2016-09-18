package com.ai.bss.query.policy;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="PL_RULE_PARAMETER")
public class PolicyRuleParameterEntry{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private PolicyVariableEntry variable;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="POLICY_RULE_ID")
	private PolicyRuleEntry policyRule;

	public PolicyRuleParameterEntry() {
	}
	
	public PolicyVariableEntry getVariable() {
		return this.variable;
	}

	
	public void setVariable(PolicyVariableEntry variable) {
		this.variable=variable;
	}

	
	public PolicyRuleEntry getPolicyRule() {
		return this.policyRule;
	}
	
	public void setPolicyRule(PolicyRuleEntry policyRule) {
		this.policyRule=policyRule;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
