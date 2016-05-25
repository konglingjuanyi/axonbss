package com.ai.bss.services.policy.executor;

import java.util.Map;

import org.axonframework.commandhandling.CommandMessage;


public interface IPolicyExecutor {
	//查找并执行规则，返回结果放入commandMessage
	public CommandMessage<?> findAndExecute(CommandMessage<?> commandMessage)throws Exception;
}
