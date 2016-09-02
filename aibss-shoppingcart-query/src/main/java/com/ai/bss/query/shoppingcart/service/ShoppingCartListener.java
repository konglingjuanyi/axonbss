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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.bss.api.base.CharacteristicValue;
import com.ai.bss.api.base.TimePeriod;
import com.ai.bss.api.product.OfferInstanceId;
import com.ai.bss.api.product.ProductId;
import com.ai.bss.api.product.dto.ProductCharacteristicValue;
import com.ai.bss.api.shoppingcart.ShoppingCartId;
import com.ai.bss.api.shoppingcart.event.ShoppingCartCreatedEvent;
import com.ai.bss.api.shoppingcart.event.ShoppingCartDeletedEvent;
import com.ai.bss.api.shoppingcart.event.ShoppingCartItemAddedEvent;
import com.ai.bss.api.shoppingcart.event.ShoppingCartItemDeletedEvent;
import com.ai.bss.api.shoppingcart.event.ShoppingCartItemProductCharacterModifiedEvent;
import com.ai.bss.api.shoppingcart.event.ShoppingCartItemQuantityDecreasedEvent;
import com.ai.bss.api.shoppingcart.event.ShoppingCartItemQuantityIncreasedEvent;
import com.ai.bss.mutitanent.TenantContext;
import com.ai.bss.query.api.product.AbstractOfferCharacterValue;
import com.ai.bss.query.api.product.AbstractProductCharacterValue;
import com.ai.bss.query.api.shoppingcart.ShoppingCartEntry;
import com.ai.bss.query.api.shoppingcart.CartItemEntry;
import com.ai.bss.query.api.shoppingcart.CartItemOfferCharacterValueEntry;
import com.ai.bss.query.api.shoppingcart.CartItemOfferEntry;
import com.ai.bss.query.api.shoppingcart.CartItemOfferProductRelEntry;
import com.ai.bss.query.api.shoppingcart.CartItemProductCharacterValueEntry;
import com.ai.bss.query.api.shoppingcart.CartItemProductEntry;
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
    public void handleShoppingCartItemAddedEvent(ShoppingCartItemAddedEvent event) throws Exception{
    	ShoppingCartEntry shoppingCartEntry = shoppingCartRepository.findOne(event.getShoppingCartId().toString());
        if (null!=shoppingCartEntry){
        	TenantContext.setCurrentTenant(event.getTenantId());
            CartItemEntry shoppingCartItemEntry=new CartItemEntry();
            CartItemOfferEntry offerInstance = new CartItemOfferEntry();
            OfferInstanceId offerInstanceId=new OfferInstanceId();
            offerInstance.setId(offerInstanceId.toString());
            shoppingCartItemEntry.setOfferInstance(offerInstance);
            offerInstance.setProductOfferingId(event.getOfferingId());
            offerInstance.setUnitPrice(event.getOfferingUnitPrice());
            Set<CharacteristicValue>  offerCharValues=event.getOfferCharacterValues();
            if (null!=offerCharValues&&offerCharValues.size()>0){
            	for (CharacteristicValue offerCharValue : offerCharValues) {
            		CartItemOfferCharacterValueEntry offerCharValueEntry=new CartItemOfferCharacterValueEntry();
            		offerCharValueEntry.setCharacteristicSpecId(offerCharValue.getCharacteristicSpecId());
            		offerCharValueEntry.setValueSpecId(offerCharValue.getValueSpecId());
            		offerCharValueEntry.setValue(offerCharValue.getValue());           		
            		offerInstance.addCharacterValue(offerCharValueEntry);
				}
            }
            Set<ProductCharacteristicValue>  productCharValues=event.getProductCharacterValues();
            if (null!=productCharValues&&productCharValues.size()>0){
            	Map<String, CartItemProductEntry> ProductEntryMap =new HashMap<>();
            	for (ProductCharacteristicValue productCharValue : productCharValues) {
            		String productSpecId=productCharValue.getCharacteristicSpecId();
            		if(null!=productSpecId){
            			CartItemProductEntry shoppingCartProduct=ProductEntryMap.get(productSpecId);
            			if (null==shoppingCartProduct){
            				shoppingCartProduct=new CartItemProductEntry();
            				ProductId productId=new ProductId();
            				shoppingCartProduct.setId(productId.toString());
            				shoppingCartProduct.setProductSpecificationId(productCharValue.getProductSpecId());
            				TimePeriod validPeriod=new TimePeriod();
            				validPeriod.setBeginTime(validPeriod.getCurrenttTime());
            				validPeriod.setEndTime(validPeriod.getForeverTime());
            				offerInstance.addProduct(shoppingCartProduct, validPeriod);
            				ProductEntryMap.put(productSpecId, shoppingCartProduct);            				
            			}
            			CartItemProductCharacterValueEntry productCharValueEntry=new CartItemProductCharacterValueEntry();
                		productCharValueEntry.setCharacteristicSpecId(productSpecId);
                		productCharValueEntry.setValueSpecId(productCharValue.getValueSpecId());
                		productCharValueEntry.setValue(productCharValue.getValue());           		
                		shoppingCartProduct.addCharacterValue(productCharValueEntry);
            		}            		
				}
            }            
            shoppingCartItemEntry.setId(event.getShoppingCartItemId().toString());
            shoppingCartItemEntry.setQuantity(event.getQuantity());
            shoppingCartItemEntry.setPrice(event.getPrice());
            shoppingCartEntry.addItem(shoppingCartItemEntry);
            shoppingCartRepository.save(shoppingCartEntry);
        }   	
    }
    
    @EventHandler
    public void handleShoppingCartItemDeletedEvent(ShoppingCartItemDeletedEvent event) {
    	CartItemEntry shoppingCartItemEntry = shoppingCartItemRepository.findOne(event.getShoppingCartItemId().toString());
    	if (null!=shoppingCartItemEntry){
    		TenantContext.setCurrentTenant(event.getTenantId());
    		shoppingCartItemRepository.delete(shoppingCartItemEntry);
    	}       
    }
    
    @EventHandler
    public void handleShoppingCartItemQuantityIncreasedEvent(ShoppingCartItemQuantityIncreasedEvent event) {
    	CartItemEntry shoppingCartItemEntry = shoppingCartItemRepository.findOne(event.getShoppingCartItemId().toString());
    	if (null!=shoppingCartItemEntry){
    		TenantContext.setCurrentTenant(event.getTenantId());
    		shoppingCartItemEntry.setQuantity(event.getNewQuantity());
    		shoppingCartItemEntry.setPrice(event.getPrice());
    		shoppingCartItemRepository.save(shoppingCartItemEntry);
    	}
    }
    
    @EventHandler
    public void handleShoppingCartItemQuantityDecreasedEvent(ShoppingCartItemQuantityDecreasedEvent event) {
    	CartItemEntry shoppingCartItemEntry = shoppingCartItemRepository.findOne(event.getShoppingCartItemId().toString());
    	if (null!=shoppingCartItemEntry){
    		TenantContext.setCurrentTenant(event.getTenantId());
    		shoppingCartItemEntry.setQuantity(event.getNewQuantity());
    		shoppingCartItemEntry.setPrice(event.getPrice());
    		shoppingCartItemRepository.save(shoppingCartItemEntry);
    	}
    }
    
    @EventHandler
    public void handleShoppingCartItemProductCharacterModifiedEvent(ShoppingCartItemProductCharacterModifiedEvent event) {
    	CartItemEntry shoppingCartItemEntry = shoppingCartItemRepository.findOne(event.getShoppingCartItemId().toString());
    	if (null!=shoppingCartItemEntry){
    		Set<CartItemOfferProductRelEntry> products=shoppingCartItemEntry.getOfferInstance().getRelProducts();
    		if (null!=products&&!products.isEmpty()){
    			for (CartItemOfferProductRelEntry productRel : products) {
    				Set<AbstractProductCharacterValue> productChars=productRel.getProduct().getCharacterValues();
    	    		for (AbstractProductCharacterValue productCharacterValue : productChars) {
    					if (productCharacterValue.getCharacteristicSpecId().equalsIgnoreCase(event.getProductCharacterSpecId())
    							&& productRel.getProduct().getProductSpecificationId().equalsIgnoreCase(event.getProductSpecId())
    							&& productCharacterValue.getValueSpecId().equalsIgnoreCase(event.getCharacterValueSpecId())){
    						productCharacterValue.setValue(event.getValue());
    						break;
    					}
    				}
				}
    		}
    		
    		TenantContext.setCurrentTenant(event.getTenantId());
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
