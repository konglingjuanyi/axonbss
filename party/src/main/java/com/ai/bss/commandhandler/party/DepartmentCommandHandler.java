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
import com.ai.bss.mutitanent.TenantContext;

public class DepartmentCommandHandler{
	private Repository<Department> repository;
    
    @CommandHandler
    public PartyId handleCreateTopDepartment(CreateTopDepartmentCommand command) {
    	TenantContext.setCurrentTenant(command.getTenantId());
    	PartyId identifier = command.getPartyId();
        Department department = new Department(identifier, command.getDepartmentName(),true,command.getLegalId());
        repository.add(department);
        return identifier;
    }
    
    @CommandHandler
    public PartyId handleCreateChildDepartment(CreateChildDepartmentCommand command) {
    	TenantContext.setCurrentTenant(command.getTenantId());
    	PartyId identifier = command.getPartyId();
        Department department = new Department(identifier, command.getDepartmentName(),false,command.getParentDepartmentId());
        repository.add(department);
        return identifier;
    }
      
    @CommandHandler
    public void handleRenameDepartment(RenameDepartmentCommand command) throws NewPartyNameSameAsOldException,Exception{
    	TenantContext.setCurrentTenant(command.getTenantId());
    	PartyId identifier = command.getPartyId();
        Department department = (Department)repository.load(identifier);
        department.setDepartmentName(command.getOldDepartmentName());
        department.rename(command.getNewDepartmentName());      
    }
    
    @CommandHandler
    public void handleTerminateDepartment(TerminateDepartmentCommand command) throws Exception{
    	TenantContext.setCurrentTenant(command.getTenantId());
    	PartyId identifier = command.getPartyId();
    	Department department = (Department)repository.load(identifier);
    	department.terminate();
    }
    
    
    @Autowired
    @Qualifier("departmentRepository")
    public void setRepository(Repository<Department> departmentRepository) {
        this.repository = departmentRepository;
    }

}
