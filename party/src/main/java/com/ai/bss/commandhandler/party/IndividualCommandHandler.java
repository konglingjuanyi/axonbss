package com.ai.bss.commandhandler.party;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ai.bss.aggregate.party.Individual;
import com.ai.bss.api.party.PartyId;
import com.ai.bss.api.party.command.CreateIndividualCommand;
import com.ai.bss.api.party.command.RenameIndividualCommand;
import com.ai.bss.api.party.command.TerminateIndividualCommand;
import com.ai.bss.exception.party.NewPartyNameSameAsOldException;
import com.ai.bss.mutitanent.TenantContext;

public class IndividualCommandHandler{
	private Repository<Individual> repository;

    @CommandHandler
    public PartyId handleCreateIndividual(CreateIndividualCommand command) {
    	TenantContext.setCurrentTenant(command.getTenantId());
    	PartyId identifier = command.getPartyId();
        Individual individual = new Individual(identifier, command.getFirstName(),command.getLastName());
        repository.add(individual);
        return identifier;
    }
    
    
    @CommandHandler
    public void handleRenameIndividual(RenameIndividualCommand command) throws NewPartyNameSameAsOldException,Exception{
    	TenantContext.setCurrentTenant(command.getTenantId());
    	PartyId identifier = command.getPartyId();
        Individual individual = (Individual)repository.load(identifier);
        individual.setFirstName(command.getOldFirstName());
        individual.setLastName(command.getOldLastName());
        individual.rename(command.getNewFirstName(), command.getNewLastName());      
    }
    
     @CommandHandler
    public void handleTerminateIndividual(TerminateIndividualCommand command) throws Exception{
    	TenantContext.setCurrentTenant(command.getTenantId());
    	PartyId identifier = command.getPartyId();
        Individual individual = (Individual)repository.load(identifier);
        individual.terminate();
    }
    
    
    @Autowired
    @Qualifier("individualRepository")
    public void setRepository(Repository<Individual> individualRepository) {
        this.repository = individualRepository;
    }

}
