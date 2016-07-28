package com.ai.bss.configuration;

import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ai.bss.aggregate.customer.Customer;
@Configuration
public class CustomerConfiguration {
	@Autowired
	private EventBus eventBus;
	@Autowired
	private EventStore eventStore;

	@Bean
    EventSourcingRepository<Customer> customerRepository() {
        EventSourcingRepository<Customer> repo = new EventSourcingRepository<Customer>(Customer.class,eventStore);
        repo.setEventBus(eventBus);
        return repo;
    }

}
