package com.ai.bss.api.customerorder;

import java.io.Serializable;

import org.axonframework.common.Assert;
import org.axonframework.domain.IdentifierFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerOrderItemId  implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty
	private String identifier;

	    public CustomerOrderItemId() {
	        this.identifier = IdentifierFactory.getInstance().generateIdentifier();
	    }

	    public CustomerOrderItemId(String identifier) {
	        Assert.notNull(identifier, "Identifier may not be null");
	        this.identifier = identifier;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        CustomerOrderItemId id = (CustomerOrderItemId) o;

	        return identifier.equals(id.identifier);

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
