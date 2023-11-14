package utils;

import java.time.LocalDate;
import java.util.Map;
import static tester.TestPatient.*;
import com.core.Patient;
import com.core.RoomType;

public class PatientUtils {
	
	public static Map<Integer,Patient> populatePatient(){
		pmap.put(1, new Patient(1, "patient1", 50, "female","Dehli", "1234567890", "malaria", LocalDate.parse("2023-11-12"), 2000,50000, RoomType.GENERAL));
		pmap.put(2, new Patient(2, "patient2", 80, "male","Mumbai", "1234567890", "diabetes", LocalDate.parse("2023-11-12"), 3000,25000, RoomType.SEMISPECIAL));
		pmap.put(3, new Patient(3, "patient3", 60, "male","Pune", "1234567890", "cancer", LocalDate.parse("2023-11-12"), 7000,80000, RoomType.ICU));
		pmap.put(4, new Patient(4, "patient4", 40, "female","Indore", "1234567890", "cancer", LocalDate.parse("2023-11-12"), 7000,30000, RoomType.ICU));
		pmap.put(5, new Patient(5, "patient5", 55, "female","Mumbai", "1234567890", "cancer", LocalDate.parse("2023-11-12"), 7000,45000, RoomType.ICU));
		pmap.put(6, new Patient(6, "patient6", 85, "male","Dehli", "1234567890", "diabetes", LocalDate.parse("2023-11-12"), 2000,15000, RoomType.GENERAL));
		pmap.put(7, new Patient(7, "patient7", 40, "male","Mumbai", "1234567890", "malaria", LocalDate.parse("2023-11-12"), 5000,20000, RoomType.SPECIAL));
		pmap.put(7, new Patient(8, "patient8", 90, "female","Pune", "1234567890", "diabetes", LocalDate.parse("2023-11-12"), 5000,75000, RoomType.SPECIAL));
		return pmap;
		
	}

}
