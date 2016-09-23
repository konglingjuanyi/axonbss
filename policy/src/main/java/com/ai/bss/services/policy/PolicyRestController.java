package com.ai.bss.services.policy;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ai.bss.api.policy.command.CreateAtomicPolicyCommand;
import com.ai.bss.api.policy.command.CreateCompositePolicyCommand;
import com.ai.bss.api.policy.command.RegisterExistPolicyToCommand;
import com.ai.bss.api.policy.command.RegisterNewAtomicPolicyToCommand;
import com.ai.bss.api.policy.command.RegisterNewCompositePolicyToCommand;
import com.ai.bss.command.CommandExecuter;

@RestController
@RequestMapping("/policy")
@EnableDiscoveryClient

public class PolicyRestController {
	@Autowired
	private CommandBus commandBus;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() throws Exception{
    	return "Welcome to policy service!";
    }
	
    @RequestMapping(value = "/createAtomicPolicyCommand", method = RequestMethod.POST)
    public void createShoppingCart(@RequestBody CreateAtomicPolicyCommand command) throws Exception{
    	CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<CreateAtomicPolicyCommand>(command));
    }
    
    @RequestMapping(value = "/createCompositePolicyCommand", method = RequestMethod.POST)
    public void createShoppingCart(@RequestBody CreateCompositePolicyCommand command) throws Exception{
    	CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<CreateCompositePolicyCommand>(command));
    }
    
    @RequestMapping(value = "/registerNewAtomicPolicyToCommand", method = RequestMethod.POST)
    public void createShoppingCart(@RequestBody RegisterNewAtomicPolicyToCommand command) throws Exception{
    	CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<RegisterNewAtomicPolicyToCommand>(command));
    }
    
    @RequestMapping(value = "/registerNewCompositePolicyToCommand", method = RequestMethod.POST)
    public void createShoppingCart(@RequestBody RegisterNewCompositePolicyToCommand command) throws Exception{
    	CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<RegisterNewCompositePolicyToCommand>(command));
    }
    
    @RequestMapping(value = "/registerExistPolicyToCommand", method = RequestMethod.POST)
    public void createShoppingCart(@RequestBody RegisterExistPolicyToCommand command) throws Exception{
    	CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<RegisterExistPolicyToCommand>(command));
    }
    
}
