package com.ai.bss.query.api.party;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@DiscriminatorValue("ORGANIZATION")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@SecondaryTable(
	    name = "PT_ORGANIZATION",
	    pkJoinColumns = @PrimaryKeyJoinColumn(name = "ORGANIZATION_ID")
)
public abstract class OrganizationEntry extends PartyEntry {
	private String tradingName;

	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="PARENT_ORGANIZATION_ID")
	private OrganizationEntry parentOrganization;
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="parentOrganization")
	private Set<OrganizationEntry> childOrganizations=new LinkedHashSet<OrganizationEntry>(); 
	
	
	protected OrganizationEntry(){
		
	}
	
	public OrganizationEntry(String partyId,String name,String type){
		super(partyId,type);
		this.setTradingName(name);
	}



	protected String getTradingName() {
		return tradingName;
	}

	protected void setTradingName(String tradingName) {
		super.setName(tradingName);
		this.tradingName = tradingName;
	}	

	public OrganizationEntry getParentOrganization() {
		return parentOrganization;
	}

	public void setParentOrganization(OrganizationEntry parentOrganization) {
		this.parentOrganization = parentOrganization;
	}
	
	protected Set<OrganizationEntry> getChildOrganizations() {
		return childOrganizations;
	}
	protected void addChildOrganization(OrganizationEntry childOrganization) {
		this.childOrganizations.add(childOrganization);
	}

	@Override
	public String getName() {
		return this.getTradingName();
	}
}
