package com.ai.bss.query.policy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.bss.query.policy.repositories.CommandPolicyQueryRepository;

@Component
public class CommandPolicyListener {
	@Autowired
    private CommandPolicyQueryRepository commandPolicyQueryRepository;
	public CommandPolicyListener() {
		
	}
	
	

}
