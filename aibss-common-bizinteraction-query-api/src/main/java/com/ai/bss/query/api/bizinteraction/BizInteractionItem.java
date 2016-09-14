package com.ai.bss.query.api.bizinteraction;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="BIZ_ITEM_SPEC_ID",discriminatorType=DiscriminatorType.STRING)
@Table(name="BIZ_INTERACTION_ITEM")
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public class BizInteractionItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="BII_SPEC_ID")
	private long BizInteractionItemSpecId;
	
	@Column(name="BII_STATE")
	private int state;
	
	private String commandName;	
	
	@ManyToOne
	@JoinColumn(name="BIZ_INTERACTION_ID")
	private BizInteraction bizInteraction;
	
	@OneToMany(mappedBy="bizInteractionItem",cascade=CascadeType.ALL,fetch=FetchType.LAZY)	
	private Set<BizInteractionItemCharacterValue> characterValues=new LinkedHashSet<BizInteractionItemCharacterValue>();
	
	public  Set<BizInteractionItemCharacterValue> getCharacteristicValues(){
		return characterValues;
	}
	
	
	public void addCharacteristicValue(BizInteractionItemCharacterValue characterValue){
		if(null!=characterValue){
			this.characterValues.add(characterValue);
		}
	}
	
	
	protected BizInteractionItem(){
	}
	
	public BizInteractionItem(BizInteraction bi) {
		this.setBizInteraction(bi);
	}	

	
	public long getBizInteractionItemSpecId() {
		return BizInteractionItemSpecId;
	}

	
	public void setBizInteractionItemSpecId(long biiSpecId) {	
		this.BizInteractionItemSpecId=biiSpecId;
	}
	

	protected int getState() {
		return state;
	}

	protected void setState(int state) {
		this.state=state;

	}

	
	public BizInteraction getBizInteraction() {
		return bizInteraction;
	}

	
	public void setBizInteraction(BizInteraction bi) {
		this.bizInteraction=bi;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommandName() {
		return commandName;
	}


	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
}
