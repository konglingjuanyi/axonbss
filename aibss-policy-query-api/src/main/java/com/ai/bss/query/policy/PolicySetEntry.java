package com.ai.bss.query.policy;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="PL_POLICY_SET")
public abstract class PolicySetEntry{
	@Id
	private String id;	
	private String name;
	private String code;
	@OneToOne
	private PolicySetOutputParameterEntry outputParam;	
	@OneToOne(cascade=CascadeType.ALL)
	private PolicyActionEntry elseAction;
	boolean isEnableElseAction=true;
		
	@OneToMany(mappedBy="policyRule",fetch=FetchType.LAZY,targetEntity=PolicyRuleParameterEntry.class)
	private Set<PolicyRuleInputParameterEntry> inputParameters=new LinkedHashSet<PolicyRuleInputParameterEntry>();

	
	@ManyToOne
	private PolicySetEntry parentPolicySet;
	
	public PolicySetEntry() {
	}

	
	public String getName() {
		return this.name;
	}

	
	public void setName(String name) {
		this.name=name;
	}

	
	public String getCode() {
		return this.code;
	}

	
	public void setCode(String code) {
		this.code=code;
	}

	protected void addInputParameter(PolicyRuleInputParameterEntry param) {
		if(null!=param){
			inputParameters.add(param);
		}
	}
	
	public Set<PolicyRuleInputParameterEntry> getInputParameters() {
		return this.inputParameters;
	}	

	
	public PolicySetOutputParameterEntry getOutputParameter() {
		return this.outputParam;
	}

	
	public void setOutputParameter(PolicySetOutputParameterEntry param) {
		this.outputParam=param;
	}	
	
	
	public PolicyActionEntry getElseAction() {
		return this.elseAction;
	}	

	
	public void setElseAction(PolicyActionEntry elseAction) {
		this.elseAction=elseAction;		
	}
	
	
	public void disableElseAction(){
		this.isEnableElseAction=false;
	}
	
	
	public abstract String toBodyString();
	
	
	public String getVariableDeclareString() {
		StringBuffer sb=new StringBuffer();
		Map<String , PolicyVariableEntry> map=this.getVariableMap();
		for(Entry<String, PolicyVariableEntry> entry : map.entrySet()){
			String code = entry.getKey();
			PolicyVariableEntry variable = entry.getValue();
			sb.append("        ").append(variable.getVariableType()).append(" ").append(code);
			if(null!=variable.getValue()){
				sb.append(" = ").append(variable.getValue().toBodyString());
			}
			sb.append(";\n");
		}
		return sb.toString();
	}
	
	
	public abstract Map<String,PolicyVariableEntry> getVariableMap();
	
	
	public String toPolicyString() {
		String returnVar="";
		String returnVarType="";
		if(null!=this.getOutputParameter()){
			returnVar=this.getOutputParameter().getCode();
			returnVarType=(String)this.getOutputParameter().getType();
		}
		StringBuffer classBody=new StringBuffer();
		String className="aPolicy"+this.getCode();
		StringBuffer classHead= new StringBuffer();
		StringBuffer constructor= new StringBuffer();
		StringBuffer methodDeclare= new StringBuffer();
		String classEnd="}\n";
		String methodEnd="    }\n";
		classHead.append("package com.ai.policy;\n")
		.append("import java.util.Map;\n")
		.append("public class ")
		.append(className)
		.append("{\n");
		constructor.append("    public ").append(className).append("(){\n    }\n");
		methodDeclare.append("        ").append("boolean matched=false;\n");
		for (PolicyRuleInputParameterEntry param : this.getInputParameters()) {
			methodDeclare.append("        ")
			.append(param.getType()).append(" ")
			.append(param.getCode())			
			.append(" = ")
			.append("(").append(param.getType()).append(")")
			.append("context.get(\"").append(param.getCode()).append("\")")
			.append(";\n");
		}
		StringBuffer method= new StringBuffer();
		method.append("    public ");
		if(null!=this.getOutputParameter()){
			method.append(returnVarType);
		}else{
			method.append("void");
		}
		
		method.append(" ").append("executePolicy(").append("Map<String, Object> context").append(") throws Exception {\n")		
		.append(methodDeclare.toString())
		.append(this.getVariableDeclareString())
		.append(this.toBodyString());
		if (null!=this.getElseAction()&&this.isEnableElseAction){
			method.append("        ").append("if (matched==false) {\n")
			.append("        ").append("    ").append(this.getElseAction().toBodyString())
			.append("        ").append("}\n");
		}
		if(null!=this.getOutputParameter()){
			method.append("        ").append("return ").append(returnVar).append(";\n");
		}		
		method.append(methodEnd);
		classBody.append(classHead.toString())
		.append(constructor.toString())
		.append(method.toString())
		.append(classEnd);
		
		return classBody.toString();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public PolicySetEntry getParentPolicySet() {
		return parentPolicySet;
	}


	public void setParentPolicySet(PolicySetEntry parentPolicySet) {
		this.parentPolicySet = parentPolicySet;
	}

}
