/*
 * Copyright (c) 2010-2012. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ai.bss.query.shoppingcart.service;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ai.bss.api.shoppingcart.event.ShoppingCartCreatedEvent;
import com.ai.bss.api.shoppingcart.event.ShoppingCartDeletedEvent;
import com.ai.bss.api.shoppingcart.event.ShoppingCartItemAddedEvent;
import com.ai.bss.api.shoppingcart.event.ShoppingCartItemDeletedEvent;
import com.ai.bss.api.shoppingcart.event.ShoppingCartItemQuantityDecreasedEvent;
import com.ai.bss.api.shoppingcart.event.ShoppingCartItemQuantityIncreasedEvent;
import com.ai.bss.mutitanent.TenantContext;
import com.ai.bss.query.api.shoppingcart.ShoppingCartEntry;
import com.ai.bss.query.api.shoppingcart.ShoppingCartItemEntry;
import com.ai.bss.query.shoppingcart.repositories.ShoppingCartItemQueryRepository;
import com.ai.bss.query.shoppingcart.repositories.ShoppingCartQueryRepository;

@Component
public class ShoppingCartListener {
	@Autowired
    private ShoppingCartQueryRepository shoppingCartRepository;
	@Autowired
    private ShoppingCartItemQueryRepository shoppingCartItemRepository;

    @EventHandler
    public void handleShoppingCartCreatedEvent(ShoppingCartCreatedEvent event) {
    	ShoppingCartEntry shoppingCartEntry = new ShoppingCartEntry(event.getCustomerId(),event.getShoppingCartId().toString());
        TenantContext.setCurrentTenant(event.getTenantId());
        shoppingCartRepository.save(shoppingCartEntry);
    }
    
    @EventHandler
    public void handleShoppingCartItemAddedEvent(ShoppingCartItemAddedEvent event) {
    	ShoppingCartEntry shoppingCartEntry = shoppingCartRepository.findOne(event.getShoppingCartId().toString());
        if (null!=shoppingCartEntry){
        	TenantContext.setCurrentTenant(event.getTenantId());
            ShoppingCartItemEntry shoppingCartItemEntry=new ShoppingCartItemEntry();
            shoppingCartItemEntry.setOfferId(event.getOfferId());
            shoppingCartItemEntry.setId(event.getShoppingCartItemId().toString());
            shoppingCartItemEntry.setQuantity(event.getQuantity());
            shoppingCartItemEntry.setPrice(event.getPrice());
            shoppingCartEntry.addItem(shoppingCartItemEntry);
            shoppingCartRepository.save(shoppingCartEntry);
        }   	
    }
    
    @EventHandler
    public void handleShoppingCartItemDeletedEvent(ShoppingCartItemDeletedEvent event) {
    	ShoppingCartItemEntry shoppingCartItemEntry = shoppingCartItemRepository.findOne(event.getShoppingCartItemId().toString());
    	if (null!=shoppingCartItemEntry){
    		TenantContext.setCurrentTenant(event.getTenantId());
    		shoppingCartItemRepository.delete(shoppingCartItemEntry);
    	}       
    }
    
    @EventHandler
    public void handleShoppingCartItemQuantityIncreasedEvent(ShoppingCartItemQuantityIncreasedEvent event) {
    	ShoppingCartItemEntry shoppingCartItemEntry = shoppingCartItemRepository.findOne(event.getShoppingCartItemId().toString());
    	if (null!=shoppingCartItemEntry){
    		TenantContext.setCurrentTenant(event.getTenantId());
    		shoppingCartItemEntry.setQuantity(event.getNewQuantity());
    		shoppingCartItemEntry.setPrice(event.getPrice());
    		shoppingCartItemRepository.save(shoppingCartItemEntry);
    	}
    }
    
    @EventHandler
    public void handleShoppingCartItemQuantityDecreasedEvent(ShoppingCartItemQuantityDecreasedEvent event) {
    	ShoppingCartItemEntry shoppingCartItemEntry = shoppingCartItemRepository.findOne(event.getShoppingCartItemId().toString());
    	if (null!=shoppingCartItemEntry){
    		TenantContext.setCurrentTenant(event.getTenantId());
    		shoppingCartItemEntry.setQuantity(event.getNewQuantity());
    		shoppingCartItemEntry.setPrice(event.getPrice());
    		shoppingCartItemRepository.save(shoppingCartItemEntry);
    	}
    }
    
    @EventHandler
    public void handleShoppingCartDeletedEvent(ShoppingCartDeletedEvent event) {
    	ShoppingCartEntry shoppingCartEntry = shoppingCartRepository.findOne(event.getShoppingCartId().toString());
        if (null!=shoppingCartEntry){
        	TenantContext.setCurrentTenant(event.getTenantId());
            shoppingCartRepository.delete(shoppingCartEntry);
        } 
    }
    
}
