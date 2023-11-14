package utils;

import java.time.LocalDate;
import java.util.Map;

import com.core.Patient;
import com.core.RoomType;

import custom_exception.InvalidInputException;

public class PatientValidations {

	public static double validateRoomType(RoomType room, double charge) throws InvalidInputException {
		if (room.getCharges() != charge) {
			throw new InvalidInputException("The charges are invalid......");
		} else {
			return charge;
		}
	}

	public static String validatePhoneNo(String phone) throws InvalidInputException {
		String p = "^\\d{10}$";
		if (phone.length()!=10) {
			throw new InvalidInputException("Invalid number length...");
		} else {
			if (!(phone.matches(p))) {
				throw new InvalidInputException("Enetred other than numbers.....");
			}
			else {
				return phone;
			}
		}
	}

	public static Patient validateAllInputs(int serialNo, String pname, int age, String gender, String address,
			String phoneNo, String disease, double bill, double annualIncome, String room, Map<Integer, Patient> pmap)
			throws InvalidInputException {
		String no = validatePhoneNo(phoneNo);
		RoomType roomType = RoomType.valueOf(room);
		LocalDate date = LocalDate.now();
		double validatedBill = validateRoomType(roomType, bill);
		return new Patient(serialNo, pname, age, gender, address, no, disease, date, validatedBill, annualIncome,
				roomType);

	}
}
