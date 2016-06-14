package com.ai.bss.api.customer;

import java.io.Serializable;

import org.axonframework.common.Assert;
import org.axonframework.domain.IdentifierFactory;

public class CustomerAccountId  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String identifier;

    public CustomerAccountId() {
        this.identifier = IdentifierFactory.getInstance().generateIdentifier();
    }

    public CustomerAccountId(String identifier) {
        Assert.notNull(identifier, "Identifier may not be null");
        this.identifier = identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerAccountId customerAccountId = (CustomerAccountId) o;

        return identifier.equals(customerAccountId.identifier);

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
