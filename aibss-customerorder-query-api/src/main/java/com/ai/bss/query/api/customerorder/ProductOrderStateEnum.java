package com.ai.bss.query.api.customerorder;

public enum ProductOrderStateEnum {
	Initial,
	Running,
	Suspended,
	Aborted,
	Aborting,
	Delivering,
	Activating,
	Activated,
	Delivered,
	Returned;
}
