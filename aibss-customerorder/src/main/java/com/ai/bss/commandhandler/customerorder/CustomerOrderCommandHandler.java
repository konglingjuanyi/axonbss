package com.ai.bss.commandhandler.customerorder;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ai.bss.aggregate.customerorder.CustomerOrder;
import com.ai.bss.api.customerorder.CustomerOrderId;
import com.ai.bss.api.customerorder.command.CreateBuyOrderItemCommand;
import com.ai.bss.api.customerorder.command.CreateRentOrderItemCommand;
import com.ai.bss.api.customerorder.command.StartBuyOrderCommand;
import com.ai.bss.api.customerorder.command.StartCancelOrderCommand;
import com.ai.bss.mutitanent.TenantContext;

public class CustomerOrderCommandHandler {
	private Repository<CustomerOrder> repository;

    @CommandHandler
    public void handleStartBuyOrder(StartBuyOrderCommand command) {
    	TenantContext.setCurrentTenant(command.getTenantId());
    	CustomerOrderId identifier = command.getCustomerOrderId();
    	CustomerOrder customerOrder = new CustomerOrder(identifier,command.getOffers(),command.getCharacterValues());   	
        repository.add(customerOrder);
    }
    
    @CommandHandler
    public void handleBuyOrderItem(CreateBuyOrderItemCommand command) {
    	TenantContext.setCurrentTenant(command.getTenantId());
    	CustomerOrderId identifier = command.getCustomerOrderId();
    	CustomerOrder customerOrder = repository.load(identifier);
    	customerOrder.addBuyOfferItem(command.getBuyOffer());   	
        repository.add(customerOrder);
    }
    
    @CommandHandler
    public void handleRentOrderItem(CreateRentOrderItemCommand command) {
    	TenantContext.setCurrentTenant(command.getTenantId());
    	CustomerOrderId identifier = command.getCustomerOrderId();
    	CustomerOrder customerOrder = repository.load(identifier);
    	customerOrder.addBuyOfferItem(command.getRentOffer());   	
        repository.add(customerOrder);
    }
    
    @CommandHandler
    public void handleCancelOrder(StartCancelOrderCommand command) {
    	TenantContext.setCurrentTenant(command.getTenantId());
    	CustomerOrderId identifier = command.getCustomerOrderId();
    	CustomerOrder customerOrder = repository.load(identifier);    	
    	customerOrder.requestCancelOrder();
    	repository.add(customerOrder);
    }
 
      
    @Autowired
    @Qualifier("customerOrderRepository")
    public void setRepository(Repository<CustomerOrder> customerOrderRepository) {
        this.repository = customerOrderRepository;
    }
}
