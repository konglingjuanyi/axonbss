package com.ai.bss.query.policy;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PL_STATEMENT")
public abstract class PolicyStatementEntry{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private String name;
	private String code;
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name="panType", column=@Column(name="LEFT_PAN_TYPE"))
    })
	@AssociationOverrides({
		@AssociationOverride(name="panValue", joinColumns=@JoinColumn(name="LEFT_VALUE_ID",referencedColumnName = "ID")),
		@AssociationOverride(name="panVariable", joinColumns=@JoinColumn(name="LEFT_VARIABLE_ID",referencedColumnName = "ID"))
	})
	private PolicyPanEntry leftPan;
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name="panType", column=@Column(name="RIGHT_PAN_TYPE"))
    })
	@AssociationOverrides({
		@AssociationOverride(name="panValue", joinColumns=@JoinColumn(name="RIGHT_VALUE_ID",referencedColumnName = "ID")),
		@AssociationOverride(name="panVariable", joinColumns=@JoinColumn(name="RIGHT_VARIABLE_ID",referencedColumnName = "ID"))
	})
	private PolicyPanEntry rightPan;
	
	public PolicyStatementEntry() {
	}

	
	public String getName() {
		return this.name;
	}

	
	public void setName(String name) {
		this.name=name;
	}

	
	public String getCode() {
		return this.code;
	}

	
	public void setCode(String code) {
		this.code=code;
	}	


	@Column(name="OPERATOR_ID")
	public abstract PolicyOperatorEntry getOperator();

	
	public abstract void setOperator(PolicyOperatorEntry operator);

	
	public String toBodyString() {
		StringBuffer sb=new StringBuffer();
		String firstParam="";
		String secondParam="";
		if(null!=this.getLeftPan()){
			firstParam=this.getLeftPan().toBodyString();
		}
		if(null!=this.getRightPan()){
			secondParam=this.getRightPan().toBodyString();
			if (null!=secondParam){
				sb.append(this.getOperator().toBodyString(firstParam,secondParam));
			}
		}		
		return sb.toString();
	}
	
	
	public Set<PolicyVariableEntry> getVariables(){
		Set<PolicyVariableEntry> variables=new LinkedHashSet<PolicyVariableEntry>();
		if(null!=this.getLeftPan() && (null!=this.getLeftPan().getVariables())){
			variables.addAll(this.getLeftPan().getVariables());
		}
		if(null!=this.getRightPan() && (null!=this.getRightPan().getVariables())){
			variables.addAll(this.getRightPan().getVariables());
		}
		return variables;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public PolicyPanEntry getLeftPan() {
		return leftPan;
	}


	public void setLeftPan(PolicyPanEntry leftPan) {
		this.leftPan = leftPan;
	}


	public PolicyPanEntry getRightPan() {
		return rightPan;
	}


	public void setRightPan(PolicyPanEntry rightPan) {
		this.rightPan = rightPan;
	}
	

}
