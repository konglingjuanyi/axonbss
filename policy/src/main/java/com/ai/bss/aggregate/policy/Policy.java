package com.ai.bss.aggregate.policy;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;

import com.ai.bss.api.policy.PolicyId;
import com.ai.bss.api.policy.dto.AbstractPolicy;
import com.ai.bss.api.policy.event.PolicyCreatedEvent;
import com.ai.bss.api.policy.event.PolicyRegisteredToCommandEvent;

public class Policy extends AbstractAnnotatedAggregateRoot{
	private PolicyId policyId;
	
	public Policy(){
		
	}
	
	public Policy(PolicyId policyId,AbstractPolicy policyDTO){
		PolicyCreatedEvent event= new PolicyCreatedEvent();
		event.setPolicyId(policyId);
		event.setPolicy(policyDTO);
		apply(event);
	}
	
	@EventHandler
	public void creatPolicy(PolicyCreatedEvent event){
		this.policyId=event.getPolicyId();
	}
	
	public void registerToCommand(String commandName, String commandPropertyValue){
		PolicyRegisteredToCommandEvent event = new PolicyRegisteredToCommandEvent();
		event.setCommandName(commandName);
		event.setCommandPropertyValue(commandPropertyValue);
		event.setPolicyId(policyId);
		apply(event);
	}
	
	public Policy(PolicyId policyId){
		this.policyId=policyId;
	}
		

	public PolicyId getPolicyId() {
		return policyId;
	}

	public void setPolicyId(PolicyId policyId) {
		this.policyId = policyId;
	}
	
	
}
