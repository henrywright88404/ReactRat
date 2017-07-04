package com.rat.appRefactor;

import java.math.BigDecimal;

public class Payments extends ReinstatementCost {

	private Enum<Event> eventPaidUnder;
	private Enum<PaymentType> paymentType;

	public Payments(String item, String referenceNote, BigDecimal amount, Enum<Event> eventPaidUnder,
			Enum<PaymentType> paymentType) {
		super(item, referenceNote, amount);
		this.eventPaidUnder = eventPaidUnder;
		this.setPaymentType(paymentType);
	}

	public Enum<Event> getEventPaidUnder() {
		return eventPaidUnder;
	}

	public void setEventPaidUnder(Enum<Event> eventPaidUnder) {
		this.eventPaidUnder = eventPaidUnder;
	}

	public Enum<PaymentType> getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Enum<PaymentType> paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Payments)) {
			return false;
		}
		Payments other = (Payments) obj;
		if (amount == null) {
			if (other.amount != null) {
				return false;
			}
		} else if (!amount.equals(other.amount)) {
			return false;
		}
		if (eventPaidUnder == null) {
			if (other.eventPaidUnder != null) {
				return false;
			}
		}
		if (item == null) {
			if (other.item != null) {
				return false;
			}
		} else if (!item.equals(other.item)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}
}
