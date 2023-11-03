package com.tester;

import static com.utils.CustomerValidation.validateAll;
import static com.utils.CustomerUtils.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import com.core.Customer;
import com.core.ServicePlan;
import com.custom_exception.InvalidInputException;
import com.custom_sorting.SortByDOB;

public class TestCustomer {
//String fname, String lname, String email, String password, double registerationAmt, LocalDate dob,LocalDate subscribDate
//ServicePlan plan
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("------------------PLAN---------------------");
			for (ServicePlan sp : ServicePlan.values()) {
				System.out.println(sp);
			}
			List<Customer> cust = populateCust();
//			List<Customer> cust=new ArrayList<>();
			boolean exit = false;
			while (exit != true) {
				try {
					System.out.println("------------------MENU---------------------");
					System.out.println(
							"1.Registration\n2.Login\n3.Change Password\n4.Unsubscribe\n5.Display all\n6.Sorting by Email\n7.Sorting by DOB\n8.Sorting by DOB and Last name\n9.Remove accounts with Pending subscription\n0.Exit");
					System.out.println("-------------------------------------------");
					switch (sc.nextInt()) {
					case 0:
						System.out.println("--------------EXITED--------------------");
						exit = true;
						break;
					case 1:
						System.out.println(
								"Enter customer details:fname, lname, email, password, registerationAmt, dob,subscription date, PLAN");
						Customer customer = validateAll(sc.next(), sc.next(), sc.next(), sc.next(),sc.nextDouble(),sc.next(),
								sc.next(), sc.next().toUpperCase(), cust);
						cust.add(customer);
						System.out.println("customer added....");
						break;

					case 2:
						System.out.println("Enter Email Id and password: ");
						customer=checkEmail(sc.next(), cust);
						checkPassword(sc.next(),customer);
						break;

					case 3:
						System.out.println("Enter Email Id old password and new password: ");
						customer=checkEmail(sc.next(), cust);
						checkPassword(sc.next(), sc.next(), customer);
						break;

					case 4:
						System.out.println("Enter Email: ");
						if (cust.remove(new Customer(sc.next()))) {
							System.out.println("You have successfully unsubscribed....");
						}else {
							throw new InvalidInputException("The email you have entered is invalid.....");
						}
							break;

					case 5:
						for (Customer c1 : cust) {
							System.out.println(c1);
						}
						break;
						
					case 6:
						Collections.sort(cust);
						break;
						
					case 7:
						Collections.sort(cust, new SortByDOB());
						break;
						
					case 8:
						Collections.sort(cust, new Comparator<Customer>() {

							@Override
							public int compare(Customer c1, Customer c2) {
								int ret=c1.getDob().compareTo(c2.getDob());
								if(ret==0) {
									return c1.getLname().compareTo(c2.getLname());
									}
								return ret;
								}	
							});
						break;
						
					case 9:
						removeUnsubCust(cust);
						break;

					default:
						break;
					}
				} catch (IllegalArgumentException e) {
					System.out.println("You have entered an invalid plan.....");
					e.printStackTrace();
				} catch (Exception e) {
					sc.nextLine();
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}
}
