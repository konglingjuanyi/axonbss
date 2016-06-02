package com.ai.bss.webui.party.model;

public class ChildDepartment extends Department {
	private String parentDepartmentId;
	private String parentDepartmentName;
	public ChildDepartment() {
		
	}
	public String getParentDepartmentId() {
		return parentDepartmentId;
	}
	public void setParentDepartmentId(String parentDepartmentId) {
		this.parentDepartmentId = parentDepartmentId;
	}
	public String getParentDepartmentName() {
		return parentDepartmentName;
	}
	public void setParentDepartmentName(String parentDepartmentName) {
		this.parentDepartmentName = parentDepartmentName;
	}


}
