package com.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Serializable {
//	Customer id(int) , first name(String), last name (String), email(String), password(String),
//	Address String, RegisterDate(LocalDate), planEndDate(LocalDate),
//	Phone No(String),plan Enum, final_amount double
	
	private int custid;
	private String fname,lname,email,password,address,phoneNo;
	private LocalDate regDate,planEndDate;
	private MessPlan plan;
	private double finalAmt;
	
	public Customer(int custid, String fname, String lname, String email, String password, String address,
			String phoneNo, LocalDate regDate, LocalDate planEndDate, MessPlan plan, double finalAmt) {
		super();
		this.custid = custid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneNo = phoneNo;
		this.regDate = regDate;
		this.planEndDate = planEndDate;
		this.plan = plan;
		this.finalAmt = finalAmt;
	}
	
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}
	
	// Overriding toString
	@Override
	public String toString() {
		return "custid: " + custid + "      fname=" + fname + "      lname=" + lname + "      email=" + email
				+ "      address=" + address + "      phoneNo=" + phoneNo + "      regDate=" + regDate + "      planEndDate="
				+ planEndDate + "      plan=" + plan + "      finalAmt=" + finalAmt+"\n" ;
	}
	
    //getters

	public int getCustid() {
		return custid;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public LocalDate getPlanEndDate() {
		return planEndDate;
	}

	public MessPlan getPlan() {
		return plan;
	}

	public double getFinalAmt() {
		return finalAmt;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setFinalAmt(double finalAmt) {
		this.finalAmt = finalAmt;
	}
	
	
	
	
}
