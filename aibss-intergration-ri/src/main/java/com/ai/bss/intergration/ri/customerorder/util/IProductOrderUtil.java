package com.ai.bss.intergration.ri.customerorder.util;

import com.ai.bss.api.activation.command.AbstractActivateProductCommand;
import com.ai.bss.query.api.customerorder.OfferOrderProductRelEntry;

public interface IProductOrderUtil {
	public boolean needActivation(OfferOrderProductRelEntry orderItemOfferProductRel) throws Exception;
	public boolean needDelivery(OfferOrderProductRelEntry orderItemOfferProductRel) throws Exception;
	public AbstractActivateProductCommand getActivateCommand(OfferOrderProductRelEntry orderItemOfferProductRel);
}
