package com.ai.bss.aggregate.party;

import org.axonframework.eventhandling.annotation.EventHandler;

import com.ai.bss.api.party.PartyId;
import com.ai.bss.api.party.event.ChildDepartmentCreatedEvent;
import com.ai.bss.api.party.event.DepartmentRenamedEvent;
import com.ai.bss.api.party.event.DepartmentTerminatedEvent;
import com.ai.bss.api.party.event.TopDepartmentCreatedEvent;
import com.ai.bss.exception.party.NewPartyNameSameAsOldException;

public class Department extends Organization {
	private String departmentName;
	private String legalId;
	private String parentDepartmentId;
	
	private Department(){
		
	}
	
	public Department(PartyId partyId,String departmentName,boolean isTopDepartment,String parentId) {
		if (isTopDepartment){
			apply(new TopDepartmentCreatedEvent(partyId,departmentName,parentId));
		}else{
			apply(new ChildDepartmentCreatedEvent(partyId,departmentName,parentId));
		}		
	}
	
	@EventHandler
	public void onTopDepartmentCreated(TopDepartmentCreatedEvent event){
		this.setPartyId(event.getPartyId());
		this.legalId=event.getLegalId();
		this.setDepartmentName(event.getDepartmentName());
	}
	
	@EventHandler
	public void onChildDepartmentCreated(ChildDepartmentCreatedEvent event){
		this.setPartyId(event.getPartyId());
		this.parentDepartmentId=event.getParentDepartmentId();
		this.setDepartmentName(event.getDepartmentName());
	}
	
	public void rename(String newDepartmentName) throws Exception{
		if (newDepartmentName.equalsIgnoreCase(this.getDepartmentName())){
			throw new NewPartyNameSameAsOldException(this.getName());
		}
		this.setDepartmentName(newDepartmentName);
		apply(new DepartmentRenamedEvent(this.getPartyId(), newDepartmentName));
	}
	
	public void terminate() throws Exception{
		//TODO check if party has partyRoles, if have, notify to terminate partyRole first.
		this.setState("Terminated");
		apply(new DepartmentTerminatedEvent(this.getPartyId()));
	}
	@Override
	public String getName() {
		return this.departmentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getLegalId() {
		return legalId;
	}
	public void setLegalId(String legalId) {
		this.legalId = legalId;
	}
	public String getParentDepartmentId() {
		return parentDepartmentId;
	}
	public void setParentDepartmentId(String parentDepartmentId) {
		this.parentDepartmentId = parentDepartmentId;
	}

}
