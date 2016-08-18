package com.ai.bss.commandhandler.shoppingcart;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ai.bss.aggregate.shoppingcart.ShoppingCart;
import com.ai.bss.api.shoppingcart.ShoppingCartId;
import com.ai.bss.api.shoppingcart.command.AddShoppingCartItemCommand;
import com.ai.bss.api.shoppingcart.command.CreateShoppingCartCommand;
import com.ai.bss.api.shoppingcart.command.DecreaseShoppingCartItemQuantityCommand;
import com.ai.bss.api.shoppingcart.command.IncreaseShoppingCartItemQuantityCommand;
import com.ai.bss.mutitanent.TenantContext;

public class ShoppingCartCommandHandler {
	private Repository<ShoppingCart> repository;

    @CommandHandler
    public ShoppingCartId handleCreateShoppingCart(CreateShoppingCartCommand command) {
    	TenantContext.setCurrentTenant(command.getTenantId());
    	ShoppingCartId identifier = command.getShoppingCartId();
    	ShoppingCart shoppingCart = new ShoppingCart(command.getCustomerId(),identifier);
        repository.add(shoppingCart);
        return identifier;
    }
    
    
    @CommandHandler
    public void handleAddShoppingCartItem(AddShoppingCartItemCommand command){
    	TenantContext.setCurrentTenant(command.getTenantId());
    	ShoppingCartId identifier = command.getShoppingCartId();
    	ShoppingCart shoppingCart = (ShoppingCart)repository.load(identifier);
    	shoppingCart.addShoppingCartItem(command.getShopingCartItemId(),
    			command.getOfferId(),
    			command.getQuantity(),
    			command.getPrice(),
    			command.getOfferCharacters(),
    			command.getProductCharacters());      
    }
    
    @CommandHandler
    public void handleIncreaseShoppingCartItemQuantity(IncreaseShoppingCartItemQuantityCommand command){
    	TenantContext.setCurrentTenant(command.getTenantId());
    	ShoppingCartId identifier = command.getShoppingCartId();
    	ShoppingCart shoppingCart = (ShoppingCart)repository.load(identifier);
    	shoppingCart.increaseItemQuantity(command.getShopingCartItemId(), command.getNewQuantity(), command.getPrice());
    }
    
    @CommandHandler
    public void handleDecreaseShoppingCartItemQuantity(DecreaseShoppingCartItemQuantityCommand command){
    	TenantContext.setCurrentTenant(command.getTenantId());
    	ShoppingCartId identifier = command.getShoppingCartId();
    	ShoppingCart shoppingCart = (ShoppingCart)repository.load(identifier);
    	shoppingCart.decreaseItemQuantity(command.getShopingCartItemId(), command.getNewQuantity(), command.getPrice());
    }
    
    @Autowired
    @Qualifier("shoppingCartRepository")
    public void setRepository(Repository<ShoppingCart> shoppingCartRepository) {
        this.repository = shoppingCartRepository;
    }
}
