package utils;

import java.time.LocalDate;
import static java.time.LocalDate.parse;
import java.util.Map;
import static tester.CustomerManagement.*;

import com.core.Customer;
import com.core.MessPlan;

import custom_exceptions.InvalidInputException;

public class CustomerUtils {
//	int custid, String fname, String lname, String email, String password, String address,
//	String phoneNo, MessPlan plan, double finalAmt

	//populateing cutomer details
	public static Map<String, Customer> populateCustMap() {
		
		custMap.put("yashika@abc.com", new Customer(101, "yashika", "mishra", "yashika@abc.com", "yashika123", "akurdi",
				"1234567890", parse("2023-11-14"), parse("2023-12-14"), MessPlan.MONTHY, 3000));
		custMap.put("bhumi@abc.com", new Customer(102, "bhumi", "Gupta", "bhumi@abc.com", "bhumi123", "pune",
				"1234567890", parse("2023-11-04"), parse("2024-05-04"), MessPlan.HALFYEARLY, 17500));
		custMap.put("amit@abc.com", new Customer(103, "amit", "ramteke", "amit@abc.com", "amit123", "pune", "1234567890",
				parse("2023-10-13"), parse("2023-11-13"), MessPlan.MONTHY, 3000));
		custMap.put("sakshi@abc.com", new Customer(104, "sakshi", "knoje", "sakshi@abc.com", "sakshi123", "akurdi",
				"1234567890", parse("2024-01-01"), parse("2025-01-01"), MessPlan.YEARLY, 32000));
		custMap.put("pragya@abc.com", new Customer(105, "pragya", "arjariya", "pragya@abc.com", "pragya123", "pune",
				"1234567890", parse("2023-10-04"), parse("2023-11-04"), MessPlan.MONTHY, 3000));
		custMap.put("abhi@abc.com", new Customer(106, "abhi", "singh", "abhi@abc.com", "abhi123", "akurdi", "1234567890",
				parse("2024-04-28"), parse("2021-08-28"), MessPlan.QUATERLY, 11700));
		return custMap;
	}
//calculateing plan end date
	public static LocalDate monthsByMessPlan(LocalDate reg, MessPlan plan) {
		LocalDate endPlanDate;
		if (plan == MessPlan.MONTHY) {
			endPlanDate = reg.plusMonths(1);
		} else if (plan == MessPlan.QUATERLY) {
			endPlanDate = reg.plusMonths(4);
		} else if (plan == MessPlan.HALFYEARLY) {
			endPlanDate = reg.plusMonths(6);
		} else {
			endPlanDate = reg.plusMonths(12);
		}
		return endPlanDate;
	}

	//changing password
	public static void changePassword(String email, String newPassword, Map<String, Customer> custMap)
			throws InvalidInputException {
		if (custMap.containsKey(email)) {
			Customer customer = custMap.get(email);
			customer.setPassword(newPassword);
			System.out.println("Password changed successfully.....");
		} else {
			throw new InvalidInputException("Email is not registered...");
		}
	}

}
