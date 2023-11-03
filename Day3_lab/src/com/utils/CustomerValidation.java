package com.utils;

import java.time.LocalDate;
import java.util.List;

import com.core.Customer;
import com.core.ServicePlan;
import com.custom_exception.InvalidInputException;

public class CustomerValidation {
	
	
	//throws IllegalArgumentException is not compulsory to write as it is a unchecked exc and compiler does not force to handle these excs
	public static ServicePlan ValidateServicePlan(String plan) throws IllegalArgumentException{
		return ServicePlan.valueOf(plan);
	}
	
	public static void CheckDuplicateCustomer(String email,List<Customer> cust) throws InvalidInputException {
		Customer newCust=new Customer(email);
		String exp="[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
		if(cust.contains(newCust)) {
			throw new InvalidInputException("The email you have entered is already used.....");
		}
		if(!email.matches(exp)) {
			throw new InvalidInputException("the email is in wrong format......");
		}
		
	}
	
	public static void ValidateRegAmt(ServicePlan plan,double regCost) throws InvalidInputException {
		if(plan.getPlanCost()!=regCost) {
			throw new InvalidInputException("Registration amount does not match....");
		}
	}
	
	public static Customer validateAll(String fname, String lname, String email, String password, double registerationAmt, String dob,String subscribDate,
			String plan,List<Customer> cust) throws InvalidInputException {
		LocalDate date=LocalDate.parse(dob);
		LocalDate subDate=LocalDate.parse(subscribDate);
		ServicePlan servicePlan=ValidateServicePlan(plan);
		ValidateRegAmt(servicePlan,registerationAmt);
		CheckDuplicateCustomer(email, cust);
		return new Customer(fname,lname,email,password,registerationAmt,date,subDate,servicePlan);
		}
}
