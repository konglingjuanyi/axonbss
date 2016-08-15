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

package com.ai.bss.query.customer.service;

import javax.transaction.Transactional;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.bss.api.customer.event.CustomerCreatedEvent;
import com.ai.bss.query.api.customer.CustomerEntry;
import com.ai.bss.query.api.party.PartyEntry;
import com.ai.bss.query.customer.repositories.CustomerQueryRepository;
import com.ai.bss.query.party.repositories.PartyQueryRepository;

/**
 * @author Levon Zhang
 */
@Component
@Transactional
public class CustomerListener {

    private CustomerQueryRepository customerRepository;
    private PartyQueryRepository partyRepository;

    @EventHandler
    public void handleCustomerCreatedEvent(CustomerCreatedEvent event) {
    	PartyEntry partyEntry = partyRepository.findOne(event.getPartyId().toString());
        CustomerEntry customerEntry = new CustomerEntry(event.getCustomerId().toString(),partyEntry);
        customerEntry.setServiceCode(event.getServiceCode());
        customerEntry.setServicePassword(event.getServicePassword());
        customerEntry.setState("initial");
        customerRepository.save(customerEntry);
    }    
    

    @Autowired
    public void setCustomerRepository(CustomerQueryRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    @Autowired
    public void setPartyRepository(PartyQueryRepository partyRepository) {
        this.partyRepository = partyRepository;
    }
}
