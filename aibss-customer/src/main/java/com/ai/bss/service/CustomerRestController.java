package com.ai.bss.service;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.commandhandling.callbacks.FutureCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ai.bss.api.customer.command.CreateCustomerFromPartyCommand;
import com.ai.bss.api.customer.command.CreateIndividualCustomerCommand;
import com.ai.bss.api.customer.command.CreateLegalCustomerCommand;
import com.ai.bss.command.CommandExecuter;

@RestController
@RequestMapping("/customer")
@EnableDiscoveryClient

public class CustomerRestController {
	@Autowired
	private CommandBus commandBus;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() throws Exception{
    	return "Welcome to customer service!";
    }
	
    @RequestMapping(value = "/CreateCustomerFromPartyCommand", method = RequestMethod.POST)
    public CreateCustomerFromPartyCommand createCustomerFromParty(@RequestBody CreateCustomerFromPartyCommand command)  throws Exception{
    	FutureCallback callback= CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<CreateCustomerFromPartyCommand>(command));
    	command.setCallback(callback);
    	return command;
    }
    
    @RequestMapping(value = "/CreateIndividualCustomerCommand", method = RequestMethod.POST)
    public CreateIndividualCustomerCommand createIndividualCustomerCommand(@RequestBody CreateIndividualCustomerCommand command)  throws Exception{
    	FutureCallback callback= CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<CreateIndividualCustomerCommand>(command));
    	command.setCallback(callback);
    	return command;
    }
    
    @RequestMapping(value = "/CreateLegalCustomerCommand", method = RequestMethod.POST)
    public CreateLegalCustomerCommand createLegalCustomerCommand(@RequestBody CreateLegalCustomerCommand command)  throws Exception{
    	FutureCallback callback= CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<CreateLegalCustomerCommand>(command));
    	command.setCallback(callback);
    	return command;
    }	
	

    


}
