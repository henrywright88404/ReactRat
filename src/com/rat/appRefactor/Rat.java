package com.rat.appRefactor;

import java.util.List;

public class Rat {
	private Claim mainClaim;
	private ClaimNumbers claimNumbers;
	private Apportionment apportionment;
	private ReserveFigures reserveFigures;
	private List<Payments> payments;
	private LossofRent lossOfRent;
	private EQCSettlement eQCSettlement;
	
	
	public Rat(Claim mainClaim, ClaimNumbers claimNumbers, Apportionment apportionment, ReserveFigures reserveFigures,
			List<Payments> payments, LossofRent lossOfRent, EQCSettlement eQCSettlement) {
		this.mainClaim = mainClaim;
		this.claimNumbers = claimNumbers;
		this.apportionment = apportionment;
		this.reserveFigures = reserveFigures;
		this.payments = payments;
		this.lossOfRent = lossOfRent;
		this.eQCSettlement = eQCSettlement;
	}
	public Rat() {
	}
	public Claim getMainClaim() {
		return mainClaim;
	}
	public void setMainClaim(Claim mainClaim) {
		this.mainClaim = mainClaim;
	}
	public ClaimNumbers getClaimNumbers() {
		return claimNumbers;
	}
	public void setClaimNumbers(ClaimNumbers claimNumbers) {
		this.claimNumbers = claimNumbers;
		setMainClaim(claimNumbers.getMainClaim());
		
	}
	public Apportionment getApportionment() {
		return apportionment;
	}
	public void setApportionment(Apportionment apportionment) {
		this.apportionment = apportionment;
	}
	public ReserveFigures getReserveFigures() {
		return reserveFigures;
	}
	public void setReserveFigures(ReserveFigures reserveFigures) {
		this.reserveFigures = reserveFigures;
	}

	public LossofRent getLossOfRent() {
		return lossOfRent;
	}
	public void setLossOfRent(LossofRent lossOfRent) {
		this.lossOfRent = lossOfRent;
	}
	public EQCSettlement geteQCSettlement() {
		return eQCSettlement;
	}
	public void seteQCSettlement(EQCSettlement eQCSettlement) {
		this.eQCSettlement = eQCSettlement;
	}
	public List<Payments> getPayments() {
		return payments;
	}
	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}
	public void addPayment(Payments payment) {
		this.payments.add(payment);
	}
	public void removePayment(Payments payment) {
		this.payments.remove(payment);
	}
	

 
}
