package com.rat.appRefactor;

public class Claim {
	private String claimNumber;
	private boolean mainclaim;
	
		
	public Claim(String claimNumber, boolean mainclaim) {
		this.claimNumber = claimNumber;
		this.mainclaim = mainclaim;
	}

	public Claim() {
		
	}

	public String getClaimNumber() {
		return claimNumber;
	}
	
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
	
	public boolean isMainclaim() {
		return mainclaim;
	}
	
	public void setMainclaim(boolean mainclaim) {
		this.mainclaim = mainclaim;
	}

	@Override
	public String toString() {
		
		if (!mainclaim){
			return "Claim [claimNumber=" + claimNumber + "]";
		}else{
			return "Claim [claimNumber=" + claimNumber + ", MAINCLAIM]";
		}
	}

	//Auto generated Hashcode Block
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((claimNumber == null) ? 0 : claimNumber.hashCode());
		result = prime * result + (mainclaim ? 1231 : 1237);
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
		if (!(obj instanceof Claim)) {
			return false;
		}
		
		Claim other = (Claim) obj;
		if (claimNumber == null) {
			if (other.claimNumber != null) {
				return false;
			}
		} else if (!claimNumber.equals(other.claimNumber)) {
			return false;
		}
		if (mainclaim != other.mainclaim) {
			return false;
		}
		return true;
	}
	
	
}
