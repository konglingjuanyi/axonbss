package com.ai.bss.query.policy;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
@Entity
public class PolicyGroupEntry extends PolicySetEntry{
	@OneToMany(mappedBy="parentPolicySet",fetch=FetchType.LAZY)
	private Set<PolicySetEntry> policySets=new LinkedHashSet<PolicySetEntry>();
	
	public PolicyGroupEntry() {
	}

	
	public Set<PolicySetEntry> getPolicySets() {
		return this.policySets;
	}

	
	public void addPolicySet(PolicySetEntry policySet) {
		if (null!=policySet){
			policySets.add(policySet);
		}
	}

	
	public String toBodyString() {
		StringBuffer bf=new StringBuffer();
		Set<PolicySetEntry> childrens=this.getPolicySets();
		if (childrens.size()>0) {			
			for (PolicySetEntry PolicySet : childrens) {
				if(null!=this.getElseAction()||this.isEnableElseAction==false){
					PolicySet.disableElseAction();
				}
				bf.append(PolicySet.toBodyString());
			}			
		}
		return bf.toString();
	}	
	
	public Map<String,PolicyVariableEntry> getVariableMap(){
		Map<String , PolicyVariableEntry>  map=new HashMap<String, PolicyVariableEntry>();
		Set<PolicySetEntry> children=this.getPolicySets();
		for (PolicySetEntry PolicySet : children) {
			map.putAll(PolicySet.getVariableMap());
		}	
		return map;
	}


	@Override
	public boolean isComposite() {
		return true;
	}

}
