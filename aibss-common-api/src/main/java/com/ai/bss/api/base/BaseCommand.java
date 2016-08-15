package com.ai.bss.api.base;

import java.io.Serializable;

import org.axonframework.commandhandling.callbacks.FutureCallback;

public class BaseCommand  implements Serializable{
	private String tenantId;
	private FutureCallback callback;
	public BaseCommand() {
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public FutureCallback getCallback() {
		return callback;
	}

	public void setCallback(FutureCallback callback) {
		this.callback = callback;
	}
}
