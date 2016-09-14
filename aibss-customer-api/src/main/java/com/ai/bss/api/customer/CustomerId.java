package com.ai.bss.api.customer;

import com.ai.bss.api.party.PartyRoleId;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class CustomerId  extends PartyRoleId{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CustomerId( ){
		super();
	}
	public CustomerId(String customerId){
		super(customerId);
	}
}
