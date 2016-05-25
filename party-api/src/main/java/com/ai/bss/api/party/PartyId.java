package com.ai.bss.api.party;

import java.io.Serializable;

import org.axonframework.common.Assert;
import org.axonframework.domain.IdentifierFactory;

public class PartyId  implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String identifier;

	    public PartyId() {
	        this.identifier = IdentifierFactory.getInstance().generateIdentifier();
	    }

	    public PartyId(String identifier) {
	        Assert.notNull(identifier, "Identifier may not be null");
	        this.identifier = identifier;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        PartyId partyId = (PartyId) o;

	        return identifier.equals(partyId.identifier);

	    }

	    @Override
	    public int hashCode() {
	        return identifier.hashCode();
	    }

	    @Override
	    public String toString() {
	        return identifier;
	    }

}
