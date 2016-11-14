package com.ai.bss.intergration.ri.helper;

import com.ai.bss.query.api.productspecification.ProductSpecificationEntry;
import com.ai.bss.query.api.productspecification.ProductSpecificationTypeEnum;

public class ProductSpecificationHelper {

	public ProductSpecificationHelper() {
		
	}

	public static boolean needActivation(ProductSpecificationEntry productSpecification){
		boolean retValue=false;
		if (productSpecification.getType().equalsIgnoreCase(ProductSpecificationTypeEnum.NetWork.name())){
			retValue=true;
		}
		return retValue;
	}
}
