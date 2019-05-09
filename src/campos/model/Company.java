package campos.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.TreeMap;

@SuppressWarnings("serial")
public class Company implements Comparable<Company>, Serializable {
	private String name;
	private Symbol symbol;
	private TreeMap<LocalDate, Stock> stockMap;
	
	public Company(String name) {
		this.name = name;
		this.stockMap = new TreeMap<>();
	}
	
	public Company(String name, Symbol symbol, TreeMap<LocalDate, Stock> stockMap) {
		this.name = name;
		this.symbol = symbol;
		this.stockMap = stockMap;
	}
	
	public String getName() {
		return name;
	}
	
	public Symbol getSymbol() {
		return symbol;
	}
	
	public TreeMap<LocalDate, Stock> getStockMap() {
		return stockMap;
	}
	
	@Override
	public int compareTo(Company c) {
		return symbol.compareTo(c.symbol);
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", symbol=" + symbol + ", stockListSize=" + stockMap.size() + "]";
	}
}
