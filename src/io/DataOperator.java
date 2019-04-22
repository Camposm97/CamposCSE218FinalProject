package io;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import model.Stock;

public class DataOperator {
	public static final String DAILY_AAPL = "systemData/daily_AAPL.csv"; 
	public static final String DAILY_AMZN = "systemData/daily_AMZN.csv";
	private static final String DELIMITER = ",";
	
	/**
	 * Reads any file that extends .csv from AlphaVantage API
	 * @param src
	 */
	public static void loadStockData(String src) {
		MyFile file = new MyFile(DAILY_AAPL);
		LinkedList<String> contentList = file.getContentList();
		
		// Set i = 1 to skip first element of contentList
		for (int i = 1; i < contentList.size(); i++) {
			String currentLine = contentList.get(i);
			String[] tokens = currentLine.split(DELIMITER);
			
			Stock stock = readTokens(tokens);
			
			System.out.println(stock);
		}
		
		System.out.println("Successfully loaded Apple Stock Data!");
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
	
	public static void main(String[] args) {
		loadStockData(DAILY_AAPL);
	}
}
