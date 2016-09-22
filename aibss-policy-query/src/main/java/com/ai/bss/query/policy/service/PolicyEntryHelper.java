package com.ai.bss.query.policy.service;

import java.util.Set;

import com.ai.bss.api.policy.dto.AbstractAction;
import com.ai.bss.api.policy.dto.AbstractCondition;
import com.ai.bss.api.policy.dto.AbstractPan;
import com.ai.bss.api.policy.dto.AbstractPolicy;
import com.ai.bss.api.policy.dto.AbstractValue;
import com.ai.bss.api.policy.dto.AtomicAction;
import com.ai.bss.api.policy.dto.AtomicCondition;
import com.ai.bss.api.policy.dto.AtomicPolicy;
import com.ai.bss.api.policy.dto.CompositeAction;
import com.ai.bss.api.policy.dto.CompositeCondition;
import com.ai.bss.api.policy.dto.CompositePolicy;
import com.ai.bss.api.policy.dto.ConstValue;
import com.ai.bss.api.policy.dto.EnumValue;
import com.ai.bss.api.policy.dto.FunctionValue;
import com.ai.bss.api.policy.dto.Parameter;
import com.ai.bss.api.policy.dto.ValuePan;
import com.ai.bss.api.policy.dto.Variable;
import com.ai.bss.api.policy.dto.VariablePan;
import com.ai.bss.query.policy.PolicyActionEntry;
import com.ai.bss.query.policy.PolicyActionOperatorEntry;
import com.ai.bss.query.policy.PolicyActionStatementEntry;
import com.ai.bss.query.policy.PolicyAtomicActionEntry;
import com.ai.bss.query.policy.PolicyAtomicConditionEntry;
import com.ai.bss.query.policy.PolicyCompositeActionEntry;
import com.ai.bss.query.policy.PolicyCompositeConditionEntry;
import com.ai.bss.query.policy.PolicyCompositeConditionOptionEntry;
import com.ai.bss.query.policy.PolicyConditionEntry;
import com.ai.bss.query.policy.PolicyConditionOperatorEntry;
import com.ai.bss.query.policy.PolicyConditionStatementEntry;
import com.ai.bss.query.policy.PolicyConstValue;
import com.ai.bss.query.policy.PolicyEnumValue;
import com.ai.bss.query.policy.PolicyFunctionEntry;
import com.ai.bss.query.policy.PolicyFunctionParameterEntry;
import com.ai.bss.query.policy.PolicyFunctionValueEntry;
import com.ai.bss.query.policy.PolicyFunctionValueParamRelEntry;
import com.ai.bss.query.policy.PolicyGroupEntry;
import com.ai.bss.query.policy.PolicyOperatorNotEntry;
import com.ai.bss.query.policy.PolicyOperatorStringEqualsEntry;
import com.ai.bss.query.policy.PolicyRuleEntry;
import com.ai.bss.query.policy.PolicyRuleInputParameterEntry;
import com.ai.bss.query.policy.PolicySetEntry;
import com.ai.bss.query.policy.PolicySetOutputParameterEntry;
import com.ai.bss.query.policy.PolicyStatementEntry;
import com.ai.bss.query.policy.PolicyValuePanEntry;
import com.ai.bss.query.policy.PolicyVariableEntry;
import com.ai.bss.query.policy.PolicyVariablePanEntry;

public class PolicyEntryHelper {

	public PolicyEntryHelper() {
		
	}
	
	public static void createCompositePolicy(PolicyGroupEntry compositePolicyEntry, CompositePolicy compositePolicy){
		Set<AbstractPolicy> childPolicies = compositePolicy.getChildPolicies();
		if (childPolicies.size()>0){
			for (AbstractPolicy childPolicy : childPolicies) {
				if (childPolicy instanceof AtomicPolicy){
					PolicyRuleEntry childEntry =new PolicyRuleEntry();
					createAtomicPolicy(childEntry,(AtomicPolicy)childPolicy);
					compositePolicyEntry.addPolicySet(childEntry);
				}else{
					PolicyGroupEntry childEntry =new PolicyGroupEntry();
					//iterate
					createCompositePolicy(childEntry,(CompositePolicy)childPolicy);
					compositePolicyEntry.addPolicySet(childEntry);
				}
			}
		}
	}
	
	
	
