package com.ai.bss.commandhandler.customer;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.commandhandling.callbacks.FutureCallback;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ai.bss.aggregate.customer.Customer;
import com.ai.bss.api.customer.CustomerId;
import com.ai.bss.api.customer.command.CreateCustomerFromPartyCommand;
import com.ai.bss.api.customer.command.CreateIndividualCustomerCommand;
import com.ai.bss.api.customer.command.CreateLegalCustomerCommand;
import com.ai.bss.api.party.PartyId;
import com.ai.bss.api.party.command.CreateIndividualCommand;
import com.ai.bss.api.party.command.CreateLegalCommand;

public class CustomerCommandHandler {
	private Repository<Customer> repository;
	private CommandBus commandBus;
	public CustomerCommandHandler() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
    @Qualifier("customerRepository")
    public void setRepository(Repository<Customer> customerRepository) {
        this.repository = customerRepository;
    }
	
	@Autowired
    @Qualifier("commandBus")
    public void setCommandBus(CommandBus commandBus) {
        this.commandBus = commandBus;
    }
	
	@CommandHandler
    public void handleCreateIndividualCustomer(CreateIndividualCustomerCommand command) {
		PartyId partyId=new PartyId();
    	CreateIndividualCommand createIndividualCommand=new CreateIndividualCommand(partyId,command.getFirstName(),command.getLastName());
    	FutureCallback callback = new FutureCallback();
    	commandBus.dispatch(new GenericCommandMessage<CreateIndividualCommand>(createIndividualCommand),callback);
		try {
			callback.getResult();
			CustomerId customerId=new CustomerId();
			CreateCustomerFromPartyCommand createCustomercommand=new CreateCustomerFromPartyCommand(customerId,partyId);
			createCustomercommand.setServiceCode(command.getServiceCode());
			createCustomercommand.setServicePassword(command.getServicePassword());
			commandBus.dispatch(new GenericCommandMessage<CreateCustomerFromPartyCommand>(createCustomercommand),callback);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@CommandHandler
    public void handleCreateLegalCustomer(CreateLegalCustomerCommand command) {
		PartyId partyId=new PartyId();
		CreateLegalCommand createLegalCommand=new CreateLegalCommand(partyId,command.getLegalName());	
		createLegalCommand.setParentLegalId(command.getParentLegalId());
    	FutureCallback callback = new FutureCallback();
    	commandBus.dispatch(new GenericCommandMessage<CreateLegalCommand>(createLegalCommand),callback);
		try {
			callback.getResult();
			CustomerId customerId=new CustomerId();
			CreateCustomerFromPartyCommand createCustomercommand=new CreateCustomerFromPartyCommand(customerId,partyId);
			createCustomercommand.setServiceCode(command.getServiceCode());
			createCustomercommand.setServicePassword(command.getServicePassword());
			commandBus.dispatch(new GenericCommandMessage<CreateCustomerFromPartyCommand>(createCustomercommand),callback);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@CommandHandler
    public void handleCreateCustomerFromParty(CreateCustomerFromPartyCommand command) {
		PartyId partyId = command.getPartyId();
		CustomerId identifier = command.getCustomerId();
		Customer customer=new Customer(identifier,partyId,command.getServiceCode(),command.getServicePassword());
		repository.add(customer);
	}

}
