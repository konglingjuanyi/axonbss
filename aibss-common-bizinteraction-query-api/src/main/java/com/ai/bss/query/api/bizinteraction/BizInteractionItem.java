package com.ai.bss.query.api.bizinteraction;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class BizInteractionItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="BII_SPEC_ID")
	private long BizInteractionItemSpecId;
	
	@Column(name="BII_STATE")
	private int state;
	
	private int action;	
	
	@ManyToOne
	@JoinColumn(name="BIZ_INTERACTION_ID")
	private BizInteraction bizInteraction;
	
	@OneToMany(mappedBy="BizInteractionItem",cascade=CascadeType.ALL,fetch=FetchType.LAZY)	
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

	public int getAction() {
		return action;
	}


	public void setAction(int action) {
		this.action = action;
	}
}
