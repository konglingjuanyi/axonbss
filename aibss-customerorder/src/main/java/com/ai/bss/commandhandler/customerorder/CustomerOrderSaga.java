package com.ai.bss.commandhandler.customerorder;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.saga.annotation.AbstractAnnotatedSaga;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.bss.api.customerorder.CustomerOrderId;
import com.ai.bss.api.customerorder.CustomerOrderItemId;

public abstract class CustomerOrderSaga extends AbstractAnnotatedSaga {
	private transient CommandBus commandBus;
	private CustomerOrderId customerOrderId;
	private int orderItemCount;
	private int orderItemCreatedCount;
	private int orderItemDeliveredCount;
	
	private boolean confirmed;
	private boolean paid;
	private boolean delivered;
	private boolean completed;
	private boolean goodsReturned;
	private boolean refunded;
	private boolean canceled;
	private boolean hasProducts;

	public CustomerOrderSaga() {
		// TODO Auto-generated constructor stub
	}

	public CustomerOrderSaga(String identifier) {
		super(identifier);
		// TODO Auto-generated constructor stub
	}
	

	public CommandBus getCommandBus() {
		return commandBus;
	}

	@Autowired
	public void setCommandBus(CommandBus commandBus) {
		this.commandBus = commandBus;
	}

	public CustomerOrderId getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(CustomerOrderId customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public int getOrderItemCount() {
		return orderItemCount;
	}

	public void setOrderItemCount(int orderItemCount) {
		this.orderItemCount = orderItemCount;
	}

	public int getOrderItemCreatedCount() {
		return orderItemCreatedCount;
	}

	public void setOrderItemCreatedCount(int orderItemCreatedCount) {
		this.orderItemCreatedCount = orderItemCreatedCount;
	}

	public int getOrderItemDeliveredCount() {
		return orderItemDeliveredCount;
	}

	public void setOrderItemDeliveredCount(int orderItemDeliveredCount) {
		this.orderItemDeliveredCount = orderItemDeliveredCount;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public boolean isGoodsReturned() {
		return goodsReturned;
	}

	public void setGoodsReturned(boolean goodsReturned) {
		this.goodsReturned = goodsReturned;
	}

	public boolean isRefunded() {
		return refunded;
	}

	public void setRefunded(boolean refunded) {
		this.refunded = refunded;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	public boolean isHasProducts() {
		return hasProducts;
	}

	public void setHasProducts(boolean hasProducts) {
		this.hasProducts = hasProducts;
	}

}
