package com.ai.bss.query.policy;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class RegisteredCommandEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String commandName;
	private String propertyValue;
	@OneToMany(mappedBy="command",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<RegisteredCommandPolicyEntry> policies=new LinkedHashSet<RegisteredCommandPolicyEntry>();
	public RegisteredCommandEntry() {
	}
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	public Set<RegisteredCommandPolicyEntry> getPolicies() {
		return policies;
	}
	public void addPolicies(RegisteredCommandPolicyEntry policy) {
		if (!policies.contains(policy)){
			policies.add(policy);
		}
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

}
