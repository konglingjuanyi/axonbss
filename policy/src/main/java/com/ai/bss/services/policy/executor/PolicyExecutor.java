package com.ai.bss.services.policy.executor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.axonframework.commandhandling.CommandMessage;

import com.ai.bss.query.policy.PolicySetEntry;
import com.ai.bss.query.policy.RegisteredCommandEntry;
import com.ai.bss.query.policy.RegisteredCommandPolicyEntry;
import com.ai.bss.query.policy.repositories.CommandPolicyQueryRepository;

public abstract class PolicyExecutor implements IPolicyExecutor {		
	
	public PolicyExecutor() {
	}
	


	@Override
	public CommandMessage<?> findAndExecute(CommandMessage<?> commandMessage)
			throws Exception {
		String commandName=commandMessage.getPayload().getClass().getName();
		String propertyValue=((ICommandHasPolicy)commandMessage.getPayload()).getPolicyPropertyValue();
		List<RegisteredCommandEntry> regieteredPolicies;
		if (null==propertyValue){
			regieteredPolicies=getCommandPolicyQueryRepository().findByCommandName(commandName);
		}else{
			regieteredPolicies=getCommandPolicyQueryRepository().findByCommandNameAndPropertyValue(commandName, propertyValue);
		}		
		if (null!=regieteredPolicies&&regieteredPolicies.size()>0){
			Map<String, Object> context = new HashMap<String, Object>();
			for (RegisteredCommandEntry registeredCommandEntry : regieteredPolicies) {
				Set<RegisteredCommandPolicyEntry> policies= registeredCommandEntry.getPolicies();
				if(null!=policies&&policies.size()>0){
					for (RegisteredCommandPolicyEntry registeredCommandPolicyEntry : policies) {
						execute(commandMessage,registeredCommandPolicyEntry.getPolicySet(),context);					
					}
				}
			}			
		}		
		return commandMessage;
	}
	
	public abstract void execute(CommandMessage<?> commandMessage, PolicySetEntry policy,Map<String, Object> context) throws Exception;

	public abstract CommandPolicyQueryRepository getCommandPolicyQueryRepository();


}
