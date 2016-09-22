package com.ai.bss.query.policy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PL_COMPOSITE_CONDITION_OPTION")
public class PolicyCompositeConditionOptionEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@JoinColumn(name="PARENT_CONDITION_ID")
	@OneToOne
	private PolicyCompositeConditionEntry parent;
	@OneToOne
	@JoinColumn(name="CHILD_CONDITION_ID")
	private PolicyConditionEntry child;
	
	public PolicyCompositeConditionOptionEntry() {
	}

	
	public PolicyConditionEntry getChildCondition() {
		return this.child;
	}

	
	public void setChildCondition(PolicyConditionEntry child) {
		this.child=child;
	}

	
	public PolicyCompositeConditionEntry getParentCondition() {
		return this.parent;
	}

	
	public void setParentCondition(PolicyCompositeConditionEntry parent) {
		this.parent=parent;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

}
