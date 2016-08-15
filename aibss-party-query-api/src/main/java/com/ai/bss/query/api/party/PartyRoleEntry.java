package com.ai.bss.query.api.party;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Table(name="PT_PARTY_ROLE")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PARTY_ROLE_TYPE",discriminatorType=DiscriminatorType.STRING)
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public abstract class PartyRoleEntry {
	@Id
	private String partyRoleId;	
	@Version
    private long version;
	
	public PartyRoleEntry(){}
	
	
	@Column(insertable = false, updatable = false,name="PARTY_ROLE_TYPE")
	String partyRoleType;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="PARTY_ID")
	private PartyEntry party;		
		
	public String getPartyRoleType() {
		return partyRoleType;
	}

	public void setPartyRoleType(String partyRoleType) {
		this.partyRoleType = partyRoleType;
	}

	
	public PartyRoleEntry(String partyRoleId,PartyEntry party){
		this.partyRoleId=partyRoleId;
		this.party=(PartyEntry)party;
	}
	
	public PartyEntry getParty() {		
		return party;
	}

	public void setParty(PartyEntry party) {
		this.party =(PartyEntry) party;
	}

	public String getPartyRoleId() {
		return partyRoleId;
	}

	public void setPartyRoleId(String partyRoleId) {
		this.partyRoleId = partyRoleId;
	}

}
