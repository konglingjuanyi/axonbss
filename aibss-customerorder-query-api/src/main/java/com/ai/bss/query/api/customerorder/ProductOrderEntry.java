package com.ai.bss.query.api.customerorder;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;

import com.ai.bss.query.api.product.AbstractProduct;
import com.ai.bss.query.api.product.AbstractProductCharacterValue;
import com.ai.bss.query.api.product.AbstractProductSuspendReason;
@Entity
public class ProductOrderEntry extends AbstractProduct {
	private String action;
	private String state;
	Set<ProductOrderEntry> activationDependOns = new LinkedHashSet<>();//activation after beDependOns activation.
	Set<ProductOrderEntry> activationBeDependOns = new LinkedHashSet<>();//activation first then DependOns activation.
	Set<ProductOrderEntry> activationDependOnDeliveries = new LinkedHashSet<>();//activation after beDependOns delivery.
	Set<ProductOrderEntry> activationBeDependOnDeliveries = new LinkedHashSet<>();//delivery first then DependOns activation.
	public ProductOrderEntry() {
	}
	
	private long asisVersion;
	
	//updated after archived
	private long tobeVersion;
	
	public long getAsisVersion() {
		return asisVersion;
	}

	public void setAsisVersion(long asisVersion) {
		this.asisVersion = asisVersion;
	}

	public long getTobeVersion() {
		return tobeVersion;
	}

	public void setTobeVersion(long tobeVersion) {
		this.tobeVersion = tobeVersion;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public  Set<ProductOrderCharacterValueEntry> getProductOrderCharacterValues(){
		Set<ProductOrderCharacterValueEntry> retValues=new LinkedHashSet<>();
		Set<AbstractProductCharacterValue> charValues=super.getCharacterValues();
		for (AbstractProductCharacterValue characterValue : charValues) {
			retValues.add((ProductOrderCharacterValueEntry)characterValue);
		}
		return retValues;
	}
	
	public  Set<ProductOrderSuspendReasonEntry> getProductOrderSuspendReasons(){
		Set<ProductOrderSuspendReasonEntry> retValues=new LinkedHashSet<>();
		Set<AbstractProductSuspendReason> suspValues=super.getSuspendReasons();
		for (AbstractProductSuspendReason supsValue : suspValues) {
			retValues.add((ProductOrderSuspendReasonEntry)supsValue);
		}
		return retValues;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set<ProductOrderEntry> getActivationDependOns() {
		return activationDependOns;
	}
	
	public void addActivationDependOn(ProductOrderEntry productOrder){
		if (!activationDependOns.contains(productOrder)){
			activationDependOns.add(productOrder);
		}
	}

	public Set<ProductOrderEntry> getActivationBeDependOns() {
		return activationBeDependOns;
	}
	
	public void addActivationBeDependOn(ProductOrderEntry productOrder){
		if (!activationBeDependOns.contains(productOrder)){
			activationBeDependOns.add(productOrder);
		}
	}

	public Set<ProductOrderEntry> getActivationDependOnDeliveries() {
		return activationDependOnDeliveries;
	}
	
	public void addActivationDependOnDelivery(ProductOrderEntry productOrder){
		if (!activationDependOnDeliveries.contains(productOrder)){
			activationDependOnDeliveries.add(productOrder);
		}
	}

	public Set<ProductOrderEntry> getActivationBeDependOnDeliveries() {
		return activationBeDependOnDeliveries;
	}
	
	public void addActivationBeDependOnDelivery(ProductOrderEntry productOrder){
		if (!activationBeDependOnDeliveries.contains(productOrder)){
			activationBeDependOnDeliveries.add(productOrder);
		}
	}
}
