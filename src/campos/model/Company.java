package campos.model;

import java.io.Serializable;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class Company implements Comparable<Company>, Serializable {
	private String name;
	private Symbol symbol;
	private LinkedList<Stock> stockList;
	
	public Company(String name) {
		this.name = name;
		this.stockList = new LinkedList<>();
	}
	
	public Company(String name, Symbol symbol, LinkedList<Stock> stockList) {
		this.name = name;
		this.symbol = symbol;
		this.stockList = stockList;
	}
	
	public String getName() {
		return name;
	}
	
	public Symbol getSymbol() {
		return symbol;
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
		return symbol.compareTo(c.symbol);
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", symbol=" + symbol + ", stockListSize=" + stockList.size() + "]";
	}
}
