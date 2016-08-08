package com.ai.bss.query.party;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("ORGANIZATION.DEPARTMENT")
public class DepartmentEntry extends OrganizationEntry {
	@Transient
	private String departmentName;
	@Column(name="IS_TOP_DEPARTMENT")
	private boolean isTopDepartment;

	protected DepartmentEntry(){
		
	}
	
	public String getDepartmentName(){
		return this.getTradingName();
	}
	
	public void setDepartmentName(String departmentName){
		this.setTradingName(departmentName);
		this.departmentName=departmentName;
	}
		
	public DepartmentEntry(String partyId,String departmentName,boolean isTopDepartment,OrganizationEntry parent){
		super(partyId,departmentName,"ORGANIZATION.DEPARTMENT");
		this.setDepartmentName(departmentName);
		this.setTopDepartment(isTopDepartment);
		this.setParentOrganization(parent);
	}	

	public boolean hasChildDepartmens() {
		return this.getChildOrganizations().size()>0;
	}


	public void addChildDepartment(DepartmentEntry childDepartment) {
		if(null!=childDepartment){
			this.addChildOrganization((OrganizationEntry)childDepartment);
			childDepartment.setParentOrganization(this);
		}		
	}
	
	public Set<DepartmentEntry>  getChildDepartments(){
		Set<OrganizationEntry> childOrganizations=this.getChildOrganizations();
		Set<DepartmentEntry> childDepartments=new LinkedHashSet<DepartmentEntry>();
		if (null!=childOrganizations&&childOrganizations.size()>0){			
			for (OrganizationEntry organizationEntry : childOrganizations) {
				if (organizationEntry instanceof DepartmentEntry){
					childDepartments.add((DepartmentEntry)organizationEntry);
				}
			}
		}
		return childDepartments;
	}

	public LegalOrganizationEntry getLegalOrganization() {
		OrganizationEntry parent= this.getParentOrganization();
		if (null!=parent&&(parent instanceof LegalOrganizationEntry)){
			return (LegalOrganizationEntry)parent;
		}else{
			return null;
		}
	}

	public DepartmentEntry getParentDepartment() {
		OrganizationEntry parent= this.getParentOrganization();
		if (null!=parent&&(parent instanceof DepartmentEntry)){
			return (DepartmentEntry)parent;
		}else{
			return null;
		}
	}


	public boolean isTopDepartment() {
		return isTopDepartment;
	}

	public void setTopDepartment(boolean isTopDepartment) {
		this.isTopDepartment = isTopDepartment;
	}
}
