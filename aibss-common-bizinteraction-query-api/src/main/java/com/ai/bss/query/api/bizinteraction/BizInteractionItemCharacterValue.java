package com.ai.bss.query.api.bizinteraction;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ai.bss.api.base.CharacteristicValue;
@Entity
@Table(name="BII_CHARACTER_VALUE")
public class BizInteractionItemCharacterValue extends CharacteristicValue{
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="BIZ_INTERACTION_ITEM_CHAR_ID")
	private BizInteractionItem bizInteractionItem;
	public BizInteractionItemCharacterValue() {
	}

	public BizInteractionItem getBizInteractionItem() {
		return bizInteractionItem;
	}

	public void setBizInteractionItem(BizInteractionItem bizInteractionItem) {
		this.bizInteractionItem = bizInteractionItem;
	}

}
