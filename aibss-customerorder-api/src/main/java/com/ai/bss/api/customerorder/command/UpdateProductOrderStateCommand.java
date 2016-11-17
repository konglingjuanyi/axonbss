package com.ai.bss.api.customerorder.command;

public class UpdateProductOrderStateCommand extends AbstractOrderItemCommand {
	private String productOrderId;
	private String state;
	public UpdateProductOrderStateCommand() {
		
	}
	public String getProductOrderId() {
		return productOrderId;
	}
	public void setProductOrderId(String productOrderId) {
		this.productOrderId = productOrderId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
