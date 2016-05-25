package com.ai.bss.query.party;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

@Entity
@DiscriminatorValue("ORGANIZATION")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@SecondaryTable(
	    name = "PT_ORGANIZATION",
	    pkJoinColumns = @PrimaryKeyJoinColumn(name = "ORGANIZATION_ID")
)
public abstract class OrganizationEntry extends PartyEntry {
	public OrganizationEntry(String partyId,String name,String type){
		super(partyId,name,type);
	}
	@Basic
	@Column(table="PT_ORGANIZATION",name="IS_LEGAL")
	private boolean isLegal;

	public boolean isLegal() {
		return isLegal;
	}

	public void setLegal(boolean isLegal) {
		this.isLegal = isLegal;
	}

	private String tradingName;

	public String getTradingName() {
		return tradingName;
	}

	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private OrganizationEntry parentOrganization;

	public OrganizationEntry getParentOrganization() {
		return parentOrganization;
	}

	public void setParentOrganization(OrganizationEntry parentOrganization) {
		this.parentOrganization = parentOrganization;
	}
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="parentOrganization")
	private Set<OrganizationEntry> childOrganizations=new LinkedHashSet<OrganizationEntry>(); 
	
	public Set<OrganizationEntry> getChildOrganizations() {
		return childOrganizations;
	}
	public void addChildOrganization(OrganizationEntry childOrganization) {
		this.childOrganizations.add(childOrganization);
	}

	@Override
	public String getName() {
		return this.getTradingName();
	}
}
