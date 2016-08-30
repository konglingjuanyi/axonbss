package com.ai.bss.commandhandler.shoppingcart;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.saga.annotation.AbstractAnnotatedSaga;

import com.ai.bss.api.product.OfferInstanceId;
import com.ai.bss.api.shoppingcart.ShoppingCartId;
import com.ai.bss.api.shoppingcart.ShoppingCartItemId;

public class ShoppingCartItemSaga extends AbstractAnnotatedSaga {
	private transient CommandBus commandBus;
	private ShoppingCartId shoppingCartIdentifier;
	private ShoppingCartItemId shoppingCartItemIdentifier;
    private OfferInstanceId offerInstanceIdentifier;

	public ShoppingCartItemSaga() {
		// TODO Auto-generated constructor stub
	}

	public ShoppingCartItemSaga(String identifier) {
		super(identifier);
		// TODO Auto-generated constructor stub
	}

	public CommandBus getCommandBus() {
		return commandBus;
	}

	public void setCommandBus(CommandBus commandBus) {
		this.commandBus = commandBus;
	}

	public ShoppingCartId getShoppingCartIdentifier() {
		return shoppingCartIdentifier;
	}

	public void setShoppingCartIdentifier(ShoppingCartId shoppingCartIdentifier) {
		this.shoppingCartIdentifier = shoppingCartIdentifier;
	}

	public OfferInstanceId getOfferInstanceIdentifier() {
		return offerInstanceIdentifier;
	}

	public void setOfferInstanceIdentifier(OfferInstanceId offerInstanceIdentifier) {
		this.offerInstanceIdentifier = offerInstanceIdentifier;
	}

	public ShoppingCartItemId getShoppingCartItemIdentifier() {
		return shoppingCartItemIdentifier;
	}

	public void setShoppingCartItemIdentifier(ShoppingCartItemId shoppingCartItemIdentifier) {
		this.shoppingCartItemIdentifier = shoppingCartItemIdentifier;
	}

}
