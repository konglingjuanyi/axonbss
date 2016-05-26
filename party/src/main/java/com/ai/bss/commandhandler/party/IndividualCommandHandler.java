package com.ai.bss.commandhandler.party;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ai.bss.aggregate.party.Individual;
import com.ai.bss.aggregate.party.Party;
import com.ai.bss.api.party.PartyId;
import com.ai.bss.api.party.command.CreateIndividualCommand;
import com.ai.bss.api.party.command.RenameIndividualCommand;
import com.ai.bss.api.party.command.TerminateIndividualCommand;
import com.ai.bss.exception.party.NewPartyNameSameAsOldException;

public class IndividualCommandHandler{
	private Repository<Party> repository;

    @CommandHandler
    public PartyId handleCreateIndividual(CreateIndividualCommand command) {
    	PartyId identifier = command.getPartyId();
        Individual individual = new Individual(identifier, command.getFirstName(),command.getLastName());
        repository.add(individual);
        return identifier;
    }
    
    @CommandHandler
    public void handleRenameIndividual(RenameIndividualCommand command) throws NewPartyNameSameAsOldException,Exception{
    	PartyId identifier = command.getPartyId();
        Individual individual = (Individual)repository.load(identifier);
        individual.setFirstName(command.getOldFirstName());
        individual.setLastName(command.getLastName());
        individual.rename(command.getFirstName(), command.getLastName());      
    }
    
    @CommandHandler
    public void handleTerminateIndividual(TerminateIndividualCommand command) throws Exception{
    	PartyId identifier = command.getPartyId();
        Individual individual = (Individual)repository.load(identifier);
        individual.terminate();
    }
    
    
    @Autowired
    @Qualifier("partyRepository")
    public void setRepository(Repository<Party> partyRepository) {
        this.repository = partyRepository;
    }

}
