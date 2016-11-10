package com.ai.bss.webapp.policy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.ai.bss.webapp.policy.model.AtomicAction;
import com.ai.bss.webapp.policy.model.AtomicCondition;
import com.ai.bss.webapp.policy.model.AtomicPolicy;
import com.ai.bss.webapp.policy.model.CompositePolicy;
import com.ai.bss.webapp.policy.model.ConstValue;
import com.ai.bss.webapp.policy.model.EnumValue;
import com.ai.bss.webapp.policy.model.FunctionValue;
import com.ai.bss.webapp.policy.model.Statement;
import com.ai.bss.webapp.policy.model.Variable;

@Controller
@RequestMapping("/policy")
public class PolicyController {	 
	@Autowired
	public RestTemplate client;
	
	@RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("policies", client.getForObject("http://policy-query-service/policy",Iterable.class));
        return "policy/policyList";
    }
	
	
	@RequestMapping(value = "/createCompositePolicy",method = RequestMethod.GET)
    public String createCompositePolicy(Model model) {
		CompositePolicy policy=new CompositePolicy();
        model.addAttribute("CompositePolicy", policy);
        return "policy/createCompositePolicy";
    }
	
	@RequestMapping(value = "/createAtomicPolicy",method = RequestMethod.GET)
    public String createAtomicPolicy(Model model) {
		AtomicPolicy policy=new AtomicPolicy();
        model.addAttribute("policy", policy);
        return "policy/createAtomicPolicy";
    }
	
	//-------------Condition-------------------------//
	
	@RequestMapping(value = "/createAtomicPolicy/addAtomicCondition")
    public String newAtomicContion(@RequestBody @Valid AtomicPolicy policy,Model model) {
		AtomicCondition condition=new AtomicCondition();		
		condition.setName("test conditon");
		condition.setCode("condition_test");
		policy.setAtomicCondition(condition);
		model.addAttribute("policy", policy);
        return "policy/createAtomicCondition::newAtomicCondition";
    }
	
	////left
	@RequestMapping(value = "/createAtomicPolicy/addConditionLeftVariable")
    public String addConditionLeftVariable(@RequestBody @Valid AtomicPolicy policy,Model model) {
		AtomicCondition condition=policy.getAtomicCondition();
		Statement statement= condition.getStatement();
		if (null==statement){
			statement=new Statement();
		}
		Variable leftVariable=new Variable();
		statement.setLeftType("Variable");
		statement.setLeftVariable(leftVariable);
		model.addAttribute("policy", policy);
        return "policy/createAtomicCondition::newConditionLeftVariable";
    }
	
	@RequestMapping(value = "/createAtomicPolicy/addConditionLeftConstValue")
    public String addConditionLeftConstValue(@RequestBody @Valid AtomicPolicy policy,Model model) {
		AtomicCondition condition=policy.getAtomicCondition();
		Statement statement= condition.getStatement();
		if (null==statement){
			statement=new Statement();
		}
		ConstValue leftValue=new ConstValue();
		statement.setLeftType("ConstValue");
		statement.setLeftConstValue(leftValue);
		model.addAttribute("policy", policy);
        return "policy/createAtomicCondition::newConditionLeftConstValue";
    }
	
	@RequestMapping(value = "/createAtomicPolicy/addConditionLeftEnumValue")
    public String addConditionLeftEnumValue(@RequestBody @Valid AtomicPolicy policy,Model model) {
		AtomicCondition condition=policy.getAtomicCondition();
		Statement statement= condition.getStatement();
		if (null==statement){
			statement=new Statement();
		}
		EnumValue leftValue=new EnumValue();
		statement.setLeftType("EnumValue");
		statement.setLeftEnumValue(leftValue);
		model.addAttribute("policy", policy);
        return "policy/createAtomicCondition::newConditionLeftEnumValue";
    }
	
	@RequestMapping(value = "/createAtomicPolicy/addConditionLeftFunctionValue")
    public String addConditionLeftFunctionValue(@RequestBody @Valid AtomicPolicy policy,Model model) {
		AtomicCondition condition=policy.getAtomicCondition();
		Statement statement= condition.getStatement();
		if (null==statement){
			statement=new Statement();
		}
		FunctionValue leftValue=new FunctionValue();
		statement.setLeftType("FunctionValue");
		statement.setLeftFunctionValue(leftValue);
		model.addAttribute("policy", policy);
        return "policy/createAtomicCondition::newConditionLeftFunctionValue";
    }
	
	////right
	@RequestMapping(value = "/createAtomicPolicy/addConditionRightVariable")
    public String addConditionRightVariable(@RequestBody @Valid AtomicPolicy policy,Model model) {
		AtomicCondition condition=policy.getAtomicCondition();
		Statement statement= condition.getStatement();
		if (null==statement){
			statement=new Statement();
		}
		Variable rightVariable=new Variable();
		statement.setRightType("Variable");
		statement.setRightVariable(rightVariable);
		model.addAttribute("policy", policy);
        return "policy/createAtomicCondition::newConditionRightVariable";
    }
	
	@RequestMapping(value = "/createAtomicPolicy/addConditionRightConstValue")
    public String addConditionRightConstValue(@RequestBody @Valid AtomicPolicy policy,Model model) {
		AtomicCondition condition=policy.getAtomicCondition();
		Statement statement= condition.getStatement();
		if (null==statement){
			statement=new Statement();
		}
		ConstValue rightValue=new ConstValue();
		statement.setRightType("ConstValue");
		statement.setRightConstValue(rightValue);
		model.addAttribute("policy", policy);
        return "policy/createAtomicCondition::newConditionRightConstValue";
    }
	
	@RequestMapping(value = "/createAtomicPolicy/addConditionRightEnumValue")
    public String addConditionRightEnumValue(@RequestBody @Valid AtomicPolicy policy,Model model) {
		AtomicCondition condition=policy.getAtomicCondition();
		Statement statement= condition.getStatement();
		if (null==statement){
			statement=new Statement();
		}
		EnumValue rightValue=new EnumValue();
		statement.setRightType("EnumValue");
		statement.setRightEnumValue(rightValue);
		model.addAttribute("policy", policy);
        return "policy/createAtomicCondition::newConditionRightEnumValue";
    }
	
	@RequestMapping(value = "/createAtomicPolicy/addConditionRightFunctionValue")
    public String addConditionRightFunctionValue(@RequestBody @Valid AtomicPolicy policy,Model model) {
		AtomicCondition condition=policy.getAtomicCondition();
		Statement statement= condition.getStatement();
		if (null==statement){
			statement=new Statement();
		}
		FunctionValue rightValue=new FunctionValue();
		statement.setRightType("FunctionValue");
		statement.setRightFunctionValue(rightValue);
		model.addAttribute("policy", policy);
        return "policy/createAtomicCondition::newConditionRightFunctionValue";
    }
	
	//------------Action-------------------------//
	
	@RequestMapping(value = "/createAtomicPolicy/addAtomicAction")
    public String newAtomicAction(@RequestBody @Valid AtomicPolicy policy,Model model) {
		AtomicAction action=new AtomicAction();		
		action.setName("test action");
		action.setCode("action_test");
		policy.setAtomicAction(action);
		model.addAttribute("policy", policy);
        return "policy/createAtomicAction::newAtomicAction";
    }
	
	////left
	@RequestMapping(value = "/createAtomicPolicy/addActionLeftVariable")
    public String addActionLeftVariable(@RequestBody @Valid AtomicPolicy policy,Model model) {
		AtomicAction action=policy.getAtomicAction();
		Statement statement= action.getStatement();
		if (null==statement){
			statement=new Statement();
		}
		Variable leftVariable=new Variable();
		statement.setLeftType("Variable");
		statement.setLeftVariable(leftVariable);
		model.addAttribute("policy", policy);
        return "policy/createAtomicAction::newActionLeftVariable";
    }
	
	@RequestMapping(value = "/createAtomicPolicy/addActionLeftConstValue")
    public String addActionLeftConstValue(@RequestBody @Valid AtomicPolicy policy,Model model) {
		AtomicAction action=policy.getAtomicAction();
		Statement statement= action.getStatement();
		if (null==statement){
			statement=new Statement();
		}
		ConstValue leftValue=new ConstValue();
		statement.setLeftType("ConstValue");
		statement.setLeftConstValue(leftValue);
		model.addAttribute("policy", policy);
        return "policy/createAtomicAction::newActionLeftConstValue";
    }
	
	@RequestMapping(value = "/createAtomicPolicy/addActionLeftEnumValue")
    public String addActionLeftEnumValue(@RequestBody @Valid AtomicPolicy policy,Model model) {
		AtomicAction action=policy.getAtomicAction();
		Statement statement= action.getStatement();
		if (null==statement){
			statement=new Statement();
		}
		EnumValue leftValue=new EnumValue();
		statement.setLeftType("EnumValue");
		statement.setLeftEnumValue(leftValue);
		model.addAttribute("policy", policy);
        return "policy/createAtomicAction::newActionLeftEnumValue";
    }
	
	@RequestMapping(value = "/createAtomicPolicy/addActionLeftFunctionValue")
    public String addActionLeftFunctionValue(@RequestBody @Valid AtomicPolicy policy,Model model) {
		AtomicAction action=policy.getAtomicAction();
		Statement statement= action.getStatement();
		if (null==statement){
			statement=new Statement();
		}
		FunctionValue leftValue=new FunctionValue();
		statement.setLeftType("FunctionValue");
		statement.setLeftFunctionValue(leftValue);
		model.addAttribute("policy", policy);
        return "policy/createAtomicAction::newActionLeftFunctionValue";
    }
	
	////right
	@RequestMapping(value = "/createAtomicPolicy/addActionRightVariable")
    public String addActionRightVariable(@RequestBody @Valid AtomicPolicy policy,Model model) {
		AtomicAction action=policy.getAtomicAction();
		Statement statement= action.getStatement();
		if (null==statement){
			statement=new Statement();
		}
		Variable rightVariable=new Variable();
		statement.setRightType("Variable");
		statement.setRightVariable(rightVariable);
		model.addAttribute("policy", policy);
        return "policy/createAtomicAction::newActionRightVariable";
    }
	
	@RequestMapping(value = "/createAtomicPolicy/addActionRightConstValue")
    public String addActionRightConstValue(@RequestBody @Valid AtomicPolicy policy,Model model) {
		AtomicAction action=policy.getAtomicAction();
		Statement statement= action.getStatement();
		if (null==statement){
			statement=new Statement();
		}
		ConstValue rightValue=new ConstValue();
		statement.setRightType("ConstValue");
		statement.setRightConstValue(rightValue);
		model.addAttribute("policy", policy);
        return "policy/createAtomicAction::newActionRightConstValue";
    }
	
	@RequestMapping(value = "/createAtomicPolicy/addActionRightEnumValue")
    public String addActionRightEnumValue(@RequestBody @Valid AtomicPolicy policy,Model model) {
		AtomicAction action=policy.getAtomicAction();
		Statement statement= action.getStatement();
		if (null==statement){
			statement=new Statement();
		}
		EnumValue rightValue=new EnumValue();
		statement.setRightType("EnumValue");
		statement.setRightEnumValue(rightValue);
		model.addAttribute("policy", policy);
        return "policy/createAtomicAction::newActionRightEnumValue";
    }
	
	@RequestMapping(value = "/createAtomicPolicy/addActionRightFunctionValue")
    public String addActionRightFunctionValue(@RequestBody @Valid AtomicPolicy policy,Model model) {
		AtomicAction action=policy.getAtomicAction();
		Statement statement= action.getStatement();
		if (null==statement){
			statement=new Statement();
		}
		FunctionValue rightValue=new FunctionValue();
		statement.setRightType("FunctionValue");
		statement.setRightFunctionValue(rightValue);
		model.addAttribute("policy", policy);
        return "policy/createAtomicAction::newActionRightFunctionValue";
    }
	
	@RequestMapping(value = "/createAtomicPolicy",method = RequestMethod.POST)
    public String saveAtomicPolicy(@ModelAttribute("policy") @Valid AtomicPolicy policy) {
			
        return "policy/createAtomicPolicy";
    }
	
}
