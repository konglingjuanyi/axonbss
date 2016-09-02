package com.ai.bss.api.shoppingcart.command;

public class DecreaseShoppingCartItemQuantityCommand extends AbstractShoppingCartItemCommand {
	private int newQuantity;
	private long price;
	public DecreaseShoppingCartItemQuantityCommand() {
		// TODO Auto-generated constructor stub
	}
	public int getNewQuantity() {
		return newQuantity;
	}
	public void setNewQuantity(int newQuantity) {
		this.newQuantity = newQuantity;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}

}
