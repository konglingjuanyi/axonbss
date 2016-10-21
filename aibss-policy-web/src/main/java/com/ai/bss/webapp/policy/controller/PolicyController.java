package com.ai.bss.webapp.policy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.ai.bss.api.policy.dto.AtomicCondition;
import com.ai.bss.api.policy.dto.AtomicPolicy;
import com.ai.bss.api.policy.dto.CompositePolicy;
import com.ai.bss.api.policy.dto.ValuePan;
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
	
	@RequestMapping(value = "/createAtomicPolicy",method = RequestMethod.POST)
    public String saveAtomicPolicy(final  AtomicPolicy policy) {
		String name=policy.getName();
        return "policy/createAtomicPolicy";
    }
	
	@RequestMapping(value = "/createAtomicPolicy",params={"addAtomicCondition"})
    public String newAtomicContion(final  AtomicPolicy policy,Model model) {
		AtomicCondition condition=new AtomicCondition(policy);
		condition.setName("test conditon");
		condition.setCode("condition_test");
		policy.setCondition(condition);
		model.addAttribute("condition", condition);
        return "policy/createAtomicCondition::newAtomicCondition";
    }
	
	@RequestMapping(value = "/createAtomicPolicy",params={"addVariableLeftPan"})
    public String addVariableLeftPan(final  AtomicPolicy policy) {
		VariablePan leftPan=new VariablePan();
		AtomicCondition condition=(AtomicCondition)policy.getCondition();
		condition.setLeft(leftPan);
        return "policy/createAtomicPolicy";
    }
	
	@RequestMapping(value = "/createAtomicPolicy",params={"addValueLeftPan"})
    public String addValueLeftPan(@ModelAttribute("policy") @Valid AtomicPolicy policy) {
		ValuePan leftPan=new ValuePan();
		AtomicCondition condition=(AtomicCondition)policy.getCondition();
		condition.setLeft(leftPan);
        return "policy/createAtomicPolicy";
    }
}
