package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import model.Stock;

public class DataOperator {
	public static final String DAILY_AAPL = "systemData/alphaVantage/daily_AAPL.csv"; 
	public static final String DAILY_AMZN = "systemData/alphaVantage/daily_AMZN.csv";
	private static final String BIN_SRC = "systemData/stockHistory/";
	private static final String DELIMITER = ",";
	
	public static void main(String[] args) {
		writeObject(readAlphaVantageFile(DAILY_AAPL), "stocksApple.dat");
	}
	
	/**
	 * Parameter trgt should only have the file name.  The file is automatically stored in systemData/dat
	 * @param o
	 * @param trgt
	 */
	public static void writeObject(Object o, String trgt) {
		File file = new File(BIN_SRC + trgt);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(o);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Successfully wrote Object to " + file);
	}
	
	public static Object readObject(String src) {
		File file = new File(src);
		Object o = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			o = ois.readObject();
			ois.close();
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
