package com.ai.bss.query.api.customerorder;

public enum OrderItemStateEnum {
	Initial,
	Suspended,
	Aborted,
	AwaitingAbort,
	AwaitingDelivery,
	AwaitingActivation,
	Completed;
}
