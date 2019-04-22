package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import model.Company;
import model.Stock;

public class DataOperator {
	public static final String DAILY_AAPL = "systemData/alphaVantage/daily_AAPL.csv"; 
	public static final String DAILY_AMZN = "systemData/alphaVantage/daily_AMZN.csv";
	private static final String COMP_BAG_SRC = "systemData/companyBag.dat";
	private static final String DELIMITER = ",";
	
	
	public static void main(String[] args) {
		writeObject(loadCompanyList(), COMP_BAG_SRC);
	}
	
	/**
	 * Returns a LinkedList containing data from companyBag.dat
	 * @return LinkedList<Company>
	 */
	@SuppressWarnings("unchecked")
	public static LinkedList<Company> loadCompanyBag() {
		LinkedList<Company> list = (LinkedList<Company>) readObject(COMP_BAG_SRC);
		System.out.println("Found " + list.size() + " Companies");
		return list;
	}
	
	/**
	 * Returns a LinkedList containing data from alphaVantage .csv files
	 * @return LinkedList<Company>
	 */
	public static LinkedList<Company> loadCompanyList() {
		Company compApple = new Company("Apple", readAlphaVantageFile(DAILY_AAPL));
		Company compAmzn = new Company("Amazon", readAlphaVantageFile(DAILY_AMZN));
		LinkedList<Company> companyList = new LinkedList<>();
		companyList.add(compApple);
		companyList.add(compAmzn);
		return companyList;
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
	
	public static Object readObject(String src) {
		File file = new File(src);
		Object o = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			o = ois.readObject();
			ois.close();
			System.out.println("Successfully read Object from " + file);

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	/**
	 * Reads any file that extends .csv from AlphaVantage API that used function: DAILY
	 * @param src
	 */
	public static LinkedList<Stock> readAlphaVantageFile(String src) {
		File file = new File(src);
		FileBuilt fileBuilt = new FileBuilt(file);
		LinkedList<String> contentList = fileBuilt.getContentList();
		LinkedList<Stock> stockList = new LinkedList<>();
		
		// Set i = 1 to skip first element of contentList (labels)
		for (int i = 1; i < contentList.size(); i++) {
			String currentLine = contentList.get(i);
			String[] tokens = currentLine.split(DELIMITER);
			Stock stock = readTokens(tokens);
			stockList.add(stock);
		}
		System.out.println("Successfully read from " + file);
		return stockList;
	}
	
	private static Stock readTokens(String[] tokens) {
		String[] dateTokens = tokens[0].split("-");
		int year = Integer.parseInt(dateTokens[0]);
		int month = Integer.parseInt(dateTokens[1]);
		int date = Integer.parseInt(dateTokens[2]);
		GregorianCalendar gCal = new GregorianCalendar(year, (month - 1), date);
		double openValue = Double.parseDouble(tokens[1]);
		double highValue = Double.parseDouble(tokens[2]);
		double lowValue = Double.parseDouble(tokens[3]);
		double closeValue = Double.parseDouble(tokens[4]);
		int volume = Integer.parseInt(tokens[5]);
		
		Stock stock = new Stock(gCal, openValue, highValue, lowValue, closeValue, volume);
		return stock;
	}
}
