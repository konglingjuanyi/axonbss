package com.ai.bss.configuration.shoppingcart;

import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ai.bss.aggregate.shoppingcart.ShoppingCart;
import com.ai.bss.commandhandler.shoppingcart.ShoppingCartCommandHandler;
@Configuration
public class ShoppingCartConfiguration {
	@Autowired
	private EventBus eventBus;
	@Autowired
	private EventStore eventStore;
	
	@Bean
    EventSourcingRepository<ShoppingCart> shoppingCartRepository() {
        EventSourcingRepository<ShoppingCart> repo = new EventSourcingRepository<ShoppingCart>(ShoppingCart.class,eventStore);
        repo.setEventBus(eventBus);
        return repo;
    }	
	
	@Bean
	ShoppingCartCommandHandler shoppingCartCommandHandler(){
		ShoppingCartCommandHandler shoppingCartCommandHandler=new ShoppingCartCommandHandler();
		shoppingCartCommandHandler.setRepository(shoppingCartRepository());
		return shoppingCartCommandHandler;
	}
}
