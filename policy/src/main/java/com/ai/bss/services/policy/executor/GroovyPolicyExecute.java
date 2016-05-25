package com.ai.bss.services.policy.executor;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.util.Map;
import org.axonframework.commandhandling.CommandMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ai.bss.query.policy.PolicySetEntry;
import com.ai.bss.query.policy.repositories.CommandPolicyQueryRepository;

@Component
public class GroovyPolicyExecute extends PolicyExecutor {
	private CommandPolicyQueryRepository commandPolicyQueryRepository;
	private GroovyPolicyExecute(){}
	
	@SuppressWarnings("SpringJavaAutowiringInspection")
	@Autowired	
	public GroovyPolicyExecute(CommandPolicyQueryRepository commandPolicyQueryRepository) {
		this.commandPolicyQueryRepository=commandPolicyQueryRepository;
	}

	@Override
	public void execute(CommandMessage<?> commandMessage, PolicySetEntry policySet,Map<String, Object> context) throws Exception{
		ClassLoader parent =ClassLoader.getSystemClassLoader();
		GroovyClassLoader loader =new GroovyClassLoader(parent);
		Class<?> clazz = loader.parseClass(policySet.toPolicyString());
		GroovyObject clazzObj =(GroovyObject)clazz.newInstance();
		clazzObj.invokeMethod("executePolicy",context);
	}

	@Override
	public CommandPolicyQueryRepository getCommandPolicyQueryRepository() {
		return commandPolicyQueryRepository;
	}


}
