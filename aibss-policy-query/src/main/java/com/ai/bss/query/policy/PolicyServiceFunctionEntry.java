package com.ai.bss.query.policy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SERVICE")
public class PolicyServiceFunctionEntry extends PolicyFunctionEntry{

	public PolicyServiceFunctionEntry() {
	}

}
