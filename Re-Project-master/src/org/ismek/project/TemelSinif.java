package org.ismek.project;

public abstract class TemelSinif {

	public abstract int getId();
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return getId();
	}
	
	@Override
	public boolean equals(Object obj) {
		TemelSinif temelSinif = (TemelSinif) obj;
		if (temelSinif.getId() == this.getId()) {
			return true;
		}
		
		return false;
	}
}