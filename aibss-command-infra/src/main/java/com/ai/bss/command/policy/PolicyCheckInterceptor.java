package com.ai.bss.command.policy;

import org.axonframework.commandhandling.CommandHandlerInterceptor;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.commandhandling.InterceptorChain;
import org.axonframework.unitofwork.UnitOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class PolicyCheckInterceptor implements CommandHandlerInterceptor {
	@Autowired
	private IPolicyExecutor policyExecutor;
	public PolicyCheckInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object handle(CommandMessage<?> commandMessage, UnitOfWork unitOfWork, InterceptorChain interceptorChain)
			throws Throwable {
		return interceptorChain.proceed(handle(commandMessage));
	}
	
    public CommandMessage<?> handle(CommandMessage<?> command) throws Exception{
    	Object payload=command.getPayload();
    	if (payload instanceof ICommandHasPolicy){
    		policyExecutor.findAndExecute(command);
    	}
		return command;
	}
}
