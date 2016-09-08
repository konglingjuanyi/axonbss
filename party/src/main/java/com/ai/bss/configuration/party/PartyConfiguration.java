package com.ai.bss.configuration.party;

import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ai.bss.aggregate.party.Department;
import com.ai.bss.aggregate.party.Individual;
import com.ai.bss.aggregate.party.Legal;
import com.ai.bss.commandhandler.party.DepartmentCommandHandler;
import com.ai.bss.commandhandler.party.IndividualCommandHandler;
import com.ai.bss.commandhandler.party.LegalOrganizationCommandHandler;
@Configuration
public class PartyConfiguration {
	@Autowired
	private EventBus eventBus;
	@Autowired
	private EventStore eventStore;
	
	@Bean
    EventSourcingRepository<Individual> individualRepository() {
        EventSourcingRepository<Individual> repo = new EventSourcingRepository<Individual>(Individual.class,eventStore);
        repo.setEventBus(eventBus);
        return repo;
    }
	
	@Bean
    EventSourcingRepository<Legal> legalRepository() {
        EventSourcingRepository<Legal> repo = new EventSourcingRepository<Legal>(Legal.class,eventStore);
        repo.setEventBus(eventBus);
        return repo;
    }
	
	@Bean
    EventSourcingRepository<Department> departmentRepository() {
        EventSourcingRepository<Department> repo = new EventSourcingRepository<Department>(Department.class,eventStore);
        repo.setEventBus(eventBus);
        return repo;
    }
	
	@Bean
	IndividualCommandHandler individualCommandHandler(){
		IndividualCommandHandler individualCommandHandler=new IndividualCommandHandler();
		individualCommandHandler.setRepository(individualRepository());
		return individualCommandHandler;
	}
		
	@Bean
	LegalOrganizationCommandHandler legalOrganizationCommandHandler(){
		LegalOrganizationCommandHandler legalOrganizationCommandHandler=new LegalOrganizationCommandHandler();
		legalOrganizationCommandHandler.setRepository(legalRepository());
		return legalOrganizationCommandHandler;
	}
	
	@Bean
	DepartmentCommandHandler departmentCommandHandler(){
		DepartmentCommandHandler departmentCommandHandler=new DepartmentCommandHandler();
		departmentCommandHandler.setRepository(departmentRepository());
		return departmentCommandHandler;
	}

}
