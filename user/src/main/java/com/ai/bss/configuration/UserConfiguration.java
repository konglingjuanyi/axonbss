package com.ai.bss.configuration;

import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ai.bss.aggregate.user.User;
@Configuration
public class UserConfiguration {
	@Autowired
	private EventBus eventBus;
	@Autowired
	private EventStore eventStore;

	@Bean
    EventSourcingRepository<User> userRepository() {
        EventSourcingRepository<User> repo = new EventSourcingRepository<User>(User.class,eventStore);
        repo.setEventBus(eventBus);
        return repo;
    }

}
