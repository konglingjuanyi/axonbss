package com.ai.test.customerorder;

import static org.junit.Assert.*;

import org.axonframework.eventsourcing.EventSourcedAggregateRoot;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Component;

import com.ai.bss.aggregate.customerorder.CustomerOrder;
import com.ai.bss.api.customerorder.CustomerOrderId;
import com.ai.bss.api.customerorder.command.StartBuyOrderCommand;
import com.ai.bss.api.customerorder.event.OrderInitializedEvent;
import com.ai.bss.api.product.dto.BuyOffer;
import com.ai.bss.commandhandler.customerorder.CustomerOrderCommandHandler;

@Component
public class CustomerOrderCommandHandlerTest {

	 private FixtureConfiguration fixture;

	    @Before
	    public void setUp() {
	        fixture = Fixtures.newGivenWhenThenFixture(CustomerOrder.class);
	        CustomerOrderCommandHandler commandHandler = new CustomerOrderCommandHandler();
	        commandHandler.setRepository(fixture.getRepository());
	        fixture.registerAnnotatedCommandHandler(commandHandler);
	    }


	    @Test
	    public void testHandleCreateOrder() throws Exception {
	        CustomerOrderId aggregateIdentifier = new CustomerOrderId();
	        StartBuyOrderCommand command=new StartBuyOrderCommand();
	        command.setCustomerOrderId(aggregateIdentifier);
	        BuyOffer offer=new BuyOffer();
	        offer.setProductOfferingId("1");
	        command.addOffer(offer);
	        OrderInitializedEvent event=new OrderInitializedEvent();
	        event.setCustomerOrderId(aggregateIdentifier);
	        event.addOffer(offer);
	        fixture.given()
	                .when(command)
	                .expectEvents(event);
	    }

}