	public static void createAtomicPolicy(PolicyRuleEntry policyEntry,AtomicPolicy policyDTO){
		policyEntry.setCondition(createPolicyCondtition(policyEntry,  policyDTO.getCondition()));
		policyEntry.setAction(createPolicyAction(policyEntry,  policyDTO.getAction()));
		if (null!=policyDTO.getElseAction()){
			policyEntry.setElseAction(createPolicyAction(policyEntry,  policyDTO.getElseAction()));
		}
		Set<Parameter> inputParameters = policyDTO.getInputParameteres();
		if (inputParameters.size()>0){
			for (Parameter parameter : inputParameters) {
				PolicyRuleInputParameterEntry param =new PolicyRuleInputParameterEntry();
				param.setType(parameter.getType());
				param.setName(parameter.getName());
				policyEntry.addInputParameter(param);
			}
		}
		Parameter outputParameter  = policyDTO.getOutputParameter();
		PolicySetOutputParameterEntry outputParam =new PolicySetOutputParameterEntry();
		outputParam.setType(outputParameter.getType());
		outputParam.setName(outputParameter.getName());
		policyEntry.setOutputParameter(outputParam);
	}
	
	public static PolicyConditionEntry createPolicyCondtition(PolicySetEntry policyEntry,AbstractCondition condition){
		if(condition instanceof CompositeCondition){
			return createCompositeCondition(policyEntry, (CompositeCondition)condition);
		}else{
			return createAtomicCondition(policyEntry, (AtomicCondition)condition);
		}		
	}
	
	public static PolicyActionEntry createPolicyAction(PolicySetEntry policyEntry,AbstractAction action){
		if(action instanceof CompositeAction){
			return PolicyEntryHelper.createCompositeAction(policyEntry, (CompositeAction)action);
		}else{
			return PolicyEntryHelper.createAtomicAction(policyEntry, (AtomicAction)action);
		}
	}
	
	public static PolicyCompositeConditionEntry createCompositeCondition(PolicySetEntry policyset,CompositeCondition condition){
		PolicyCompositeConditionEntry compositeConditionEntry = new PolicyCompositeConditionEntry(policyset);
		if(condition.isAnd()){
			compositeConditionEntry.setAnd();			
		}else{
			compositeConditionEntry.setOr();
		}
		Set<AbstractCondition> childConditions =condition.getChildConditions();
		for (AbstractCondition childCondition : childConditions) {
			PolicyCompositeConditionOptionEntry option=new PolicyCompositeConditionOptionEntry();
			option.setParentCondition(compositeConditionEntry);			
			compositeConditionEntry.addChild(option);
			if (childCondition instanceof AtomicCondition){
				PolicyAtomicConditionEntry childConditionEntry= createAtomicCondition(policyset,(AtomicCondition)childCondition);
				option.setChildCondition(childConditionEntry);
			}else{
				// iterate itself to create child Composite Condition
				PolicyCompositeConditionEntry childConditionEntry = createCompositeCondition(policyset,(CompositeCondition)childCondition);
				option.setChildCondition(childConditionEntry);				
			}						
		}
		return compositeConditionEntry;
	}
	
	public static PolicyCompositeActionEntry createCompositeAction(PolicySetEntry policyset,CompositeAction action){
		PolicyCompositeActionEntry compositeActionEntry = new PolicyCompositeActionEntry(policyset);
		Set<AbstractAction> childActions =action.getChildActions();
		for (AbstractAction childAction : childActions) {			
			if (childAction instanceof AtomicAction){
				PolicyAtomicActionEntry childActionEntry= createAtomicAction(policyset,(AtomicAction)childAction);
				compositeActionEntry.addChild(childActionEntry);
			}else{
				// iterate itself to create child Composite Condition
				PolicyCompositeActionEntry childActionEntry = createCompositeAction(policyset,(CompositeAction)childAction);
				compositeActionEntry.addChild(childActionEntry);
			}						
		}
		return compositeActionEntry;
	}
	
	public static PolicyAtomicConditionEntry createAtomicCondition(PolicySetEntry policyset,AtomicCondition condition){
		PolicyAtomicConditionEntry atomicConditionEntry =new PolicyAtomicConditionEntry(policyset);
		PolicyConditionStatementEntry statement = new PolicyConditionStatementEntry(atomicConditionEntry);
		createStatement(policyset,statement,condition.getLeft(), condition.getRight());	
		PolicyConditionOperatorEntry operatorEntry = new PolicyConditionOperatorEntry();
		operatorEntry.setCode(condition.getOperator());
		if (condition.getOperator().equalsIgnoreCase("equals")){
			operatorEntry=new PolicyOperatorStringEqualsEntry();
		}else if (condition.getOperator().equalsIgnoreCase("!")||condition.getOperator().equalsIgnoreCase("not")){
			operatorEntry=new PolicyOperatorNotEntry();
			//TODO function operator
		}
		statement.setOperator(operatorEntry);
		atomicConditionEntry.setStatement(statement);
		return atomicConditionEntry;
	}
	
