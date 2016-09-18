package com.ai.bss.query.policy;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class RegisteredCommandPolicyEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private RegisteredCommandEntry command;
	@OneToOne
	private PolicySetEntry policySet;
	public RegisteredCommandPolicyEntry() {
	}
	public RegisteredCommandEntry getCommand() {
		return command;
	}
	public void setCommand(RegisteredCommandEntry command) {
		this.command = command;
	}
	public PolicySetEntry getPolicySet() {
		return policySet;
	}
	public void setPolicySet(PolicySetEntry policySet) {
		this.policySet = policySet;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
