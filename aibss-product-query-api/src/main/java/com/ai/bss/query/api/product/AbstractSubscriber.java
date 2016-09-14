package com.ai.bss.query.api.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractSubscriber {
	private long customerId;
	private long productLineId;
	private String accessNumber;
		
	@Id
	private String id;	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	


	public AbstractSubscriber() {
	}
	
	public long getCustomerId() {
		return customerId;
	}

	
	public void setCustomerId(long customerId) {
		this.customerId=customerId;		
	}

	
	public long getProductLineId() {
		return productLineId;
	}

	
	public void setProductLineId(long productLineId) {
		this.productLineId=productLineId;
	}

	
	public String getAccessNumber() {
		return this.accessNumber;
	}

	
	public void setAccessNumber(String serialNumber) {
		this.accessNumber=serialNumber;
	}
}
