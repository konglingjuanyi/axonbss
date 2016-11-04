package com.ai.bss.webapp.policy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.type.EnumType.EnumValueMapperSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.ai.bss.api.policy.dto.AbstractCondition;
import com.ai.bss.api.policy.dto.AbstractPan;
import com.ai.bss.api.policy.dto.AtomicCondition;
import com.ai.bss.api.policy.dto.AtomicPolicy;
import com.ai.bss.api.policy.dto.CompositePolicy;
import com.ai.bss.api.policy.dto.ConstValue;
import com.ai.bss.api.policy.dto.EnumValue;
import com.ai.bss.api.policy.dto.FunctionValue;
import com.ai.bss.api.policy.dto.ValuePan;
import com.ai.bss.api.policy.dto.Variable;
import com.ai.bss.api.policy.dto.VariablePan;

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
		policy.setName("test");
		policy.setCode("policy_test");
        model.addAttribute("policy", policy);
        return "policy/createAtomicPolicy";
    }
	
	@RequestMapping(value = "/createAtomicPolicy/addAtomicCondition")
    public String newAtomicContion(Model model) {
		AtomicCondition condition=new AtomicCondition();		
		condition.setName("test conditon");
		condition.setCode("condition_test");		
		model.addAttribute("condition", condition);
        return "policy/createAtomicCondition::newAtomicCondition";
    }
	
	@RequestMapping(value = "/createAtomicPolicy/addLeftVariable")
    public String addLeftVariable(Model model) {
		Variable leftVariable=new Variable();
		leftVariable.setType("String");
		model.addAttribute("leftVariable", leftVariable);
		model.addAttribute("onLeftPan",leftVariable);
        return "policy/createAtomicCondition::newLeftVariable";
    }
	
	@RequestMapping(value = "/createAtomicPolicy/addLeftConstValue")
    public String addLeftConstValue(Model model) {
		ConstValue leftValue=new ConstValue();
		model.addAttribute("leftConstValue", leftValue);
		model.addAttribute("onLeftPan",leftValue);
        return "policy/createAtomicCondition::newLeftConstValue";
    }
	
	@RequestMapping(value = "/createAtomicPolicy/addLeftEnumValue")
    public String addLeftEnumValue(Model model) {
		EnumValue leftValue=new EnumValue();
		model.addAttribute("leftEnumValue", leftValue);		
		model.addAttribute("onLeftPan",leftValue);
        return "policy/createAtomicCondition::newLeftEnumValue";
    }
	
	@RequestMapping(value = "/createAtomicPolicy/addLeftFunctionValue")
    public String addLeftFunctionValue(Model model) {
		FunctionValue leftValue=new FunctionValue();
		model.addAttribute("leftFunctionValue", leftValue);	
		model.addAttribute("onLeftPan",leftValue);
        return "policy/createAtomicCondition::newLeftFunctionValue";
    }
	
	
	
	@RequestMapping(value = "/createAtomicPolicy",method = RequestMethod.POST)
    public String saveAtomicPolicy(@ModelAttribute("policy") @Valid AtomicPolicy policy,
    		@ModelAttribute("condition") @Valid AtomicCondition condition,
    		@ModelAttribute("onLeftPan") @Valid Object onleftPan) {
		if (onleftPan instanceof Variable){
			VariablePan left=new VariablePan();
			left.setVariable((Variable)onleftPan);
			condition.setLeft(left);
		}
		
		policy.setCondition(condition);		
        return "policy/createAtomicPolicy";
    }
	
}
