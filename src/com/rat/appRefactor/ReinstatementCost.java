package com.rat.appRefactor;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class ReinstatementCost {
	protected String item;
	protected String referenceNote;
	protected BigDecimal amount;
	
	public ReinstatementCost(String item, String referenceNote, BigDecimal amount) {
		this.item = item;
		this.referenceNote = referenceNote;
		amount = amount.setScale(2, RoundingMode.CEILING);
		this.amount = amount;
	}


	public String getItem() {
		return item;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
	
	public String getReferenceNote() {
		return referenceNote;
	}
	
	public void setReferenceNote(String referenceNote) {
		this.referenceNote = referenceNote;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void addAmount(BigDecimal amount) {
		amount = amount.setScale(2, RoundingMode.CEILING);
		this.amount.add(amount);
	}
	
	public void subtractAmount(BigDecimal amount) {
		this.amount.subtract(amount);
	}
	
	public void setAmount (BigDecimal amount) {
		amount = amount.setScale(2, RoundingMode.CEILING);
		this.amount = amount;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ReinstatementCost)) {
			return false;
		}
		ReinstatementCost other = (ReinstatementCost) obj;
		if (amount == null) {
			if (other.amount != null) {
				return false;
			}
		} else if (!amount.equals(other.amount)) {
			return false;
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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReinstatementCost [item=");
		builder.append(item);
		builder.append(", referenceNote=");
		builder.append(referenceNote);
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}
	
	
}
