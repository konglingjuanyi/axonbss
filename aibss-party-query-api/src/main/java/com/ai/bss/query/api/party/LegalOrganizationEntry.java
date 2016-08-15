package com.ai.bss.query.api.party;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("ORGANIZATION.LEGAL")
public class LegalOrganizationEntry extends OrganizationEntry{
	@Transient
	private String legalName;
	
	public LegalOrganizationEntry(String partyId,String legalName){
		super(partyId,legalName,"ORGANIZATION.LEGAL");
		this.legalName=legalName;
	}
	
	private LegalOrganizationEntry(){
		
	}
	
	public String getLegalName(){
		return this.getTradingName();
	}
	
	public void setLegalName(String legalName){
		this.setTradingName(legalName);
		this.legalName=legalName;
	}
	
	public List<DepartmentEntry> getDepartments() {
		List<DepartmentEntry> departments=new ArrayList<DepartmentEntry>();
		if(null!=this.getChildOrganizations()){			
			for (OrganizationEntry org:this.getChildOrganizations()) {
				if (org instanceof DepartmentEntry){
					departments.add((DepartmentEntry)org);
				}
			}	

		}
		return departments;
	}

	public List<LegalOrganizationEntry> getChildLegalOrganizations() {
		List<LegalOrganizationEntry> childLegalOrganizations=new ArrayList<LegalOrganizationEntry>();
		if(null!=this.getChildOrganizations()){
			for (OrganizationEntry org:this.getChildOrganizations()) {
				if (org instanceof LegalOrganizationEntry){
					childLegalOrganizations.add((LegalOrganizationEntry)org);
				}
			}	
		}
		return childLegalOrganizations;
	}

	public LegalOrganizationEntry getParentLegalOrganization() {
		return (LegalOrganizationEntry)this.getParentOrganization();
	}

	public boolean isTopLegalOrganization() {
		return null==this.getParentLegalOrganization();
	}

	public boolean hasDepartments() {
		return this.getDepartments()!=null&&this.getDepartments().size()>0;
	}

	public boolean hasChildLegalOrganizations() {
		return this.getChildLegalOrganizations()!=null&&this.getChildLegalOrganizations().size()>0;
	}

	public void addDepartment(DepartmentEntry department) {
		if (null!=department){
			super.addChildOrganization(department);
			department.setParentOrganization(this);
		}
		
	}

	public void addChildLegalOrganization(LegalOrganizationEntry childLegalOrganization) {
		if (null!=childLegalOrganization){
			super.addChildOrganization(childLegalOrganization);
			childLegalOrganization.setParentOrganization(this);
		}
		
	}

	public void setParentLegalOrganization(LegalOrganizationEntry parentLegalOrganization) {
		this.setParentOrganization(parentLegalOrganization);		
	}


}
