package com.ai.bss.test.party;

import static org.junit.Assert.*;

import org.axonframework.eventsourcing.EventSourcedAggregateRoot;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Component;

import com.ai.bss.aggregate.party.Individual;
import com.ai.bss.aggregate.party.Party;
import com.ai.bss.api.party.PartyId;
import com.ai.bss.api.party.command.CreateIndividualCommand;
import com.ai.bss.api.party.event.IndividualCreatedEvent;
import com.ai.bss.commandhandler.party.IndividualCommandHandler;
@Component
public class PartyCommandHandlerTest {

	 private FixtureConfiguration fixture;

	    @Before
	    public void setUp() {
	        fixture = Fixtures.newGivenWhenThenFixture(Individual.class);
	        IndividualCommandHandler commandHandler = new IndividualCommandHandler();
	        commandHandler.setRepository(fixture.getRepository());
	        fixture.registerAnnotatedCommandHandler(commandHandler);
	    }


	    @Test
	    public void testHandleCreateUser() throws Exception {
	        PartyId aggregateIdentifier = new PartyId();
	        fixture.given()
	                .when(new CreateIndividualCommand(aggregateIdentifier, "zhang","Levon"))
	                .expectEvents(new IndividualCreatedEvent(aggregateIdentifier, "zhang","Levon"));
	    }

}
