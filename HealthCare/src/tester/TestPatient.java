package tester;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static utils.PatientValidations.*;
import static utils.PatientUtils.*;
import com.core.Patient;
import com.core.RoomType;
import static utils.IOUtils.*;

public class TestPatient {
	public static Map<Integer,Patient> pmap=new HashMap<>();
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			pmap=populatePatient();
			boolean exit=false;
			System.out.println("Enter file name: ");
			String file=sc.next();
			while (!exit) {
				try {
					System.out.println("0 Exit\n1 add patient records.\r\n"
							+ "2 display all the patients.\r\n"
							+ "3 display all the patient who has annualIncome < 30000 then they can applicable for ”Rajeev Gandhi Yojana”. \r\n"
							+ "4 display all the patient details of room type chosen from the user.\r\n"
							+ "5 Remove all the patient who has disease “Diabetese”.    \r\n"
							+ "6 Change the roomType of a patient who is from “ICU” to SPECIAL room.\r\n"
							+ "7 display all the patients who’s age  >75.\r\n"
							+ "8 Sort the patients based on gender.\r\n"
							+ "9 serialization.\r\n"
							+"10 deserialization");
					System.out.println("Enter your choice: ");
					switch (sc.nextInt()) {
					case 0:
						exit=true;
						break;
					case 1:
						System.out.println("Enter details:serialNo,pname,age,gender,address,phoneNo,disease,"+
								 "bill,annualIncome,room");
						Patient inputs = validateAllInputs(sc.nextInt(), sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(),sc.nextDouble(), sc.nextDouble(), sc.next().toUpperCase(), pmap);
						pmap.putIfAbsent(inputs.getSerialNo(), inputs);
						break;
						
					case 2:
						for(Patient p:pmap.values()) {
							System.out.println(p);
						}
						break;
						
					case 3:
						System.out.println("Patients applicable for Rajeev Gandhi Yojana: ");
						pmap.values().stream()
						.filter(p->p.getAnnualIncome()<30000)
						.forEach(System.out::println);
						break;
						
					case 4:
						System.out.println("Enter Room Type: ");
						RoomType room=RoomType.valueOf(sc.next().toUpperCase());
						pmap.values().stream()
						.filter(p->p.getRoom()==room)
						.forEach(System.out::println);
						break;
						
					case 5:
						pmap.values()
						.removeIf(p->p.getDisease()=="diabetes");
						System.out.println("Removed succefully.....");
						break;
						
					case 6:
						pmap.values().stream()
						.filter(p->p.getRoom().equals(RoomType.ICU))
						.forEach(p->p.setRoom(RoomType.SPECIAL));
						System.out.println("Successfully changed....");
						break;
						
					case 7:
						pmap.values().stream()
						.filter(p->(p.getAge())>75)
						.forEach(System.out::println);
						break;
						
					case 8:
						pmap.values().stream()
						.sorted((p1,p2)->p1.getGender().compareTo(p2.getGender()))
						.forEach(System.out::println);
						break;
						
					case 9:
						StoreDetails(file, pmap);
						break;
						
					case 10:
						System.out.println("Patient details: ");
						System.out.println(reStoreDetails(file));
						break;
						

					}
					
				} catch (Exception e) {
					sc.nextLine();
					System.out.println(e);
					e.printStackTrace();
				}
				
			}
		}

	}

}
