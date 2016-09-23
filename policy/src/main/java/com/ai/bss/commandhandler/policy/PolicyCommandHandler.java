package com.ai.bss.commandhandler.policy;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.ai.bss.aggregate.policy.Policy;
import com.ai.bss.api.policy.PolicyId;
import com.ai.bss.api.policy.command.CreateAtomicPolicyCommand;
import com.ai.bss.api.policy.command.CreateCompositePolicyCommand;
import com.ai.bss.api.policy.command.RegisterExistPolicyToCommand;
import com.ai.bss.api.policy.command.RegisterNewAtomicPolicyToCommand;
import com.ai.bss.api.policy.command.RegisterNewCompositePolicyToCommand;
import com.ai.bss.mutitanent.TenantContext;

public class PolicyCommandHandler {
	private Repository<Policy> repository;

	public PolicyCommandHandler() {
		
	}
	
    @CommandHandler
    public void createAtomicPolicy(CreateAtomicPolicyCommand command){
    	TenantContext.setCurrentTenant(command.getTenantId());
    	PolicyId identifier = command.getPolicyId();
    	Policy policy = new Policy(identifier,command.getPolicy());
        repository.add(policy);
    }
    
    @CommandHandler
    public void createCompositePolicy(CreateCompositePolicyCommand command){
    	TenantContext.setCurrentTenant(command.getTenantId());
    	PolicyId identifier = command.getPolicyId();
    	Policy policy = new Policy(identifier,command.getPolicy());
        repository.add(policy);
    }
    
    @CommandHandler
    public void registerAtomicToCommand(RegisterNewAtomicPolicyToCommand command){
    	TenantContext.setCurrentTenant(command.getTenantId());
    	Policy policy = repository.load(command.getPolicyId());
    	policy.registerToCommand(command.getCommandName(), command.getCommandPropertyValue());
    	 repository.add(policy);
    }
    
    @CommandHandler
    public void registerCompositeToCommand(RegisterNewCompositePolicyToCommand command){
    	TenantContext.setCurrentTenant(command.getTenantId());
    	Policy policy = repository.load(command.getPolicyId());
    	policy.registerToCommand(command.getCommandName(), command.getCommandPropertyValue());
    	 repository.add(policy);
    }
    
    @CommandHandler
    public void registerExistToCommand(RegisterExistPolicyToCommand command){
    	TenantContext.setCurrentTenant(command.getTenantId());
    	Policy policy = repository.load(command.getPolicyId());
    	policy.registerToCommand(command.getCommandName(), command.getCommandPropertyValue());
    	 repository.add(policy);
    }
    
    @Autowired
    @Qualifier("policyRepository")
    public void setRepository(Repository<Policy> policyRepository) {
        this.repository = policyRepository;
    }
}
