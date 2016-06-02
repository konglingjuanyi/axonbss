package com.ai.bss.commandhandler.party;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ai.bss.aggregate.party.Department;
import com.ai.bss.aggregate.party.Party;
import com.ai.bss.api.party.PartyId;
import com.ai.bss.api.party.command.CreateChildDepartmentCommand;
import com.ai.bss.api.party.command.CreateTopDepartmentCommand;
import com.ai.bss.api.party.command.RenameDepartmentCommand;
import com.ai.bss.api.party.command.TerminateDepartmentCommand;
import com.ai.bss.exception.party.NewPartyNameSameAsOldException;

public class DepartmentCommandHandler{
	private Repository<Party> repository;
    
    @CommandHandler
    public PartyId handleCreateTopDepartment(CreateTopDepartmentCommand command) {
    	PartyId identifier = command.getPartyId();
        Department department = new Department(identifier, command.getDepartmentName(),true,command.getLegalId());
        repository.add(department);
        return identifier;
    }
    
    @CommandHandler
    public PartyId handleCreateChildDepartment(CreateChildDepartmentCommand command) {
    	PartyId identifier = command.getPartyId();
        Department department = new Department(identifier, command.getDepartmentName(),false,command.getParentDepartmentId());
        repository.add(department);
        return identifier;
    }
      
    @CommandHandler
    public void handleRenameDepartment(RenameDepartmentCommand command) throws NewPartyNameSameAsOldException,Exception{
    	PartyId identifier = command.getPartyId();
        Department department = (Department)repository.load(identifier);
        department.setDepartmentName(command.getOldDepartmentName());
        department.rename(command.getNewDepartmentName());      
    }
    
    @CommandHandler
    public void handleTerminateDepartment(TerminateDepartmentCommand command) throws Exception{
    	PartyId identifier = command.getPartyId();
    	Department department = (Department)repository.load(identifier);
    	department.terminate();
    }
    
    
    @Autowired
    @Qualifier("partyRepository")
    public void setRepository(Repository<Party> partyRepository) {
        this.repository = partyRepository;
    }

}
