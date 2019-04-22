package model;

import java.io.Serializable;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class Company implements Comparable<Company>, Serializable {
	private String name;
	private LinkedList<Stock> stockList;
	
	public Company(String name) {
		this.name = name;
		this.stockList = new LinkedList<>();
	}
	
	public Company(String name, LinkedList<Stock> stockList) {
		this.name = name;
		this.stockList = stockList;
	}
	
	public String getName() {
		return name;
	}
	
	public LinkedList<Stock> getStockList() {
		return stockList;
	}
	
	public void displayStocks() {
		for (Stock s : stockList)
			System.out.println(name + ": " + s);
	}
	
	@Override
	public int compareTo(Company c) {
		return name.compareTo(c.name);
	}
}
