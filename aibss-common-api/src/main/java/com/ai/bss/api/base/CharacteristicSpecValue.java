package com.ai.bss.api.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="RT_CHARACTER_VALUE")
public class CharacteristicSpecValue{
	@Id
	private String id;
	@ManyToOne
	@JoinColumn(name="CHARACTER_SPEC_ID")
	private CharacteristicSpec characteristic;
	@Column
	private String value;
	@Column
	private String displayValue;
	@Column
	private boolean isDefault;
	@Column
	private long valueFrom;
	@Column
	private String code;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public long getValueFrom() {
		return valueFrom;
	}

	public void setValueFrom(long valueFrom) {
		this.valueFrom = valueFrom;
	}

	public long getValueTo() {
		return valueTo;
	}

	public void setValueTo(long valueTo) {
		this.valueTo = valueTo;
	}

	public long getRangeInterval() {
		return rangeInterval;
	}

	public void setRangeInterval(long rangeInterval) {
		this.rangeInterval = rangeInterval;
	}

	private long valueTo;
	   private long rangeInterval;	
	
	public CharacteristicSpec getCharacteristic() {
		return this.characteristic;
	}

	
	public void setCharacteristic(CharacteristicSpec characteristic) {
		this.characteristic=characteristic;
	}

	
	public String getCode() {
		return this.code;
	}

	
	public void setCode(String code) {
		this.code=code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
