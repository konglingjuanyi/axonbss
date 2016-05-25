package com.ai.bss.query.policy;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.ai.bss.query.characteristicSpec.CharacteristicSpecValueEntry;


@Entity
@DiscriminatorValue("ENUM")
public class PolicyEnumValue extends PolicyValueEntry {
	@Transient //TODO
	private Set<CharacteristicSpecValueEntry> enumValues=new LinkedHashSet<CharacteristicSpecValueEntry>();
	@Transient //TODO
	private CharacteristicSpecValueEntry enumValue;
	public PolicyEnumValue( PolicySetEntry policyset) {
		super(policyset);
	}

	
	public Set<CharacteristicSpecValueEntry> getEnumValues() {
		return this.enumValues;
	}

	
	public void addEnumValue(CharacteristicSpecValueEntry value) {
		if(null!=value){
			enumValues.add(value);
		}

	}

	
	public CharacteristicSpecValueEntry getEnumValue() {
		return this.enumValue;
	}

	
	public void setEnumValue(CharacteristicSpecValueEntry enumValue) {
		this.enumValue=enumValue;
	}

	
	public String toBodyString() {
		StringBuffer sb=new StringBuffer();
		
		if (this.getEnumValues().size()>0){
			sb.append("(");
			for (CharacteristicSpecValueEntry specValue : this.getEnumValues()) {
				sb.append(specValue.getValue()).append(",");
			}
			sb.delete(sb.length()-1,sb.length()-1);
			sb.append(")");
		}else{
			sb.append(this.getEnumValue().getValue());
		}
		return sb.toString();
	}

	
	public Set<PolicyVariableEntry> getVariables() {
		return null;
	}
}
