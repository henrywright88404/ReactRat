package com.rat.appRefactor;

import java.util.ArrayList;
import java.util.List;

public class Apportionment {
	private EventApportionment sept2010;
	private EventApportionment dec2010;
	private EventApportionment feb2011;
	private EventApportionment june2011;
	private EventApportionment dec2011;
	
	
	public Apportionment(EventApportionment sept2010, EventApportionment dec2010, EventApportionment feb2011,
			EventApportionment june2011, EventApportionment dec2011) {
		this.sept2010 = sept2010;
		this.dec2010 = dec2010;
		this.feb2011 = feb2011;
		this.june2011 = june2011;
		this.dec2011 = dec2011;
	}
	
	public Apportionment(){}

	public EventApportionment getSept2010() {
		return sept2010;
	}
	
	public void setSept2010(EventApportionment sept2010) {
		this.sept2010 = sept2010;
	}
	
	public EventApportionment getDec2010() {
		return dec2010;
	}
	
	public void setDec2010(EventApportionment dec2010) {
		this.dec2010 = dec2010;
	}
	
	public EventApportionment getFeb2011() {
		return feb2011;
	}
	
	public void setFeb2011(EventApportionment feb2011) {
		this.feb2011 = feb2011;
	}
	
	public EventApportionment getJune2011() {
		return june2011;
	}
	
	public void setJune2011(EventApportionment june2011) {
		this.june2011 = june2011;
	}
	
	public EventApportionment getDec2011() {
		return dec2011;
	}
	
	public void setDec2011(EventApportionment dec2011) {
		this.dec2011 = dec2011;
	}
	public List<EventApportionment> getEventApportionmentList(){
		List<EventApportionment> apportionmentList = new ArrayList<>();
		apportionmentList.add(sept2010);
		apportionmentList.add(dec2010);
		apportionmentList.add(feb2011);
		apportionmentList.add(june2011);
		apportionmentList.add(dec2011);
		
		return apportionmentList;
	}

	@Override
	public String toString() {
		return "Apportionment [sept2010=" + sept2010 + ", dec2010=" + dec2010 + ", feb2011=" + feb2011 + ", june2011="
				+ june2011 + ", dec2011=" + dec2011 + "]";
	}

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
		if (!(obj instanceof Apportionment)) {
			return false;
		}
		Apportionment other = (Apportionment) obj;
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
