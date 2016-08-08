package com.ai.bss.service;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.commandhandling.callbacks.FutureCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ai.bss.CommandExecuter;
import com.ai.bss.api.party.command.CreateChildDepartmentCommand;
import com.ai.bss.api.party.command.CreateIndividualCommand;
import com.ai.bss.api.party.command.CreateLegalCommand;
import com.ai.bss.api.party.command.CreateTopDepartmentCommand;
import com.ai.bss.api.party.command.RenameDepartmentCommand;
import com.ai.bss.api.party.command.RenameIndividualCommand;
import com.ai.bss.api.party.command.RenameLegalCommand;
import com.ai.bss.api.party.command.TerminateDepartmentCommand;
import com.ai.bss.api.party.command.TerminateIndividualCommand;
import com.ai.bss.api.party.command.TerminateLegalCommand;

@RestController
@RequestMapping("/party")
@EnableDiscoveryClient

public class PartyRestController {
	@Autowired
	private CommandBus commandBus;
	
	 @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() throws Exception{
    	return "Welcome to party service!";
    }
	
    @RequestMapping(value = "/createIndividualCommand", method = RequestMethod.POST)
    public CreateIndividualCommand createIndividual(@RequestBody CreateIndividualCommand command) throws Exception{
    	FutureCallback callback= CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<CreateIndividualCommand>(command));
    	command.setCallback(callback);
    	return command;
    }
    
    @RequestMapping(value = "/createLegalCommand", method = RequestMethod.POST)
    public CreateLegalCommand createLegal(@RequestBody CreateLegalCommand command) throws Exception{
    	FutureCallback callback =  CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<CreateLegalCommand>(command));
    	command.setCallback(callback);
    	return command;
    }
    
    @RequestMapping(value = "/createTopDepartmentCommand", method = RequestMethod.POST)
    public CreateTopDepartmentCommand createTopDepartment(@RequestBody CreateTopDepartmentCommand command) throws Exception{
    	FutureCallback callback =  CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<CreateTopDepartmentCommand>(command));
    	command.setCallback(callback);
    	return command;
    }
    
    @RequestMapping(value = "/createChildDepartmentCommand", method = RequestMethod.POST)
    public CreateChildDepartmentCommand createChildDepartment(@RequestBody CreateChildDepartmentCommand command) throws Exception{
    	FutureCallback callback =  CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<CreateChildDepartmentCommand>(command));
    	command.setCallback(callback);
    	return command;
    }
    
    @RequestMapping(value = "/renameIndividualCommand", method = RequestMethod.POST)
    public RenameIndividualCommand renameIndividual(@RequestBody RenameIndividualCommand command) throws Exception{
    	FutureCallback callback =  CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<RenameIndividualCommand>(command));
    	command.setCallback(callback);
    	return command;
    }
    
    @RequestMapping(value = "/renameLegalCommand", method = RequestMethod.POST)
    public RenameLegalCommand renameLegal(@RequestBody RenameLegalCommand command) throws Exception{         	              	
    	FutureCallback callback =  CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<RenameLegalCommand>(command));
    	command.setCallback(callback);
    	return command;
    }
    
    @RequestMapping(value = "/renameDepartmentCommand", method = RequestMethod.POST)
    public RenameDepartmentCommand renameDepartment(@RequestBody RenameDepartmentCommand command) throws Exception{         	              	
    	FutureCallback callback =  CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<RenameDepartmentCommand>(command));
    	command.setCallback(callback);
    	return command;
    }
    
    @RequestMapping(value = "/terminateIndividualCommand", method = RequestMethod.POST)
    public TerminateIndividualCommand terminateIndividual(@RequestBody TerminateIndividualCommand command) throws Exception {
    	FutureCallback callback =  CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<TerminateIndividualCommand>(command));
    	command.setCallback(callback);
    	return command;
    }
    
    @RequestMapping(value = "/terminateLegalCommand", method = RequestMethod.POST)
    public TerminateLegalCommand terminateLegal(@RequestBody TerminateLegalCommand command) throws Exception {
    	FutureCallback callback =  CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<TerminateLegalCommand>(command));
    	command.setCallback(callback);
    	return command;
    }
    
    @RequestMapping(value = "/terminateDepartmentCommand", method = RequestMethod.POST)
    public TerminateDepartmentCommand terminateDepartment(@RequestBody TerminateDepartmentCommand command) throws Exception {
    	FutureCallback callback =  CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<TerminateDepartmentCommand>(command));
    	command.setCallback(callback);
    	return command;
    }

}
