package com.ai.bss.intergration.ri.customerorder.util;

import com.ai.bss.api.activation.command.AbstractActivateProductCommand;
import com.ai.bss.query.api.customerorder.OfferOrderProductRelEntry;
import com.ai.bss.query.api.customerorder.OrderItemEntry;

public interface IProductOrderUtil {
	public boolean needActivation(OfferOrderProductRelEntry orderItemOfferProductRel) throws Exception;
	public boolean needDelivery(OfferOrderProductRelEntry orderItemOfferProductRel) throws Exception;
	public AbstractActivateProductCommand getActivateCommand(OrderItemEntry orderItem,OfferOrderProductRelEntry orderItemOfferProductRel) throws Exception;
}
