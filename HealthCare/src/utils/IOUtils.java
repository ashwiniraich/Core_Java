package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.core.Patient;

public interface IOUtils {

	public static void StoreDetails(String file, Map<Integer, Patient> pmap) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
				out.writeObject(pmap);
				System.out.println("details stored....");
			
		}

	}
	
	@SuppressWarnings("unchecked")
	public static Map<Integer, Patient> reStoreDetails(String file){
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
				return (Map<Integer, Patient>) in.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return new HashMap<>();
	}
}
