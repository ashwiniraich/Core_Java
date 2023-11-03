package com.core;

import java.time.LocalDate;

public class Customer implements Comparable<Customer>{
	private static int counter;
	private int custId;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private double registerationAmt;
	private LocalDate dob;
	private LocalDate subscribDate;
	private ServicePlan plan;

	static {
		counter = 0;
	}
	

	public Customer(String email) {
		super();
		this.email = email;
	}

	public Customer(String fname, String lname, String email, String password, double registerationAmt, LocalDate dob,LocalDate subscribDate,
			ServicePlan plan) {
		super();
		counter++;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.registerationAmt = registerationAmt;
		this.dob = dob;
		this.subscribDate=subscribDate;
		this.plan = plan;
		this.custId = counter;
	}

	@Override
	public String toString() {
		return "Customer ID: " + custId + "     First Name: " + fname + "\tLast Name: " + lname + "\tEmail ID: " + email
				+ "     Registeration Amt: " + registerationAmt + "     DOB: " + dob +"     Subscription Date: " +subscribDate+ "     Plan: "
				+ plan;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Customer) {
			Customer c = (Customer) o;
			return this.email.equals(c.email);
		}
		return false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLname() {
		return lname;
	}

	public LocalDate getDob() {
		return dob;
	}
	
	public LocalDate getSubscribDate() {
		return subscribDate;
	}

	public void setSubscribDate(LocalDate subscribDate) {
		this.subscribDate = subscribDate;
	}

	@Override
	public int compareTo(Customer anotherCust) {
		return this.email.compareTo(anotherCust.email);
	}
	
	
	
	

}
