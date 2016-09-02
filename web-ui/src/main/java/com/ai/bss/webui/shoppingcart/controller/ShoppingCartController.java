package com.ai.bss.webui.shoppingcart.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ai.bss.api.base.CharacteristicValue;
import com.ai.bss.api.product.dto.ProductCharacteristicValue;
import com.ai.bss.api.shoppingcart.ShoppingCartId;
import com.ai.bss.api.shoppingcart.ShoppingCartItemId;
import com.ai.bss.api.shoppingcart.command.AddShoppingCartItemCommand;
import com.ai.bss.api.shoppingcart.command.CreateShoppingCartCommand;
import com.ai.bss.api.shoppingcart.command.DecreaseShoppingCartItemQuantityCommand;
import com.ai.bss.api.shoppingcart.command.DeleteShoppingCartItemCommand;
import com.ai.bss.api.shoppingcart.command.IncreaseShoppingCartItemQuantityCommand;
import com.ai.bss.mutitanent.TenantContext;
import com.ai.bss.query.api.shoppingcart.ShoppingCartEntry;
import com.ai.bss.webui.productsale.model.OfferDetail;
import com.ai.bss.webui.shoppingcart.model.ShoppingCartItem;
import com.ai.bss.webui.util.BaseController;
/**
 * @author Lianhua Zhang
 */
