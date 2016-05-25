package com.ai.bss.query.policy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class PolicyRuleEntry extends PolicySetEntry{
	@OneToOne(cascade=CascadeType.ALL)
	private PolicyConditionEntry condition;
	@OneToOne(cascade=CascadeType.ALL)
	private PolicyActionEntry action;
	@OneToMany(mappedBy="policyRule",fetch=FetchType.LAZY,cascade=CascadeType.ALL,targetEntity=PolicyRuleParameterEntry.class)
	private Set<PolicyRuleInputParameterEntry> inputParameters=new LinkedHashSet<PolicyRuleInputParameterEntry>();

	public PolicyRuleEntry() {
	}

	
	public PolicyConditionEntry getCondition() {
		return this.condition;
	}

	
	public void setCondition(PolicyConditionEntry condition) {
		this.condition=condition;
	}

	
	public PolicyActionEntry getAction() {
		return this.action;
	}

	
	public void setAction(PolicyActionEntry action) {
		this.action=action;
	}

	
	public String toBodyString() {
		StringBuffer bf=new StringBuffer();
		bf.append("        ").append("if (").append(this.getCondition().toBodyString()).append("){\n")
		.append(this.getAction().toBodyString())
		.append("            ").append("if (matched==false) {\n")
		.append("            ").append("   ").append("matched=true;\n")
		.append("            ").append("}\n")
		.append("        }\n");	
		return bf.toString();
	}
	
	
	public void addInputParameter(PolicyRuleInputParameterEntry param) {
		if(null!=param){
			inputParameters.add(param);
		}
	}	


	
	public Set<PolicyRuleInputParameterEntry> getInputParameters() {
		return this.inputParameters;
	}
	
	
	public Map<String,PolicyVariableEntry> getVariableMap(){
		Set<PolicyVariableEntry> variables=new HashSet<PolicyVariableEntry>();
		PolicyConditionEntry condition=this.getCondition();
		if (null!=condition){
			variables.addAll(condition.getVariables());
		}
		PolicyActionEntry action=this.getAction();
		if(null!=action){
			if (action.getVariables().size()>0){
				variables.addAll(action.getVariables());
			}
		}
		PolicyActionEntry elseAction=this.getElseAction();
		if(null!=elseAction){
			if (elseAction.getVariables().size()>0){
				variables.addAll(elseAction.getVariables());
			}			
		}
		Map<String , PolicyVariableEntry>  map=new HashMap<String, PolicyVariableEntry>();
		for (PolicyVariableEntry PolicyVariable : variables) {
			if(null!=PolicyVariable){
				String code=PolicyVariable.getCode();
				if (!code.isEmpty()&&!map.containsKey(code)){
					map.put(code, PolicyVariable);
				}	
			}
		}
		for (PolicyRuleInputParameterEntry param : this.getInputParameters()) {
			String varCode=param.getVariable().getCode();
			if (map.containsKey(varCode)){
				map.remove(varCode);
			}
		}
		return map;
	}

}
