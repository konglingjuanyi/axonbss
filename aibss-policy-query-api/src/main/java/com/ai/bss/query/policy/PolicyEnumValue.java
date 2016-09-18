package com.ai.bss.query.policy;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.ai.bss.api.base.CharacteristicSpecValue;

@Entity
@DiscriminatorValue("ENUM")
public class PolicyEnumValue extends PolicyValueEntry {
	@Transient //TODO
	private Set<CharacteristicSpecValue> enumValues=new LinkedHashSet<CharacteristicSpecValue>();
	@Transient //TODO
	private CharacteristicSpecValue enumValue;
	public PolicyEnumValue( PolicySetEntry policyset) {
		super(policyset);
	}

	
	public Set<CharacteristicSpecValue> getEnumValues() {
		return this.enumValues;
	}

	
	public void addEnumValue(CharacteristicSpecValue value) {
		if(null!=value){
			enumValues.add(value);
		}

	}

	
	public CharacteristicSpecValue getEnumValue() {
		return this.enumValue;
	}

	
	public void setEnumValue(CharacteristicSpecValue enumValue) {
		this.enumValue=enumValue;
	}

	
	public String toBodyString() {
		StringBuffer sb=new StringBuffer();
		
		if (this.getEnumValues().size()>0){
			sb.append("(");
			for (CharacteristicSpecValue specValue : this.getEnumValues()) {
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