@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController extends BaseController{

	public ShoppingCartController() {
	}
	@RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public String details(@PathVariable String customerId,BindingResult bindingResult,Model model) {
		ShoppingCartEntry shoppingCart = client.getForObject("http://shoppingcart-query-service/shoppingcart/customerId/"+customerId,ShoppingCartEntry.class);
		if (null==shoppingCart){
			//set shoppingCartId same as customerID
			ShoppingCartId shoppingCartId=new ShoppingCartId(customerId);
    		CreateShoppingCartCommand command =new CreateShoppingCartCommand();
    		command.setCustomerId(customerId);
    		command.setShoppingCartId(shoppingCartId);
    		command.setTenantId(TenantContext.getCurrentTenant());  		
    		command=client.postForObject("http://shoppingcart-service/shoppingcart/CreateShoppingCartCommand",command,CreateShoppingCartCommand.class);    			
    		return "redirect:/shoppingcart/"+customerId;
		}
		model.addAttribute("items",shoppingCart.getItems());
		return "/shoppingcart/list";
	}
		
	@RequestMapping(value = "/offerDetail/{customerId}/{offerId}", method = RequestMethod.GET)
    public String addToCart(@PathVariable String customerId,@PathVariable String offerId,Model model) {
		OfferDetail offerDetail=new OfferDetail();
		offerDetail.setOfferingId(offerId);
		offerDetail.setName("iphone 6S");
		//TODO to be removed, test only
		ProductCharacteristicValue productCharacterValue = new ProductCharacteristicValue();
		productCharacterValue.setCharacteristicSpecId("1001");
		productCharacterValue.setCharacteristicSpecName("Color");
		productCharacterValue.setValueSpecId("10002");
		productCharacterValue.setValue("Gold");
		offerDetail.addProductCharacterValue(productCharacterValue);
		offerDetail.setPrice(1000);
		//TODO query offer detail from upc		
		ShoppingCartItem cartItem = new ShoppingCartItem();
		cartItem.setOfferDetail(offerDetail);
		cartItem.setShoppingCartId(customerId);
		cartItem.setQuantity(1);
		long price=offerDetail.getPrice()*cartItem.getQuantity();
		cartItem.setPrice(price);
        model.addAttribute("cartItem", cartItem);
        return "shoppingcart/offerDetail";
    }
	
	@RequestMapping(value = "/addToCart/{customerId}", method = RequestMethod.POST)
    public String addToCart(@PathVariable String customerId,@ModelAttribute("shoppingCartItem") @Valid ShoppingCartItem shoppingCartItem, BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) {
    		ShoppingCartItemId shopingCartItemId=new ShoppingCartItemId();
    		AddShoppingCartItemCommand command =new AddShoppingCartItemCommand();
    		command.setShoppingCartId(new ShoppingCartId(customerId));
    		command.setShopingCartItemId(shopingCartItemId);
    		command.setOfferingId(shoppingCartItem.getOfferDetail().getOfferingId());
    		command.setOfferingUnitPrice(shoppingCartItem.getOfferDetail().getPrice());
    		command.setQuantity(shoppingCartItem.getQuantity());
    		command.setPrice(shoppingCartItem.getPrice());
    		Set<CharacteristicValue> offerCharValues=shoppingCartItem.getOfferDetail().getOfferCharacterValues();
    		if (null!=offerCharValues&&offerCharValues.size()>0){
    			command.setOfferCharacterValues(offerCharValues);
    		}
    		Set<ProductCharacteristicValue> productChars=shoppingCartItem.getOfferDetail().getProductCharacterValues();
    		if (null!=productChars&&productChars.size()>0){
    			command.setProductCharacterValues(productChars);
    		}
    		command.setTenantId(TenantContext.getCurrentTenant());  		
    		try {
    			command=client.postForObject("http://shoppingcart-service/shoppingcart/AddShoppingCartItemCommand",command,AddShoppingCartItemCommand.class);
			} catch (Exception e) {
				bindingResult.rejectValue("offerId",
                        "error.addToCart.failed",
                        e.getCause().getMessage());
			}
    	}
    	return "/shoppingcart/list";
    }
	
	@RequestMapping(value = "/deleteCartItem", method = RequestMethod.POST)
    public String deleteCartItem(@ModelAttribute("ShoppingCartItem") @Valid ShoppingCartItem shoppingCartItem, BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) {
    		ShoppingCartItemId shopingCartItemId=new ShoppingCartItemId();
    		DeleteShoppingCartItemCommand command =new DeleteShoppingCartItemCommand();
    		command.setShoppingCartId(new ShoppingCartId(shoppingCartItem.getShoppingCartId()));
    		command.setShopingCartItemId(shopingCartItemId);
    		command.setTenantId(TenantContext.getCurrentTenant());  		
    		try {
    			command=client.postForObject("http://shoppingcart-service/shoppingcart/DeleteShoppingCartItemCommand",command,DeleteShoppingCartItemCommand.class);
			} catch (Exception e) {
				bindingResult.rejectValue("offerId",
                        "error.addToCart.failed",
                        e.getCause().getMessage());
			}
    	}
    	return "/shoppingcart/list";
    }
	
	@RequestMapping(value = "/increase", method = RequestMethod.POST)
    public String increase(@ModelAttribute("ShoppingCartItem") @Valid ShoppingCartItem shoppingCartItem, BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) {
    		ShoppingCartItemId shopingCartItemId=new ShoppingCartItemId();
    		IncreaseShoppingCartItemQuantityCommand command =new IncreaseShoppingCartItemQuantityCommand();
    		command.setShoppingCartId(new ShoppingCartId(shoppingCartItem.getShoppingCartId()));
    		command.setShopingCartItemId(shopingCartItemId);
    		command.setNewQuantity(shoppingCartItem.getQuantity()+1);
    		command.setPrice(shoppingCartItem.getOfferDetail().getPrice()*command.getNewQuantity());
    		command.setTenantId(TenantContext.getCurrentTenant());  		
    		try {
    			command=client.postForObject("http://shoppingcart-service/shoppingcart/DeleteShoppingCartItemCommand",command,IncreaseShoppingCartItemQuantityCommand.class);
			} catch (Exception e) {
				bindingResult.rejectValue("offerId",
                        "error.addToCart.failed",
                        e.getCause().getMessage());
			}
    	}
    	return "/shoppingcart/list";
    }
	
	@RequestMapping(value = "/decrease", method = RequestMethod.POST)
    public String decrease(@ModelAttribute("ShoppingCartItem") @Valid ShoppingCartItem shoppingCartItem, BindingResult bindingResult, Model model) {
    	if (!bindingResult.hasErrors()) {
    		if (shoppingCartItem.getQuantity()-1<=0){
    			bindingResult.rejectValue("quantity",
                        "error.quantity.failed",
                        "quantity must more than 1");
    		}else{
	    		ShoppingCartItemId shopingCartItemId=new ShoppingCartItemId();
	    		DecreaseShoppingCartItemQuantityCommand command =new DecreaseShoppingCartItemQuantityCommand();
	    		command.setShoppingCartId(new ShoppingCartId(shoppingCartItem.getShoppingCartId()));
	    		command.setShopingCartItemId(shopingCartItemId);
	    		command.setNewQuantity(shoppingCartItem.getQuantity()-1);
	    		command.setPrice(shoppingCartItem.getOfferDetail().getPrice()*command.getNewQuantity());
	    		command.setTenantId(TenantContext.getCurrentTenant());  		
	    		try {
	    			command=client.postForObject("http://shoppingcart-service/shoppingcart/DeleteShoppingCartItemCommand",command,DecreaseShoppingCartItemQuantityCommand.class);
				} catch (Exception e) {
					bindingResult.rejectValue("offerId",
	                        "error.addToCart.failed",
	                        e.getCause().getMessage());
				}
    		}
    	}
    	return "/shoppingcart/list";
    }
	
}
