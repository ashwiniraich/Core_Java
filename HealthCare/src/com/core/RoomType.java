package com.core;

public enum RoomType {
	 GENERAL(2000), SPECIAL(5000), SEMISPECIAL(3000),ICU(7000);
	
	private double charges;
	
	RoomType(double charges) {
		this.charges=charges;
	}

	public double getCharges() {
		return charges;
	}
	
	public String toString() {
		return name()+":"+charges;
	}
}
