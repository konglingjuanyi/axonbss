package com.ai.bss.aggregate.party;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import com.ai.bss.api.party.PartyId;
import com.ai.bss.api.party.PartyRoleId;

public class PartyRole extends AbstractAnnotatedAggregateRoot {
	@AggregateIdentifier
	private PartyRoleId partyRoleId;
	private PartyId partyId;
	protected PartyRole(){
		
	}
	
	public PartyRole(PartyRoleId partyRoleId,PartyId partyId){
		this.partyRoleId=partyRoleId;
		this.partyId=partyId;
	}
	
	public PartyRoleId getPartyRoleId() {
		return partyRoleId;
	}
	public void setPartyRoleId(PartyRoleId partyRoleId) {
		this.partyRoleId = partyRoleId;
	}
	public PartyId getPartyId() {
		return partyId;
	}
	public void setPartyId(PartyId partyId) {
		this.partyId = partyId;
	}
}
