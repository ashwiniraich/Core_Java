package com.core;

public enum MessPlan {
	 MONTHY (3000), QUATERLY (11700), HALFYEARLY (17500), YEARLY (32000);
	 
	private double fees;
	
	MessPlan(double fees){
		this.fees=fees;
	}

	public double getFees() {
		return fees;
	}
	
	
}
