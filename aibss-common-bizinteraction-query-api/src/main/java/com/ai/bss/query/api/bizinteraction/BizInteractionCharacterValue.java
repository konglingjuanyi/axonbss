package com.ai.bss.query.api.bizinteraction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ai.bss.api.base.CharacteristicValue;
@Entity
@Table(name="BI_CHARACTER_VALUE")
public class BizInteractionCharacterValue extends CharacteristicValue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	
	@ManyToOne
	private BizInteraction bizInteraction;
	
	public BizInteractionCharacterValue() {
	}

	public BizInteraction getBizInteraction() {
		return bizInteraction;
	}

	public void setBizInteraction(BizInteraction bizInteraction) {
		this.bizInteraction = bizInteraction;
	}

}
