package com.ai.bss.configuration.customerorder;

import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ai.bss.aggregate.customerorder.CustomerOrder;
import com.ai.bss.commandhandler.customerorder.CustomerOrderCommandHandler;
@Configuration
public class CustomerOrderConfiguration {
	@Autowired
	private EventBus eventBus;
	@Autowired
	private EventStore eventStore;
	
	@Bean
    EventSourcingRepository<CustomerOrder> customerOrderRepository() {
        EventSourcingRepository<CustomerOrder> repo = new EventSourcingRepository<CustomerOrder>(CustomerOrder.class,eventStore);
        repo.setEventBus(eventBus);
        return repo;
    }
	
	@Bean
	CustomerOrderCommandHandler customerOrderCommandHandler(){
		CustomerOrderCommandHandler customerOrderCommandHandler=new CustomerOrderCommandHandler();
		customerOrderCommandHandler.setRepository(customerOrderRepository());
		return customerOrderCommandHandler;
	}
	
}
