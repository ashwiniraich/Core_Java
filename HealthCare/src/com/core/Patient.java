package com.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Patient implements Serializable {
	private int serialNo;
	private String pname;
	private int age;
	private String gender;
	private String address;
	private String phoneNo;
	private String disease;
	private LocalDate admitDate;
	private double bill;
	private double annualIncome;
	private RoomType room;
	public int getSerialNo() {
		return serialNo;
	}
	public String getPname() {
		return pname;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public String getAddress() {
		return address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getDisease() {
		return disease;
	}
	public LocalDate getAdmitDate() {
		return admitDate;
	}
	public double getBill() {
		return bill;
	}
	public double getAnnualIncome() {
		return annualIncome;
	}
	public RoomType getRoom() {
		return room;
	}
	
	public Patient(int serialNo, String pname, int age, String gender, String address, String phoneNo, String disease,
			LocalDate admitDate, double bill, double annualIncome, RoomType room) {
		super();
		this.serialNo = serialNo;
		this.pname = pname;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNo = phoneNo;
		this.disease = disease;
		this.admitDate = admitDate;
		this.bill = bill;
		this.annualIncome = annualIncome;
		this.room = room;
	}
	public void setRoom(RoomType room) {
		this.room = room;
	}
	@Override
	public String toString() {
		return "Patient [serialNo=" + serialNo + ", pname=" + pname + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + ", phoneNo=" + phoneNo + ", disease=" + disease + ", admitDate=" + admitDate
				+ ", bill=" + bill + ", annualIncome=" + annualIncome + ", room=" + room + "]"+"\n";
	}
	
	
	
	
}
