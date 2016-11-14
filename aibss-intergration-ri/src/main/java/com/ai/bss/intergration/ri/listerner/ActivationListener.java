package com.ai.bss.intergration.ri.listerner;

import java.util.Set;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.ai.bss.api.customerorder.event.OrderPaidEvent;
import com.ai.bss.query.api.customerorder.CustomerOrderEntry;
import com.ai.bss.query.api.customerorder.OrderItemEntry;
import com.ai.bss.query.api.customerorder.OrderItemOfferEntry;
import com.ai.bss.query.api.customerorder.OrderItemOfferProductRelEntry;
import com.ai.bss.query.api.customerorder.OrderItemProductEntry;

public class ActivationListener {
	@Autowired
	public RestTemplate client;
	public ActivationListener() {
		
	}
	
	@EventHandler
	public void onOrderPaidEvent(OrderPaidEvent event){
		CustomerOrderEntry customerOrder=client.getForObject("http://customerorder-query-service/customerorder/customerOrderId/"+event.getCustomerOrderId(),CustomerOrderEntry.class);
		Set<OrderItemEntry> orderItems=customerOrder.getOrderItems();
		if(orderItems.size()>0){
			for (OrderItemEntry orderItemEntry : orderItems) {
				OrderItemOfferEntry offerOrder=orderItemEntry.getItemOffer();
				Set<OrderItemOfferProductRelEntry> offerProducts=offerOrder.getRelProducts();
				if (!offerProducts.isEmpty()){
					for (OrderItemOfferProductRelEntry orderItemOfferProductRelEntry : offerProducts) {
						OrderItemProductEntry orderProduct=(OrderItemProductEntry)orderItemOfferProductRelEntry.getProduct();
						
					}
				}
			}
		}
	}

}
