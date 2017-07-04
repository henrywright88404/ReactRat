package com.rat.appRefactor;

public class EventApportionment {
	
	private float claimApportionment;
	private float eQCExemptApportionment;
	private float retainingWallApportionment;
	
	public EventApportionment(float claimApportionment, float eQCExemptApportionment,
			float retainingWallApportionment) {
		this.claimApportionment = claimApportionment;
		this.eQCExemptApportionment = eQCExemptApportionment;
		this.retainingWallApportionment = retainingWallApportionment;
	}
	
	public EventApportionment(){};

	public float getClaimApportionment() {
		return claimApportionment;
	}
	
	public void setClaimApportionment(float claimApportionment) {
		this.claimApportionment = claimApportionment;
	}
	
	public float geteQCExemptApportionment() {
		return eQCExemptApportionment;
	}
	
	public void seteQCExemptApportionment(float eQCExemptApportionment) {
		this.eQCExemptApportionment = eQCExemptApportionment;
	}
	
	public float getRetainingWallApportionment() {
		return retainingWallApportionment;
	}
	
	public void setRetainingWallApportionment(float retainingWallApportionment) {
		this.retainingWallApportionment = retainingWallApportionment;
	}

	@Override
	public String toString() {
		return "EventApportionment [claimApportionment=" + claimApportionment + ", eQCExemptApportionment="
				+ eQCExemptApportionment + ", retainingWallApportionment=" + retainingWallApportionment + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(claimApportionment);
		result = prime * result + Float.floatToIntBits(eQCExemptApportionment);
		result = prime * result + Float.floatToIntBits(retainingWallApportionment);
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
		if (!(obj instanceof EventApportionment)) {
			return false;
		}
		EventApportionment other = (EventApportionment) obj;
		if (Float.floatToIntBits(claimApportionment) != Float.floatToIntBits(other.claimApportionment)) {
			return false;
		}
		if (Float.floatToIntBits(eQCExemptApportionment) != Float.floatToIntBits(other.eQCExemptApportionment)) {
			return false;
		}
		if (Float.floatToIntBits(retainingWallApportionment) != Float
				.floatToIntBits(other.retainingWallApportionment)) {
			return false;
		}
		return true;
	}
	

}
