package com.ai.bss.query.policy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("STATIC")
public class PolicyStaiticFunctionEntry extends PolicyFunctionEntry {

	public PolicyStaiticFunctionEntry() {
	}

}
