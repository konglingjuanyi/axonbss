package com.ai.bss.intergration.ri.customerorder.listerner;

import java.util.Set;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.ai.bss.api.customerorder.event.OrderPaidEvent;
import com.ai.bss.api.delivery.event.ProductOrderDeliveredEvent;
import com.ai.bss.intergration.ri.customerorder.util.IProductOrderUtil;
import com.ai.bss.query.api.customerorder.CustomerOrderEntry;
import com.ai.bss.query.api.customerorder.OfferOrderEntry;
import com.ai.bss.query.api.customerorder.OfferOrderProductRelEntry;
import com.ai.bss.query.api.customerorder.OrderItemEntry;
import com.ai.bss.query.api.customerorder.ProductOrderEntry;
import com.ai.bss.query.api.productspecification.ProductSpecificationEntry;

public class DeliveryListener {
	@Autowired
	public RestTemplate client;
	@Autowired
	private IProductOrderUtil productOrderUtil;

	public DeliveryListener() {
		
	}
	
	@EventHandler
	public void onOrderPaid(OrderPaidEvent event) throws Exception{
		CustomerOrderEntry customerOrder=client.getForObject("http://customerorder-query-service/customerorder/customerOrderId/"+event.getCustomerOrderId(),CustomerOrderEntry.class);
		Set<OrderItemEntry> orderItems=customerOrder.getOrderItems();
		if(orderItems.size()>0){
			for (OrderItemEntry orderItemEntry : orderItems) {
				OfferOrderEntry offerOrder=orderItemEntry.getItemOffer();
				Set<OfferOrderProductRelEntry> offerProducts=offerOrder.getRelProducts();
				if (!offerProducts.isEmpty()){
					for (OfferOrderProductRelEntry orderItemOfferProductRel : offerProducts) {
						ProductOrderEntry productOrder=(ProductOrderEntry)orderItemOfferProductRel.getProduct();
						ProductSpecificationEntry productSpec=client.getForObject("http://productspecification-query-service/productspecification/productspecificationId/"+productOrder.getProductSpecificationId(),ProductSpecificationEntry.class);
						productOrderUtil.deliveryProductOrder(orderItemEntry, productOrder,productSpec.getCode());
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onProductOrderDelivered(ProductOrderDeliveredEvent event) throws Exception{
		String productOrderId = event.getProductOrderId();
		ProductOrderEntry productOrder= client.getForObject("http://customerorder-query-service/customerorder/productOrder/productOrderId/"+productOrderId,ProductOrderEntry.class);
		if (null!=productOrder){
			Set<ProductOrderEntry> beDependOnDeliveries = productOrder.getActivationBeDependOnDeliveries();
			//after delivered, to activate be depended on product orders
			for (ProductOrderEntry beDependProductOrder : beDependOnDeliveries) {				
				OrderItemEntry orderItem=client.getForObject("http://customerorder-query-service/customerorder/productOrder/purchaseOffer/productOrderId/"+beDependProductOrder.getId(),OrderItemEntry.class);
				ProductSpecificationEntry productSpec=client.getForObject("http://productspecification-query-service/productspecification/productspecificationId/"+beDependProductOrder.getProductSpecificationId(),ProductSpecificationEntry.class);
				productOrderUtil.deliveryProductOrder(orderItem, beDependProductOrder,productSpec.getCode());
			}
		}
	}
}
