package com.ai.bss.aggregate.party;

import org.axonframework.eventhandling.annotation.EventHandler;

import com.ai.bss.api.party.PartyId;
import com.ai.bss.api.party.event.LegalCreatedEvent;
import com.ai.bss.api.party.event.LegalRenamedEvent;
import com.ai.bss.api.party.event.LegalTerminatedEvent;
import com.ai.bss.exception.party.NewPartyNameSameAsOldException;

public class Legal extends Organization {
	private String legalName;
	
	private Legal(){
		
	}

	public Legal(PartyId partyId,String tradingName) {
		apply(new LegalCreatedEvent(partyId, tradingName));		
	}
	
	@EventHandler
	public void onLegalCreated(LegalCreatedEvent event){		
		this.setPartyId(event.getPartyId());
		this.setLegalName(event.getTradingName());
	}

	public void rename(String tradingName) throws Exception{
		if (tradingName.equalsIgnoreCase(this.getLegalName())){
			throw new NewPartyNameSameAsOldException(this.getName());
		}
		this.setLegalName(tradingName);
		apply(new LegalRenamedEvent(this.getPartyId(), tradingName));
	}
	
	public void terminate() throws Exception{
		//TODO check if party has partyRoles, if have, notify to terminate partyRole first.
		this.setState("Terminated");
		apply(new LegalTerminatedEvent(this.getPartyId()));
	}


	@Override
	public String getName() {
		return this.legalName;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
}
