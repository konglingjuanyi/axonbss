package com.ai.bss.query.policy;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Embeddable
public class PolicyPanEntry {
	@Column(name="PAN_TYPE")
	private String panType;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="VARIABLE_ID")
	private PolicyVariableEntry panVariable;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="VALUE_ID")
	private PolicyValueEntry panValue;
		
	public PolicyPanEntry() {
		
	}
	

	public PolicyVariableEntry getPolicyVariable() {
		return panVariable;
	}

	public void setPolicyVariable(PolicyVariableEntry variable) {
		this.setPanType("VARIABLE");
		this.panVariable = variable;
	}
	
	public String toBodyString(){
		String str=null;
		if(null!=this.getPolicyVariable()){
			str=this.getPolicyVariable().toBodyString();
		}else{
			str=this.getPolicyValue().toBodyString();
		}
		return str;
	}
		
	public Set<PolicyVariableEntry> getVariables(){
		Set<PolicyVariableEntry> variables=new LinkedHashSet<PolicyVariableEntry>();
		if(null!=this.getPolicyVariable()){
			variables.add(this.getPolicyVariable());
		}else{
			if (null!=this.getPolicyValue().getVariables()){
				variables.addAll(this.getPolicyValue().getVariables());
			}	
		}
		return variables;
	}	

	public PolicyValueEntry getPolicyValue() {
		return panValue;
	}

	public void setPolicyValue(PolicyValueEntry value) {
		this.setPanType("VALUE");
		this.panValue = value;
	}

	public String getPanType() {
		return panType;
	}

	public void setPanType(String panType) {
		this.panType = panType;
	}
}
