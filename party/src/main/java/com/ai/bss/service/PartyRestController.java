package com.ai.bss.service;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.commandhandling.callbacks.FutureCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
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
	
    @RequestMapping(value = "/createIndividualCommand", method = RequestMethod.POST)
    public FutureCallback createIndividual(@RequestParam("createIndividualCommand") CreateIndividualCommand command) throws Exception{
    	return CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<CreateIndividualCommand>(command));

    }
    
    @RequestMapping(value = "/createLegalCommand", method = RequestMethod.POST)
    public FutureCallback createLegal(@RequestParam("createLegalCommand") CreateLegalCommand command) throws Exception{
    	return CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<CreateLegalCommand>(command));
    }
    
    @RequestMapping(value = "/createTopDepartmentCommand", method = RequestMethod.POST)
    public FutureCallback createTopDepartment(@RequestParam("createTopDepartmentCommand") CreateTopDepartmentCommand command) throws Exception{
    	return CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<CreateTopDepartmentCommand>(command));
    }
    
    @RequestMapping(value = "/createChildDepartmentCommand", method = RequestMethod.POST)
    public FutureCallback createChildDepartment(@RequestParam("createChildDepartmentCommand") CreateChildDepartmentCommand command) throws Exception{
    	return CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<CreateChildDepartmentCommand>(command));
    }
    
    @RequestMapping(value = "/renameIndividualCommand", method = RequestMethod.POST)
    public FutureCallback renameIndividual(@RequestParam("renameIndividualCommand") RenameIndividualCommand command) throws Exception{
    	return CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<RenameIndividualCommand>(command));

    }
    
    @RequestMapping(value = "/renameLegalCommand", method = RequestMethod.POST)
    public FutureCallback renameLegal(@RequestParam("renameLegalCommand") RenameLegalCommand command) throws Exception{         	              	
    	return CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<RenameLegalCommand>(command));

    }
    
    @RequestMapping(value = "/renameDepartmentCommand", method = RequestMethod.POST)
    public FutureCallback renameDepartment(@RequestParam("renameDepartmentCommand") RenameDepartmentCommand command) throws Exception{         	              	
    	return CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<RenameDepartmentCommand>(command));
    }
    
    @RequestMapping(value = "/terminateIndividualCommand", method = RequestMethod.POST)
    public FutureCallback terminateIndividual(@RequestParam("terminateIndividualCommand") TerminateIndividualCommand command) throws Exception {
    	return CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<TerminateIndividualCommand>(command));
    }
    
    @RequestMapping(value = "/terminateLegalCommand", method = RequestMethod.POST)
    public FutureCallback terminateLegal(@RequestParam("terminateLegalCommand") TerminateLegalCommand command) throws Exception {
    	return CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<TerminateLegalCommand>(command));
    }
    
    @RequestMapping(value = "/terminateDepartmentCommand", method = RequestMethod.POST)
    public FutureCallback terminateDepartment(@RequestParam("terminateDepartmentCommand") TerminateDepartmentCommand command) throws Exception {
    	return CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<TerminateDepartmentCommand>(command));
    }

}
