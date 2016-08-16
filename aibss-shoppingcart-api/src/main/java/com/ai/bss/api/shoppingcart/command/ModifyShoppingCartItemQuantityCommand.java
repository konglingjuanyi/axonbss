package com.ai.bss.api.shoppingcart.command;

public class ModifyShoppingCartItemQuantityCommand extends ShoppingCartCommand {
	private int newQuantity;
	public ModifyShoppingCartItemQuantityCommand() {
		// TODO Auto-generated constructor stub
	}
	public int getNewQuantity() {
		return newQuantity;
	}
	public void setNewQuantity(int newQuantity) {
		this.newQuantity = newQuantity;
	}

}
