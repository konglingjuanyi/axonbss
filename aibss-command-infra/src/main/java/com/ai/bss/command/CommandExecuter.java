package com.ai.bss.command;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.commandhandling.callbacks.FutureCallback;

public class CommandExecuter {
	public static FutureCallback executeCommand(CommandBus commandBus, GenericCommandMessage commandMsg) throws Exception{
		FutureCallback callback = new FutureCallback();
		commandBus.dispatch(commandMsg,callback);
		return callback;
	}

}
