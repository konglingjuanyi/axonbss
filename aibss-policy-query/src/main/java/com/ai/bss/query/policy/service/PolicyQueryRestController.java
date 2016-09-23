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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ai.bss.query.policy.PolicySetEntry;
import com.ai.bss.query.policy.RegisteredCommandEntry;
import com.ai.bss.query.policy.repositories.CommandPolicyQueryRepository;
import com.ai.bss.query.policy.repositories.PolicyQueryRepository;

/**
 * @author Lianhua Zhang
 */
@RestController
@RequestMapping("/poliocy")

public class PolicyQueryRestController{
	@Autowired
    private CommandPolicyQueryRepository commandPolicyQueryRepository;
	
	@Autowired
    private PolicyQueryRepository policyQueryRepository;
	
	@RequestMapping(value = "/{policyId}", method = RequestMethod.GET)
    public PolicySetEntry findByPolicyId(@PathVariable String policyId) {
    	return policyQueryRepository.findOne(policyId);
    }
	
	
	@RequestMapping(value = "/{commandName}", method = RequestMethod.GET)
    public List<RegisteredCommandEntry> findByCommand(@PathVariable String commandName) {
    	return commandPolicyQueryRepository.findByCommandName(commandName);
    }
	
    @RequestMapping(value = "/{commandName}/{propertValue}", method = RequestMethod.GET)
    public List<RegisteredCommandEntry> findByCommand(@PathVariable String commandName,@PathVariable String propertyValue) {
    	return commandPolicyQueryRepository.findByCommandNameAndPropertyValue(commandName,propertyValue);
    }
    
}
