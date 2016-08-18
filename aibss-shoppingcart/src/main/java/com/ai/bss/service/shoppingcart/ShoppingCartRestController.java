package com.ai.bss.service.shoppingcart;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ai.bss.api.shoppingcart.command.AddShoppingCartItemCommand;
import com.ai.bss.api.shoppingcart.command.CreateShoppingCartCommand;
import com.ai.bss.api.shoppingcart.command.DeleteShoppingCartCommand;
import com.ai.bss.api.shoppingcart.command.DeleteShoppingCartItemCommand;
import com.ai.bss.api.shoppingcart.command.IncreaseShoppingCartItemQuantityCommand;
import com.ai.bss.api.shoppingcart.command.ModifyShoppingCartItemProductCharacterCommand;
import com.ai.bss.command.CommandExecuter;

@RestController
@RequestMapping("/shoppingcart")
@EnableDiscoveryClient

public class ShoppingCartRestController {
	@Autowired
	private CommandBus commandBus;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() throws Exception{
    	return "Welcome to shopping cart service!";
    }
	
    @RequestMapping(value = "/CreateShoppingCartCommand", method = RequestMethod.POST)
    public CreateShoppingCartCommand createShoppingCart(@RequestBody CreateShoppingCartCommand command) throws Exception{
    	CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<CreateShoppingCartCommand>(command));
    	return command;
    }
    
    
    @RequestMapping(value = "/AddShoppingCartItemCommand", method = RequestMethod.POST)
    public AddShoppingCartItemCommand addShoppingCartItem(@RequestBody AddShoppingCartItemCommand command) throws Exception{
    	CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<AddShoppingCartItemCommand>(command));
    	return command;
    }
    
    
    @RequestMapping(value = "/DeleteShoppingCartItemCommand", method = RequestMethod.POST)
    public DeleteShoppingCartItemCommand deleteShoppingCartItem(@RequestBody DeleteShoppingCartItemCommand command) throws Exception {
    	CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<DeleteShoppingCartItemCommand>(command));
    	return command;
    }
    
    @RequestMapping(value = "/IncreaseShoppingCartItemQuantityCommand", method = RequestMethod.POST)
    public IncreaseShoppingCartItemQuantityCommand increaseShoppingCartItemQuantity(@RequestBody IncreaseShoppingCartItemQuantityCommand command) throws Exception {
    	CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<IncreaseShoppingCartItemQuantityCommand>(command));
    	return command;
    }
   
    @RequestMapping(value = "/DeleteShoppingCartCommand", method = RequestMethod.POST)
    public DeleteShoppingCartCommand deleteShoppingCart(@RequestBody DeleteShoppingCartCommand command) throws Exception {
    	CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<DeleteShoppingCartCommand>(command));
    	return command;
    }

    @RequestMapping(value = "/ModifyShoppingCartItemProductCharacterCommand", method = RequestMethod.POST)
    public ModifyShoppingCartItemProductCharacterCommand modifyShoppingCartItemProductCharacter(@RequestBody ModifyShoppingCartItemProductCharacterCommand command) throws Exception {
    	CommandExecuter.executeCommand(commandBus, new GenericCommandMessage<ModifyShoppingCartItemProductCharacterCommand>(command));
    	return command;
    }
}
