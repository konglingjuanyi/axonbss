package com.ai.bss.aggregate.policy;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;

import com.ai.bss.api.policy.PolicyId;

public abstract class AbstractPolicy extends AbstractAnnotatedAggregateRoot{
	private PolicyId policyId;
	
	public AbstractPolicy(){
		
	}
	
	public AbstractPolicy(PolicyId policyId){
		this.policyId=policyId;
	}
		

	public PolicyId getPolicyId() {
		return policyId;
	}

	public void setPolicyId(PolicyId policyId) {
		this.policyId = policyId;
	}
	
	
}
