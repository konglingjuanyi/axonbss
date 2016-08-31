package com.ai.bss.query.api.bizinteraction;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="BIZ_SPEC_ID",discriminatorType=DiscriminatorType.STRING)
@Table(name="BIZ_INTERACTION")
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
@Access(AccessType.FIELD) 
public class BizInteraction {
	@Id
	private long id;
	
	@Column(name="STATE")
	private int state;
	
	@OneToMany(mappedBy="bizInteraction",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<BizInteractionItem> bizInteractionItems=new LinkedHashSet<BizInteractionItem>();
	
	@Column(name="BI_SPEC_ID")
	private String biSpecId;
	
	@Column(name="BI_CODE")
	private String code;
	
	@OneToMany(mappedBy="bizInteraction",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<BizInteractionCharacterValue> characterValues=new LinkedHashSet<BizInteractionCharacterValue>();
	
	protected BizInteraction(){
		
	}
	
	public  Set<BizInteractionCharacterValue> getCharacteristicValues(){
		return characterValues;
	}
	
	public void addCharacteristicValue(BizInteractionCharacterValue characterValue){
		if(null!=characterValue){
			this.characterValues.add(characterValue);
		}
	}

	protected int getState() {
		return this.state;
	}

	protected void setState(int state) {
		this.state=state;
	}
	
	
	public Set<BizInteractionItem> getItems() {
		return this.bizInteractionItems;
	}

	public void addItem(BizInteractionItem bii) {
		if (null!=bii){
			bizInteractionItems.add(bii);
			if(null==bii.getBizInteraction()){
				bii.setBizInteraction(this);
			}			
		}

	}
	
	public String getBusinessInteractionSpecId(){
		return this.biSpecId;
	}

	protected String getCode() {
		return code;
	}

	protected void setCode(String code) {
		this.code = code;
	}

	protected long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}
}
