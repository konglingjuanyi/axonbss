package com.ai.bss.api.base;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="RT_CHARACTER")
public class CharacteristicSpec{
	@Id
	private String id;
	
	@OneToMany(mappedBy="characteristic",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<CharacteristicSpecValue> values=new java.util.LinkedHashSet<CharacteristicSpecValue>();
	
	@Column
	private String name;
	@Column
	private String code;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public Set<CharacteristicSpecValue> getValues() {
		return this.values;
	}

	
	public void addValue(CharacteristicSpecValue value) {
		if (null!=value){
			values.add(value);
			if (null==value.getCharacteristic()){
				value.setCharacteristic(this);
			}
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
