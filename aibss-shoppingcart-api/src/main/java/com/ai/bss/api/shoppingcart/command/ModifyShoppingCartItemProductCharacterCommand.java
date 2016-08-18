package com.ai.bss.api.shoppingcart.command;

public class ModifyShoppingCartItemProductCharacterCommand extends ShoppingCartItemCommand {
	private String productSpecId;
	private String productCharacterSpecId;
	private String characterValueSpecId;
	private String value;
	public ModifyShoppingCartItemProductCharacterCommand() {
		// TODO Auto-generated constructor stub
	}
	public String getProductSpecId() {
		return productSpecId;
	}
	public void setProductSpecId(String productSpecId) {
		this.productSpecId = productSpecId;
	}
	public String getProductCharacterSpecId() {
		return productCharacterSpecId;
	}
	public void setProductCharacterSpecId(String productCharacterSpecId) {
		this.productCharacterSpecId = productCharacterSpecId;
	}
	public String getCharacterValueSpecId() {
		return characterValueSpecId;
	}
	public void setCharacterValueSpecId(String characterValueSpecId) {
		this.characterValueSpecId = characterValueSpecId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
