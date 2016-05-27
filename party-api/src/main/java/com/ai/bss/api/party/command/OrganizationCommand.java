package com.ai.bss.api.party.command;

import com.ai.bss.api.party.PartyId;

public abstract class OrganizationCommand extends PartyCommand{

	private String tradingName;
			
	protected OrganizationCommand(PartyId partyId){
		super(partyId);
	}

	protected OrganizationCommand(PartyId partyId, String tradingName) {
		super(partyId);
		this.setTradingName(tradingName);
	}


	@Override
	public String getName() {
		return tradingName.toString();
	}

	public String getTradingName() {
		return tradingName;
	}

	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}	

}
