package com.ai.bss.api.party.command;

import java.io.Serializable;

import org.axonframework.commandhandling.callbacks.FutureCallback;
import org.axonframework.common.Assert;

import com.ai.bss.api.base.BaseCommand;
import com.ai.bss.api.party.PartyId;

public abstract class PartyCommand extends BaseCommand{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PartyId partyId;
	private FutureCallback callback;
	
	protected PartyCommand(){
		
	}
	
	public PartyCommand(PartyId partyId) {
		Assert.notNull(partyId, "The provided partyId cannot be null");
		this.partyId=partyId;
	}

	public PartyId getPartyId() {
		return partyId;
	}

	public void setPartyId(PartyId partyId) {
		this.partyId = partyId;
	}

	public FutureCallback getCallback() {
		return callback;
	}

	public void setCallback(FutureCallback callback) {
		this.callback = callback;
	}

}
