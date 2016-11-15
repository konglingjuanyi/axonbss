package com.ai.bss.intergration.ri.customerorder.util;

import org.hibernate.loader.plan.build.internal.AbstractLoadPlanBuildingAssociationVisitationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ai.bss.api.activation.command.AbstractActivateProductCommand;
import com.ai.bss.api.activation.command.ActivateProductCommand;
import com.ai.bss.api.activation.command.DeactivateProductCommand;
import com.ai.bss.query.api.customerorder.OrderItemActionEnum;
import com.ai.bss.query.api.customerorder.OfferOrderProductRelEntry;
import com.ai.bss.query.api.customerorder.ProductOrderEntry;
import com.ai.bss.query.api.productspecification.ProductSpecificationEntry;
import com.ai.bss.query.api.productspecification.ProductSpecificationTypeEnum;

@Component
public class ProductOrderUtil {
	@Autowired
	public RestTemplate client;
	public ProductOrderUtil() {
		
	}

	public boolean needActivation(OfferOrderProductRelEntry orderItemOfferProductRel) throws Exception{
		boolean retValue=false;
		ProductOrderEntry orderProduct=(ProductOrderEntry)orderItemOfferProductRel.getProduct();
		ProductSpecificationEntry productSpec=client.getForObject("http://productspecification-query-service/productSpecification/productSpecificationId/"+orderProduct.getProductSpecificationId(),ProductSpecificationEntry.class);
		if (productSpec.getType().equalsIgnoreCase(ProductSpecificationTypeEnum.NetWork.name())){
			//是否要等待物流？配置在哪里？
			retValue=true;
		}
		return retValue;
	}
	
	public AbstractActivateProductCommand getActivateCommand(OfferOrderProductRelEntry orderItemOfferProductRel){
		AbstractActivateProductCommand command=null;
		ProductOrderEntry orderProduct=(ProductOrderEntry)orderItemOfferProductRel.getProduct();		
		if(orderProduct.getAction().equalsIgnoreCase(OrderItemActionEnum.Create.name())){
			command=new ActivateProductCommand();
		}else if (orderProduct.getAction().equalsIgnoreCase(OrderItemActionEnum.Delete.name())){
			command=new DeactivateProductCommand();
		}else if (orderProduct.getAction().equalsIgnoreCase(OrderItemActionEnum.Update.name())){
			command=new DeactivateProductCommand();
		}
		return command;
	}
	
	public boolean needDelivery(OfferOrderProductRelEntry orderItemOfferProductRel) throws Exception{
		boolean retValue=false;
		ProductOrderEntry orderProduct=(ProductOrderEntry)orderItemOfferProductRel.getProduct();
		ProductSpecificationEntry productSpec=client.getForObject("http://productspecification-query-service/productSpecification/productSpecificationId/"+orderProduct.getProductSpecificationId(),ProductSpecificationEntry.class);
		if (productSpec.getType().equalsIgnoreCase(ProductSpecificationTypeEnum.RealObject.name())){
			retValue=true;
		}
		return retValue;
	}
}
