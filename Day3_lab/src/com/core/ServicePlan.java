package com.core;

public enum ServicePlan {
	SILVER(1000), GOLD(2000), DIAMOND(5000), PLATINUM(10000);

	double planCost;

	ServicePlan(double planCost) {
		this.planCost = planCost;
	}

	public double getPlanCost() {
		return planCost;
	}
	
	public String toString() {
		return name().toLowerCase()+" : "+planCost;
	}

}
