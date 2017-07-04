package com.rat.appRefactor;

import java.util.List;

public class ReserveFigures {
	
	EQCExempt eQCExempt;
	RetainingWall retainingWall;
	List<ClaimReserveFigures> claimReserve;
	
	
	public ReserveFigures(EQCExempt eQCExempt, RetainingWall retainingWall, List<ClaimReserveFigures> claimReserve) {
		this.eQCExempt = eQCExempt;
		this.retainingWall = retainingWall;
		this.claimReserve = claimReserve;
	}

	public EQCExempt geteQCExempt() {
		return eQCExempt;
	}
	
	public void seteQCExempt(EQCExempt eQCExempt) {
		this.eQCExempt = eQCExempt;
	}
	
	public RetainingWall getRetainingWall() {
		return retainingWall;
	}
	
	public void setRetainingWall(RetainingWall retainingWall) {
		this.retainingWall = retainingWall;
	}
	
	public List<ClaimReserveFigures> getClaimReserve() {
		return claimReserve;
	}
	
	public void setClaimReserve(List<ClaimReserveFigures> claimReserve) {
		this.claimReserve = claimReserve;
	}
	
	public void addClaimReserve(ClaimReserveFigures claimReserve) {
		this.claimReserve.add(claimReserve);
	}
	
	public void removeClaimReserve(ClaimReserveFigures claimReserve) {
		this.claimReserve.remove(claimReserve);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((claimReserve == null) ? 0 : claimReserve.hashCode());
		result = prime * result + ((eQCExempt == null) ? 0 : eQCExempt.hashCode());
		result = prime * result + ((retainingWall == null) ? 0 : retainingWall.hashCode());
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
		if (!(obj instanceof ReserveFigures)) {
			return false;
		}
		ReserveFigures other = (ReserveFigures) obj;
		if (claimReserve == null) {
			if (other.claimReserve != null) {
				return false;
			}
		} else if (!claimReserve.equals(other.claimReserve)) {
			return false;
		}
		if (eQCExempt == null) {
			if (other.eQCExempt != null) {
				return false;
			}
		} else if (!eQCExempt.equals(other.eQCExempt)) {
			return false;
		}
		if (retainingWall == null) {
			if (other.retainingWall != null) {
				return false;
			}
		} else if (!retainingWall.equals(other.retainingWall)) {
			return false;
		}
		return true;
	}
	

}
