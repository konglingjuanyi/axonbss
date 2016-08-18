package com.ai.bss.api.shoppingcart;

import java.io.Serializable;

import org.axonframework.common.Assert;
import org.axonframework.domain.IdentifierFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingCartItemId  implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty
	private String identifier;

	    public ShoppingCartItemId() {
	        this.identifier = IdentifierFactory.getInstance().generateIdentifier();
	    }

	    public ShoppingCartItemId(String identifier) {
	        Assert.notNull(identifier, "Identifier may not be null");
	        this.identifier = identifier;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        ShoppingCartItemId shoppingCartItemId = (ShoppingCartItemId) o;

	        return identifier.equals(shoppingCartItemId.identifier);

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
