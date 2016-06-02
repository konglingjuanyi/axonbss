package com.ai.bss.webui.party.model;

public class Legal extends Party {
	private String legalName;
	private String parentLegalId;
	public Legal() {
		
	}
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	public String getParentLegalId() {
		return parentLegalId;
	}
	public void setParentLegalId(String parentLegalId) {
		this.parentLegalId = parentLegalId;
	}

}
