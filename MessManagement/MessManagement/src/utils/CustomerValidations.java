package utils;

import java.time.LocalDate;
import static utils.CustomerUtils.*;
import java.util.Map;

import com.core.Customer;
import com.core.MessPlan;

import custom_exceptions.InvalidInputException;

public class CustomerValidations {

	// Validating Email
	public static String ValidateEmail(String email, Map<String, Customer> custMap) throws InvalidInputException {
		String reg = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9]*\\.(com|org|net)";
		if (!(email.matches(reg))) {
			throw new InvalidInputException("Invalid format of email....");
		}
		return email;
	}

	// Validating PhoneNo
	public static void ValidatePhoneNo(String phoneNo, Map<String, Customer> custMap) throws InvalidInputException {
		String reg = "^\\d{10}$";
		if (phoneNo.length() <= 10) {
			if (!(phoneNo.matches(reg))) {
				throw new InvalidInputException("Entered other than numberes....");
			}
		} else {
			throw new InvalidInputException("Length is greater than 10!!!");
		}
	}

	// validating customer for login by validating email and password
	public static void ValidateCust(String email, String password, Map<String, Customer> custMap)
			throws InvalidInputException {
		if (custMap.containsKey(email)) {
			Customer customer = custMap.get(email);
			if ((customer.getPassword()).equals(password)) {
				System.out.println("login successful....");
			} else {
				throw new InvalidInputException("Password is incorrect....");
			}
		} else {
			throw new InvalidInputException("Email is not registered.....");
		}
	}

	// Parseing and validating MessPlan
	public static MessPlan parseNValidatePlan(String plan, double fees) throws InvalidInputException {
		if (MessPlan.valueOf(plan).getFees() != fees) {
			throw new InvalidInputException("invalid amount.....");
		}
		return MessPlan.valueOf(plan);

	}

	// validate all function
	public static Customer ValidateAllInputs(int custid, String fname, String lname, String email, String password,
			String address, String phoneNo, String plan, double finalAmt, Map<String, Customer> custMap)
			throws InvalidInputException {
		MessPlan validatePlan = parseNValidatePlan(plan, finalAmt);
		String validateEmail = ValidateEmail(email, custMap);
		ValidatePhoneNo(phoneNo, custMap);
		LocalDate regDate = LocalDate.now();
		LocalDate planEndDate = monthsByMessPlan(regDate, validatePlan);
		return new Customer(custid, fname, lname, validateEmail, password, address, phoneNo, regDate, planEndDate,
				validatePlan, finalAmt);
	}

}
