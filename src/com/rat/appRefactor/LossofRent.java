package com.rat.appRefactor;

import java.math.BigDecimal;

public class LossofRent {
	private BigDecimal policyLimit;
	private BigDecimal estimated;
	
	
	public LossofRent(BigDecimal policyLimit, BigDecimal estimated) {
		this.policyLimit = policyLimit;
		this.estimated = estimated;
	}
	

	public BigDecimal getPolicyLimit() {
		return policyLimit;
	}
	
	public void setPolicyLimit(BigDecimal policyLimit) {
		this.policyLimit = policyLimit;
	}
	
	public BigDecimal getEstimated() {
		return estimated;
	}
	
	public void setEstimated(BigDecimal estimated) {
		this.estimated = estimated;
	}
	
}
