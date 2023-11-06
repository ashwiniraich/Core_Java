package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.core.Customer;

public class IOUtils {

	public static void storeCustDetails(String file,Map<String,Customer> custMap) throws FileNotFoundException, IOException {
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file))){
			out.writeObject(custMap);
			System.out.println("Details have been stored.....");
		}
	}
		
		public static Object restoreCustDetails(String file) throws FileNotFoundException, IOException, ClassNotFoundException {
			try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(file))){
				return in.readObject();
			}
		}
}
