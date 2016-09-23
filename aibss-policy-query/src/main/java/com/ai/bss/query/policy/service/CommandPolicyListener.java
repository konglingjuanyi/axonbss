package com.ai.bss.query.policy.service;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.bss.api.policy.PolicyId;
import com.ai.bss.api.policy.event.PolicyRegisteredToCommandEvent;
import com.ai.bss.mutitanent.TenantContext;
import com.ai.bss.query.policy.PolicySetEntry;
import com.ai.bss.query.policy.RegisteredCommandEntry;
import com.ai.bss.query.policy.RegisteredCommandPolicyEntry;
import com.ai.bss.query.policy.repositories.CommandPolicyQueryRepository;
import com.ai.bss.query.policy.repositories.PolicyQueryRepository;

@Component
public class CommandPolicyListener {
	@Autowired
    private CommandPolicyQueryRepository commandPolicyQueryRepository;
	@Autowired
    private PolicyQueryRepository policyQueryRepository;
	public CommandPolicyListener() {
		
	}
	
	@EventHandler
	public void onPolicyRegisteredToCommandEvent(PolicyRegisteredToCommandEvent event){
		RegisteredCommandEntry entry = new RegisteredCommandEntry();
		entry.setCommandName(event.getCommandName());
		entry.setPropertyValue(event.getCommandPropertyValue());
		PolicyId policyId=event.getPolicyId();
		PolicySetEntry policyEntry = policyQueryRepository.findOne(policyId.toString());
		RegisteredCommandPolicyEntry commandPolicyRel= new RegisteredCommandPolicyEntry();
		commandPolicyRel.setCommand(entry);
		commandPolicyRel.setPolicySet(policyEntry);		
		entry.addPolicies(commandPolicyRel);
		TenantContext.setCurrentTenant(event.getTenantId());
		commandPolicyQueryRepository.save(entry);
	}
	
	

}
