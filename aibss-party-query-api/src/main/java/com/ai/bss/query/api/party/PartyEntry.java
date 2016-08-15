/*
 * Copyright (c) 2010-2012. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ai.bss.query.api.party;
import java.util.Set;

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

/**
 * @author Lianhua Zhang
 */
@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PARTY_TYPE",discriminatorType=DiscriminatorType.STRING)
@Table(name="PT_PARTY")
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public abstract class PartyEntry {

    @Id
    @Column(name="PARTY_ID")
    private String partyId;
    private String name;
    private String type;
    private String state ;
    
    @OneToMany(fetch=FetchType.LAZY,mappedBy="party")
	private Set<PartyRoleEntry> partyRoles; 
    
    public PartyEntry(){}
    
    protected PartyEntry(String identifier,String type){
    	this.partyId=identifier;
    	this.type=type;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String identifier) {
        this.partyId = identifier;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Set<PartyRoleEntry> getPartyRoles() {
		return partyRoles;
	}
	public void addPartyRole(PartyRoleEntry partyRole) {
		this.partyRoles.add(partyRole);
	}
}
