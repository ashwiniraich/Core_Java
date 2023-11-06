package tester;

import java.time.LocalDate;
import static utils.IOUtils.*;
import java.util.HashMap;
import static utils.CustomerUtils.*;
import static utils.CustomerValidations.*;
import java.util.Map;
import java.util.Scanner;

import com.core.Customer;
import com.core.MessPlan;

public class CustomerManagement {

	public static Map<String, Customer> custMap = new HashMap<>();

	public static void main(String[] args) {
		custMap = populateCustMap();
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			System.out.println("Enter file name: ");
			String file = sc.next();
			while (!exit) {
				try {
					System.out.println("--------------------------MESSPLAN-------------------------------");
					for (MessPlan mp : MessPlan.values()) {
						System.out.println(mp);
					}
					System.out.println("--------------------------MENU-------------------------------");
					System.out.println("1.SignUp\n2.SignIn\n3.Customer List\n4.Change password\n5.Sort by first name"
							+ "\n6.Sort by plan\n7.Sort by registration date\n8.Unsubscribe by plan monthwise(1,4,6,12)"
							+ "\n9.Make first letter of first name capital\n10.Display email of customer registered in month jan"
							+ "\n11.Count of customer registered for monthly plan\n12.Search customer lived in akurdi"
							+ "\n13.Discount customer with plan yearly\n14.Serialization\n15.Deserialization\n0.Exit");
					System.out.println("-----------------------------------------------------------------------------");
					System.out.println("Enter your choice: ");
					switch (sc.nextInt()) {
					case 0:
						exit = true;
						break;

					case 1:
						System.out.println(
								"Enter details:custid,fname,lname,email,password,address,phoneNo,plan,finalAmt");
						Customer customer = ValidateAllInputs(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.next(), sc.next().toUpperCase(), sc.nextDouble(), custMap);
						custMap.putIfAbsent(customer.getEmail(), customer);
						break;

					case 2:
						System.out.println("Enter email and password: ");
						ValidateCust(sc.next(), sc.next(), custMap);
						break;

					case 3:
						custMap.values().stream().forEach(System.out::println);
						break;

					case 4:
						System.out.println("Enter email and new password: ");
						changePassword(sc.next(), sc.next(), custMap);
						break;

					case 5:
						custMap.values().stream().sorted((c1, c2) -> c1.getFname().compareTo(c2.getFname()))
								.forEach(System.out::println);
						break;

					case 6:
						custMap.values().stream().sorted((c1, c2) -> c1.getPlan().compareTo(c2.getPlan()))
								.forEach(System.out::println);
						break;

					case 7:
						custMap.values().stream().sorted((c1, c2) -> c1.getRegDate().compareTo(c2.getRegDate()))
								.forEach(System.out::println);
						break;
		
					case 8:
						System.out.println("Enter the month(1,4,6,12): ");
						int month = sc.nextInt();
						if (month == 1) {
							custMap.values().removeIf(c -> c.getPlan().equals(MessPlan.MONTHY));
						}
						else if (month == 4) {
							custMap.values().removeIf(c -> c.getPlan().equals(MessPlan.QUATERLY));
						}
						else if (month == 6) {
							custMap.values().removeIf(c -> c.getPlan().equals(MessPlan.HALFYEARLY));
						}
						else if (month == 12) {
							custMap.values().removeIf(c -> c.getPlan().equals(MessPlan.YEARLY));
						}
						else {
							System.out.println("Enter valid month....");
							break;
						}
						System.out.println("Successfully unsubscribed.....");
						break;

					case 9:
						for (Customer cm : custMap.values()) {
							String fname = cm.getFname();
							String newFname = "";
							newFname = newFname.concat(((fname.substring(0, 1)).toUpperCase()) + fname.substring(1));
							cm.setFname(newFname);
						}
						break;

					case 10:
						custMap.values().stream().filter(c -> ((c.getRegDate()).getMonthValue()) == 01)
								.forEach(c -> System.out.println(c.getEmail()));
						break;

					case 11:
						long count = custMap.values().stream().filter(c -> c.getPlan().equals(MessPlan.MONTHY)).count();
						System.out.println("Count: " + count);
						break;

					case 12:
						custMap.values().stream().filter(c -> c.getAddress() == "akurdi").forEach(System.out::println);
						break;

					case 13:
						custMap.values().stream().filter(c -> c.getPlan().equals(MessPlan.YEARLY))
								.forEach(c -> c.setFinalAmt(c.getFinalAmt() * 0.8));
						break;

					case 14:
						storeCustDetails(file, custMap);
						break;

					case 15:
						System.out.println("Customer Details: ");
						System.out.println(restoreCustDetails(file));
						break;

					default:
						break;
					}

				} catch (Exception e) {
					System.out.println(e);
				}

			}
		}

	}

}
