package com.ai.bss.aggregate.party;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import com.ai.bss.api.party.PartyId;

public abstract class Party extends AbstractAnnotatedAggregateRoot {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@AggregateIdentifier
	private PartyId partyId;
	private String state;
	protected Party() {
    }
	
	public PartyId getPartyId() {
		return partyId;
	}
	public void setPartyId(PartyId partyId) {
		this.partyId = partyId;
	}
	public abstract String getName() ;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
