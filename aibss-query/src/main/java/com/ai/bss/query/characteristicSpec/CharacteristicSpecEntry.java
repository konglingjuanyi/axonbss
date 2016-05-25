package com.ai.bss.query.characteristicSpec;

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
public class CharacteristicSpecEntry{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(mappedBy="characteristic",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<CharacteristicSpecValueEntry> values=new java.util.LinkedHashSet<CharacteristicSpecValueEntry>();
	
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

	
	public Set<CharacteristicSpecValueEntry> getValues() {
		return this.values;
	}

	
	public void addValue(CharacteristicSpecValueEntry value) {
		if (null!=value){
			values.add(value);
			if (null==value.getCharacteristic()){
				value.setCharacteristic(this);
			}
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
