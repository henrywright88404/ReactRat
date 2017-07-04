package com.rat.appRefactor;

public class ClaimNumbers {

	private Claim sept2010;
	private Claim dec2010;
	private Claim feb2011;
	private Claim june2011;
	private Claim dec2011;
	
	public ClaimNumbers(Claim sept2010, Claim dec2010, Claim feb2011, Claim june2011, Claim dec2011) {
		this.sept2010 = sept2010;
		this.dec2010 = dec2010;
		this.feb2011 = feb2011;
		this.june2011 = june2011;
		this.dec2011 = dec2011;
	}
	
	public ClaimNumbers(){};
	
	public Claim getSept2010() {
		return sept2010;
	}
	
	public void setSept2010(Claim sept2010) {
		this.sept2010 = sept2010;
	}
	
	public Claim getDec2010() {
		return dec2010;
	}
	
	public void setDec2010(Claim dec2010) {
		this.dec2010 = dec2010;
	}
	
	public Claim getFeb2011() {
		return feb2011;
	}
	
	public void setFeb2011(Claim feb2011) {
		this.feb2011 = feb2011;
	}
	
	public Claim getJune2011() {
		return june2011;
	}
	
	public void setJune2011(Claim june2011) {
		this.june2011 = june2011;
	}
	
	public Claim getDec2011() {
		return dec2011;
	}
	
	public void setDec2011(Claim dec2011) {
		this.dec2011 = dec2011;
	}
	public Claim getMainClaim(){
		if(sept2010 != null && sept2010.isMainclaim()){
			return sept2010;
		}else if(dec2010 != null && dec2010.isMainclaim()){
			return dec2010;
		}else if(feb2011 != null && feb2011.isMainclaim()){
			return feb2011;
		}else if(june2011 != null && june2011.isMainclaim()){
			return june2011;
		}else if(dec2011 != null && dec2011.isMainclaim()){
			return dec2011;
		}else{
			System.out.println("No Main claim present");
			return null;
		}
	}

	@Override
	public String toString() {
		return "ClaimNumbers [sept2010=" + sept2010 + ", dec2010=" + dec2010 + ", feb2011=" + feb2011 + ", june2011="
				+ june2011 + ", dec2011=" + dec2011 + "]";
	}

	//Auto Generated Hashcode. 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dec2010 == null) ? 0 : dec2010.hashCode());
		result = prime * result + ((dec2011 == null) ? 0 : dec2011.hashCode());
		result = prime * result + ((feb2011 == null) ? 0 : feb2011.hashCode());
		result = prime * result + ((june2011 == null) ? 0 : june2011.hashCode());
		result = prime * result + ((sept2010 == null) ? 0 : sept2010.hashCode());
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
		if (!(obj instanceof ClaimNumbers)) {
			return false;
		}
		
		ClaimNumbers other = (ClaimNumbers) obj;
		if (dec2010 == null) {
			if (other.dec2010 != null) {
				return false;
			}
		} else if (!dec2010.equals(other.dec2010)) {
			return false;
		}
		if (dec2011 == null) {
			if (other.dec2011 != null) {
				return false;
			}
		} else if (!dec2011.equals(other.dec2011)) {
			return false;
		}
		if (feb2011 == null) {
			if (other.feb2011 != null) {
				return false;
			}
		} else if (!feb2011.equals(other.feb2011)) {
			return false;
		}
		if (june2011 == null) {
			if (other.june2011 != null) {
				return false;
			}
		} else if (!june2011.equals(other.june2011)) {
			return false;
		}
		if (sept2010 == null) {
			if (other.sept2010 != null) {
				return false;
			}
		} else if (!sept2010.equals(other.sept2010)) {
			return false;
		}
		return true;
	}

}
