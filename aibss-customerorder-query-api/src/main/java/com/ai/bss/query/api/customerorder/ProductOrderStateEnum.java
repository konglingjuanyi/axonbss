package com.ai.bss.query.api.customerorder;

public enum ProductOrderStateEnum {
	Initial,
	Running,
	Suspended,
	Aborted,
	AwaitingAbort,
	AwaitingDelivery,
	AwaitingActivation,
	Completed;
}
