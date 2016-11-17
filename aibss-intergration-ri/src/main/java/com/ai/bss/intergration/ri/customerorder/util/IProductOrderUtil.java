package com.ai.bss.intergration.ri.customerorder.util;

import org.axonframework.commandhandling.callbacks.FutureCallback;

import com.ai.bss.api.activation.command.AbstractActivateProductCommand;
import com.ai.bss.query.api.customerorder.OfferOrderProductRelEntry;
import com.ai.bss.query.api.customerorder.OrderItemEntry;
import com.ai.bss.query.api.customerorder.ProductOrderEntry;

public interface IProductOrderUtil {
	public FutureCallback activateProductOrder(OrderItemEntry orderItem,ProductOrderEntry orderProduct, String productSpecCode) throws Exception;
	public boolean needActivation(ProductOrderEntry orderProduct, String productSpecCode) throws Exception;
	public boolean needDelivery(ProductOrderEntry orderProduct, String productSpecCode) throws Exception;
	public AbstractActivateProductCommand getActivateCommand(OrderItemEntry orderItem,ProductOrderEntry orderProduct) throws Exception;
	public FutureCallback deliveryProductOrder(OrderItemEntry orderItem,ProductOrderEntry orderProduct,String productSpecCode) throws Exception;
}
