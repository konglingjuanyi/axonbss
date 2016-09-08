package com.ai.bss.configuration.customerorder;

import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.axonframework.saga.SagaManager;
import org.axonframework.saga.SagaRepository;
import org.axonframework.saga.annotation.AbstractAnnotatedSaga;
import org.axonframework.saga.annotation.AnnotatedSagaManager;
import org.axonframework.saga.annotation.AsyncAnnotatedSagaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ai.bss.aggregate.customerorder.CustomerOrder;
import com.ai.bss.commandhandler.customerorder.BuyCustomerOrderSaga;
import com.ai.bss.commandhandler.customerorder.CustomerOrderCommandHandler;
@Configuration
public class CustomerOrderConfiguration {
	@Autowired
	private EventBus eventBus;
	@Autowired
	private EventStore eventStore;
	@Autowired
	private SagaRepository sagaRepository;
	
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
	
	@Bean
	@SuppressWarnings("unchecked")
	AsyncAnnotatedSagaManager sagaManager(){	
		Class<? extends AbstractAnnotatedSaga>[] sagaTypes=new Class[1];
		sagaTypes[0]=BuyCustomerOrderSaga.class;
		AsyncAnnotatedSagaManager sagaManager= new AsyncAnnotatedSagaManager(sagaTypes);
		sagaManager.setSagaRepository(sagaRepository);
		eventBus.subscribe(sagaManager);		
		return sagaManager;
	}
	
}
