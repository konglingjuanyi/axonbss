package com.ai.bss.webapp.policy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/policy")
public class PolicyController {	 
	@Autowired
	public RestTemplate client;
	
	@RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("policies", client.getForObject("http://policy-query-service/policy",Iterable.class));
        return "policy/list";
    }

}
