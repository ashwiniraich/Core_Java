package com.utils;

//import static java.time.LocalDate.now;
//import static java.time.LocalDate.parse;

import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.core.Customer;
import com.core.ServicePlan;
import com.custom_exception.InvalidInputException;
import static java.time.LocalDate.*;
//import static java.time.Period.*;

public class CustomerUtils {
	
	public static Customer checkEmail(String email,List<Customer> cust) throws InvalidInputException {
		Customer customer = new Customer(email);
		int index = cust.indexOf(customer);
		if (index==-1) {
			throw new InvalidInputException("Invalid Email.....");
		}
		return cust.get(index);
	}
		
	public static void checkPassword(String pword,Customer customer) throws InvalidInputException {
		if(customer.getPassword().equals(pword)) {
			System.out.println("Login successful.....");
		}
		else {
		throw new InvalidInputException("Invalid password.....");
		}
	}
	
	public static void checkPassword(String pword,String newpaword,Customer customer) throws InvalidInputException {
		if(customer.getPassword().equals(pword)) {
			customer.setPassword(newpaword);
			System.out.println("Password has successfully changed.....");
		}
		else {
		throw new InvalidInputException("Invalid password.....");
		}
	}
	
	public static void removeUnsubCust(List<Customer> cust) {
		Iterator<Customer> itr= cust.iterator();
		while(itr.hasNext()) {
			Customer c=itr.next();
			long datePeriod=Period.between(c.getSubscribDate(),now()).toTotalMonths();
			if(datePeriod>6) {
				itr.remove();
				System.out.println("Account with "+c.getEmail()+" has been removed.....");
			}
		}
	}
		
	public static List<Customer> populateCust(){
		List<Customer> cust=new ArrayList<>();
		cust.add(new Customer("Nanami","kento","nk@abc.com","nk123",2000,parse("2001-09-02"),parse("2023-09-02"),ServicePlan.GOLD));
		cust.add(new Customer("Gintoki","Sakata","gk@abc.com","gs123",5000,parse("2002-09-02"),parse("2023-07-02"),ServicePlan.DIAMOND));
		cust.add(new Customer("Jotharo","Kujoturo","jk@abc.com","jk123",1000,parse("1999-06-02"),parse("2023-01-02"),ServicePlan.SILVER));
		cust.add(new Customer("Rohan","Kishibe","rk@abc.com","rk123",2000,parse("1999-10-06"),parse("2023-06-02"),ServicePlan.GOLD));
		cust.add(new Customer("Yoshi","Kiramada","yk@abc.com","yk123",5000,parse("2001-09-02"),parse("2023-02-02"),ServicePlan.DIAMOND));
		return cust;
	}
}