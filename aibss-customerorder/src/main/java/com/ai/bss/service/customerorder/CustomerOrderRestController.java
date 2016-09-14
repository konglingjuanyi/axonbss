package com.ai.bss.service.customerorder;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ai.bss.api.customerorder.command.StartBuyOrderCommand;
import com.ai.bss.command.CommandExecuter;

@RestController
@RequestMapping("/customerorder")
@EnableDiscoveryClient

public class CustomerOrderRestController {
	@Autowired
	private CommandBus commandBus;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() throws Exception{
    	return "Welcome to customer order service!";
    }
	
    @RequestMapping(value = "/startBuyOrderCommand", method = RequestMethod.POST)
    public void createShoppingCart(@RequestBody StartBuyOrderCommand command) throws Exception{
    	CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<StartBuyOrderCommand>(command));
    }
    
}
