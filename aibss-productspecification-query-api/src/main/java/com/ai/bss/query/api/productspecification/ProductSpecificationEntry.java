package com.ai.bss.query.api.productspecification;

import javax.persistence.Entity;

@Entity
public class ProductSpecificationEntry {
	private String productSpecificationId;
	private String code;
	private String type;
	private String version;
	public ProductSpecificationEntry() {
		
	}
	public String getProductSpecificationId() {
		return productSpecificationId;
	}
	public void setProductSpecificationId(String productSpecificationId) {
		this.productSpecificationId = productSpecificationId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

}
