package com.ai.bss.aggregate.policy;

import org.axonframework.eventhandling.annotation.EventHandler;

import com.ai.bss.api.policy.PolicyId;
import com.ai.bss.api.policy.event.AtomicPolicyCreated;

public class AtomicPolicy extends AbstractPolicy {

	public AtomicPolicy(PolicyId policyId) {
		
	}

	public AtomicPolicy(PolicyId policyId,AtomicPolicy policy){
		super(policyId);
		AtomicPolicyCreated event = new AtomicPolicyCreated();
		event.setPolicyId(policyId);
		apply(event);
	}
	
	@EventHandler
	public void onAtomicPolicyCreated(AtomicPolicyCreated event){
		
	}
}
