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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.bss.api.base.CharacteristicValue;
import com.ai.bss.api.base.TimePeriod;
import com.ai.bss.mutitanent.TenantContext;
import com.ai.bss.query.policy.repositories.CommandPolicyQueryRepository;

@Component
public class PolicyListener {
	@Autowired
    private CommandPolicyQueryRepository commandPolicyQueryRepository;

    @EventHandler
    public void handleShoppingCartCreatedEvent(ShoppingCartCreatedEvent event) {
    	ShoppingCartEntry shoppingCartEntry = new ShoppingCartEntry(event.getCustomerId(),event.getShoppingCartId().toString());
        TenantContext.setCurrentTenant(event.getTenantId());
        shoppingCartRepository.save(shoppingCartEntry);
    }
    
    @EventHandler
    public void handleShoppingCartDeletedEvent(ShoppingCartDeletedEvent event) {
    	ShoppingCartEntry shoppingCartEntry = shoppingCartRepository.findOne(event.getShoppingCartId().toString());
        if (null!=shoppingCartEntry){
        	TenantContext.setCurrentTenant(event.getTenantId());
            shoppingCartRepository.delete(shoppingCartEntry);
        } 
    }
        
}
