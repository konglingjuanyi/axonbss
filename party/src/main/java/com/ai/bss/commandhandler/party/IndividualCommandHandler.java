package com.ai.bss.commandhandler.party;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ai.bss.aggregate.party.Individual;
import com.ai.bss.aggregate.party.Party;
import com.ai.bss.api.party.PartyId;
import com.ai.bss.api.party.command.CreateIndividualCommand;

public class IndividualCommandHandler{

	 private Repository<Party> repository;

    @CommandHandler
    public PartyId handleCreateUser(CreateIndividualCommand command) {
    	PartyId identifier = command.getPartyId();
        Individual individual = new Individual(identifier, command.getFirstName(),command.getLastName());
        repository.add(individual);
        return identifier;
    }
    
    @Autowired
    @Qualifier("partyRepository")
    public void setRepository(Repository<Party> partyRepository) {
        this.repository = partyRepository;
    }

}
