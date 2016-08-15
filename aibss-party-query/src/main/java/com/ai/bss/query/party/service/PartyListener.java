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

package com.ai.bss.query.party.service;

import javax.transaction.Transactional;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ai.bss.api.party.event.ChildDepartmentCreatedEvent;
import com.ai.bss.api.party.event.DepartmentRenamedEvent;
import com.ai.bss.api.party.event.DepartmentTerminatedEvent;
import com.ai.bss.api.party.event.IndividualCreatedEvent;
import com.ai.bss.api.party.event.IndividualRenamedEvent;
import com.ai.bss.api.party.event.IndividualTerminatedEvent;
import com.ai.bss.api.party.event.LegalCreatedEvent;
import com.ai.bss.api.party.event.LegalRenamedEvent;
import com.ai.bss.api.party.event.LegalTerminatedEvent;
import com.ai.bss.api.party.event.TopDepartmentCreatedEvent;
import com.ai.bss.mutitanent.TenantContext;
import com.ai.bss.query.api.party.DepartmentEntry;
import com.ai.bss.query.api.party.IndividualEntry;
import com.ai.bss.query.api.party.LegalOrganizationEntry;
import com.ai.bss.query.api.party.OrganizationEntry;
import com.ai.bss.query.api.party.PartyEntry;
import com.ai.bss.query.party.repositories.PartyQueryRepository;

@Component
public class PartyListener {
	@Autowired
    private PartyQueryRepository partyRepository;

    @EventHandler
    @Transactional
    public void handleIndividualCreatedEvent(IndividualCreatedEvent event) {
        IndividualEntry partyEntry = new IndividualEntry(event.getPartyId().toString(),event.getFirstName(),event.getLastName());
    	partyEntry.setState("initial");
        TenantContext.setCurrentTenant(event.getTenantId());
        partyRepository.save(partyEntry);
    }
    
    @EventHandler
    public void handleLegalCreatedEvent(LegalCreatedEvent event) {
        LegalOrganizationEntry partyEntry = new LegalOrganizationEntry(event.getPartyId().toString(),event.getTradingName());
        partyEntry.setState("initial");
        TenantContext.setCurrentTenant(event.getTenantId());
        partyRepository.save(partyEntry);
    }
    
    @EventHandler
    public void handleTopDepartmentCreatedEvent(TopDepartmentCreatedEvent event) {
    	OrganizationEntry legal=(OrganizationEntry)partyRepository.findOne(event.getLegalId());
        DepartmentEntry partyEntry = new DepartmentEntry(event.getPartyId().toString(),event.getDepartmentName(),true,legal);
        partyEntry.setState("initial");
        TenantContext.setCurrentTenant(event.getTenantId());
        partyRepository.save(partyEntry);
    }
    
    @EventHandler
    public void handleChildDepartmentCreatedEvent(ChildDepartmentCreatedEvent event) {
    	OrganizationEntry parentDepartment=(OrganizationEntry)partyRepository.findOne(event.getParentDepartmentId());
        DepartmentEntry partyEntry = new DepartmentEntry(event.getPartyId().toString(),event.getDepartmentName(),false,parentDepartment);
        partyEntry.setState("initial");
        TenantContext.setCurrentTenant(event.getTenantId());
        partyRepository.save(partyEntry);
    }
        
    @EventHandler
    public void handleIndividualRenamedEvent(IndividualRenamedEvent event) {
        IndividualEntry partyEntry = (IndividualEntry)partyRepository.findOne(event.getPartyId().toString());
        partyEntry.setFirstName(event.getNewFirstName());
        partyEntry.setLastName(event.getNewLastName());
        TenantContext.setCurrentTenant(event.getTenantId());
        partyRepository.save(partyEntry);
    }
    
    @EventHandler
    public void handleLegalRenamedEvent(LegalRenamedEvent event) {
        LegalOrganizationEntry partyEntry = (LegalOrganizationEntry)partyRepository.findOne(event.getPartyId().toString());
        partyEntry.setLegalName(event.getTradingName());
        TenantContext.setCurrentTenant(event.getTenantId());
        partyRepository.save(partyEntry);
    }
    
    @EventHandler
    public void handleDepartmentRenamedEvent(DepartmentRenamedEvent event) {
        DepartmentEntry partyEntry = (DepartmentEntry)partyRepository.findOne(event.getPartyId().toString());
        partyEntry.setDepartmentName(event.getDepartmentName());
        TenantContext.setCurrentTenant(event.getTenantId());
        partyRepository.save(partyEntry);
    }
    
    @EventHandler
    public void handleIndividualTerminatedEvent(IndividualTerminatedEvent event) {
    	TenantContext.setCurrentTenant(event.getTenantId());
        this.terminateParty(event.getPartyId().toString());
    }
    
    @EventHandler
    public void handleLegalTerminatedEvent(LegalTerminatedEvent event) {
    	TenantContext.setCurrentTenant(event.getTenantId());
        this.terminateParty(event.getPartyId().toString());
    }
    
    @EventHandler
    public void handleDepartmentTerminatedEvent(DepartmentTerminatedEvent event) {
    	TenantContext.setCurrentTenant(event.getTenantId());
        this.terminateParty(event.getPartyId().toString());
    }
    
    private void terminateParty(String partyId){
    	PartyEntry partyEntry = partyRepository.findOne(partyId);
    	partyEntry.setState("Terminated");
    	partyRepository.save(partyEntry);
    }

    @Autowired
    public void setPartyRepository(PartyQueryRepository partyRepository) {
        this.partyRepository = partyRepository;
    }
}
