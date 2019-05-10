package campos.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import campos.model.Company;

public class DataSaver implements Sources {
	/**
	 * Run this to reset the Company Data back to .csv files
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Company> companyList = DataLoader.loadParsedCompanyData();
		saveCompanyBag(companyList); 
	}
	
	public static void saveCompanyBag(LinkedList<Company> bag) {
		writeObject(bag, COMPANY_BAG);
	}
	
	/**
	 * Parameter trgt should only have the file name.  The file is automatically 
	 * stored in systemData
	 * @param o
	 * @param trgt
	 */
	public static void writeObject(Object o, String trgt) {
		File file = new File(trgt);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(o);
			oos.close();
			System.out.println("Successfully wrote Object to " + file);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
