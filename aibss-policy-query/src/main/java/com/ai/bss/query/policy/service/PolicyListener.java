/*
 * Copyright (c) 2010-2012. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ai.bss.query.policy.service;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.bss.api.policy.dto.AbstractPolicy;
import com.ai.bss.api.policy.dto.AtomicPolicy;
import com.ai.bss.api.policy.dto.CompositePolicy;
import com.ai.bss.api.policy.event.PolicyCreatedEvent;
import com.ai.bss.mutitanent.TenantContext;
import com.ai.bss.query.policy.PolicyGroupEntry;
import com.ai.bss.query.policy.PolicyRuleEntry;
import com.ai.bss.query.policy.repositories.PolicyQueryRepository;

@Component
public class PolicyListener {
	@Autowired
    private PolicyQueryRepository PolicyQueryRepository;

	@EventHandler
	public void onPolicyCreated(PolicyCreatedEvent event){
		TenantContext.setCurrentTenant(event.getTenantId());
		AbstractPolicy policyDTO=event.getPolicy();
		if (policyDTO instanceof AtomicPolicy){
			PolicyRuleEntry policyEntry = new PolicyRuleEntry();
			policyEntry.setId(event.getPolicyId().toString());
			PolicyEntryHelper.createAtomicPolicy(policyEntry, (AtomicPolicy)policyDTO);
			PolicyQueryRepository.save(policyEntry);
		}else{
			PolicyGroupEntry compositePolicyEntry=new PolicyGroupEntry();
			compositePolicyEntry.setId(event.getPolicyId().toString());
			PolicyEntryHelper.createCompositePolicy(compositePolicyEntry, (CompositePolicy)policyDTO);
			PolicyQueryRepository.save(compositePolicyEntry);
		}		        
	}       
}
