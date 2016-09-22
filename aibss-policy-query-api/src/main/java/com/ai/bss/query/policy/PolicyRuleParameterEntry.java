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
	private String type;
	private String code;
	private String name;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="POLICY_RULE_ID")
	private PolicyRuleEntry policyRule;

	public PolicyRuleParameterEntry() {
	}
	
	public String getType() {
		return this.type;
	}

	
	public void setType(String type) {
		this.type=type;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