	public static PolicyAtomicActionEntry createAtomicAction(PolicySetEntry policyset,AtomicAction action){
		PolicyAtomicActionEntry atomicActionEntry =new PolicyAtomicActionEntry(policyset);
		PolicyActionStatementEntry statement = new PolicyActionStatementEntry(atomicActionEntry);
		createStatement(policyset,statement,action.getLeft(), action.getRight());	
		PolicyActionOperatorEntry operatorEntry = new PolicyActionOperatorEntry();
		operatorEntry.setCode(action.getOperator());
		statement.setOperator(operatorEntry);
		atomicActionEntry.setStatement(statement);
		return atomicActionEntry;
	}
	
	private static void createStatement(PolicySetEntry policyset,PolicyStatementEntry statementEntry,
			AbstractPan left,
			AbstractPan right){
		if (left instanceof VariablePan){
			PolicyVariablePanEntry leftPan= createVariablePan(policyset,(VariablePan)left);						
			statementEntry.setLeftPan(leftPan);
		}else{
			//value
			PolicyValuePanEntry leftPan = createValuePan(policyset,(ValuePan)left);
			statementEntry.setLeftPan(leftPan);
		}
		if (right instanceof VariablePan){
			PolicyVariablePanEntry rightPan= createVariablePan(policyset,(VariablePan)right);						
			statementEntry.setRightPan(rightPan);
		}else{
			//value
			PolicyValuePanEntry rightPan = createValuePan(policyset,(ValuePan)right);
			statementEntry.setRightPan(rightPan);
		}
	}
	
	private static PolicyVariablePanEntry createVariablePan(PolicySetEntry policyset,VariablePan variablePan){
		Variable variable=variablePan.getVariable();
		PolicyVariableEntry variableEntry = new PolicyVariableEntry(policyset);
		//if (!variable.isGlobal()){
		variableEntry.setVariableType(variable.getType());
		variableEntry.setName(variable.getName());
		PolicyVariablePanEntry leftPan=new PolicyVariablePanEntry();
		leftPan.setPolicyVariable(variableEntry);
		return leftPan;
		//}
	}
	
	private static PolicyValuePanEntry createValuePan(PolicySetEntry policyset,ValuePan valuePan){
		PolicyValuePanEntry valuePanEntry =new PolicyValuePanEntry();
		AbstractValue value=valuePan.getValue();
		if (value instanceof ConstValue){
			PolicyConstValue valueEntry= new PolicyConstValue(policyset);
			valueEntry.setValue(((ConstValue) value).getValue());
			valuePanEntry.setPolicyValue(valueEntry);
		}else if (value instanceof EnumValue){
			PolicyEnumValue valueEntry= new PolicyEnumValue(policyset);
			valueEntry.setEnumValue(((EnumValue)value).getEnumValue());
			valuePanEntry.setPolicyValue(valueEntry);
		}else if (value instanceof FunctionValue){
			//TODO
			PolicyFunctionValueEntry valueEntry= new PolicyFunctionValueEntry(policyset);
			String functionId=((FunctionValue)value).getFunctionId();
			Set<Parameter> parameters=((FunctionValue)value).getParameterValues();
			PolicyFunctionEntry functionEntry = new PolicyFunctionEntry();
			functionEntry.setId(new Long(functionId));
			if (parameters.size()>0){
				for (Parameter parameter : parameters) {
					PolicyFunctionValueParamRelEntry valueParamRelEntry = new PolicyFunctionValueParamRelEntry();
					valueParamRelEntry.setFunctionValue(valueEntry);
					PolicyFunctionParameterEntry functionParameterEntry = new PolicyFunctionParameterEntry();
					functionParameterEntry.setId(new Long(parameter.getParameterId()));
					valueParamRelEntry.setParameter(functionParameterEntry);					
					AbstractPan parameterValuePan = parameter.getValue();
					if (parameterValuePan instanceof ValuePan){
						// iterate itself to create child ValuePan
						PolicyValuePanEntry paramValuePan =createValuePan(policyset,(ValuePan)parameterValuePan);
						valueParamRelEntry.setParamValuePan(paramValuePan);
					}else{
						PolicyVariablePanEntry paramVariablePan = createVariablePan(policyset,(VariablePan)parameterValuePan);
						valueParamRelEntry.setParamValuePan(paramVariablePan);
					}					
					valueEntry.addParam(valueParamRelEntry);
				}
			}
			valueEntry.setFunction(functionEntry);			
			valuePanEntry.setPolicyValue(valueEntry);
		}		
		return valuePanEntry;
	}
}
