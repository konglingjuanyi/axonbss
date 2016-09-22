package com.ai.bss.configuration;

import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ai.bss.aggregate.policy.AbstractPolicy;
@Configuration
public class PolicyConfiguration {
	@Autowired
	private EventBus eventBus;
	@Autowired
	private EventStore eventStore;

	@Bean
    EventSourcingRepository<AbstractPolicy> policyRepository() {
        EventSourcingRepository<AbstractPolicy> repo = new EventSourcingRepository<AbstractPolicy>(AbstractPolicy.class,eventStore);
        repo.setEventBus(eventBus);
        return repo;
    }	

}
