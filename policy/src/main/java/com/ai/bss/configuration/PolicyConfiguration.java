package com.ai.bss.configuration;

import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ai.bss.aggregate.policy.Policy;
import com.ai.bss.commandhandler.policy.PolicyCommandHandler;
@Configuration
public class PolicyConfiguration {
	@Autowired
	private EventBus eventBus;
	@Autowired
	private EventStore eventStore;

	@Bean
    EventSourcingRepository<Policy> policyRepository() {
        EventSourcingRepository<Policy> repo = new EventSourcingRepository<Policy>(Policy.class,eventStore);
        repo.setEventBus(eventBus);
        return repo;
    }
	
	@Bean
	PolicyCommandHandler policyCommandHandler(){
		PolicyCommandHandler policyCommandHandler=new PolicyCommandHandler();
		policyCommandHandler.setRepository(policyRepository());
		return policyCommandHandler;
	}
}
