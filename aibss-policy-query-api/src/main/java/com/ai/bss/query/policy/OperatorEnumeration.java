package com.ai.bss.query.policy;

public enum OperatorEnumeration {
	Add(OperatorType.Arithmetic),
	And(OperatorType.Logical);
	
	private OperatorType type;
	
	OperatorEnumeration(OperatorType type){
		this.type=type;
	}
	
	public enum OperatorType{
		 Arithmetic,
		 Logical;
	}
}
