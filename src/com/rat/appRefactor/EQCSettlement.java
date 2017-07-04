package com.rat.appRefactor;

import java.math.BigDecimal;

public class EQCSettlement {
	
	private Enum<Event> eventPaidUnder;
	private BigDecimal amount;
	
	
	public EQCSettlement(Enum<Event> eventPaidUnder, BigDecimal amount) {
		super();
		this.eventPaidUnder = eventPaidUnder;
		this.amount = amount;
	}
	
	public Enum<Event> getEventPaidUnder() {
		return eventPaidUnder;
	}
	public void setEventPaidUnder(Enum<Event> eventPaidUnder) {
		this.eventPaidUnder = eventPaidUnder;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
