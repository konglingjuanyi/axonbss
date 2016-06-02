package com.ai.bss.commandhandler.party;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ai.bss.aggregate.party.Legal;
import com.ai.bss.aggregate.party.Party;
import com.ai.bss.api.party.PartyId;
import com.ai.bss.api.party.command.CreateLegalCommand;
import com.ai.bss.api.party.command.RenameLegalCommand;
import com.ai.bss.api.party.command.TerminateLegalCommand;
import com.ai.bss.exception.party.NewPartyNameSameAsOldException;

public class LegalOrganizationCommandHandler{
	private Repository<Party> repository;
    
    @CommandHandler
    public PartyId handleCreateLegal(CreateLegalCommand command) {
    	PartyId identifier = command.getPartyId();
        Legal legal = new Legal(identifier, command.getLegalName());
        repository.add(legal);
        return identifier;
    }
    
    @CommandHandler
    public void handleRenameLegal(RenameLegalCommand command) throws NewPartyNameSameAsOldException,Exception{
    	PartyId identifier = command.getPartyId();
        Legal legal = (Legal)repository.load(identifier);
        legal.setLegalName(command.getOldLegalName());
        legal.rename(command.getNewLegalName());      
    }
    
    @CommandHandler
    public void handleTerminateLegal(TerminateLegalCommand command) throws Exception{
    	PartyId identifier = command.getPartyId();
    	Legal legal = (Legal)repository.load(identifier);
    	legal.terminate();
    }
    
    
    @Autowired
    @Qualifier("partyRepository")
    public void setRepository(Repository<Party> partyRepository) {
        this.repository = partyRepository;
    }

}
