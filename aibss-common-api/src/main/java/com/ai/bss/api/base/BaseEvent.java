package com.ai.bss.api.base;

import java.io.Serializable;

public class BaseEvent  implements Serializable{
	private String tenantId;
	public BaseEvent() {
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}
