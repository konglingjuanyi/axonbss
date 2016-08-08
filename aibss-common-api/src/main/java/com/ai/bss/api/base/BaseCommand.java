package com.ai.bss.api.base;

import java.io.Serializable;

public class BaseCommand  implements Serializable{
	private String tenantId;
	public BaseCommand() {
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}
