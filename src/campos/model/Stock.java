package campos.model;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Stock implements Comparable<Stock>, Serializable {
	private LocalDate date;
	private double openValue;
	private double highValue;
	private double lowValue;
	private double closeValue;
	private int volume;
	
	public Stock(LocalDate date, double openValue, double highValue, double lowValue, double closeValue, int volume) {
		this.date = date;
		this.openValue = openValue;
		this.highValue = highValue;
		this.lowValue = lowValue;
		this.closeValue = closeValue;
		this.volume = volume;
	}

	public LocalDate getDate() {
		return date;
	}

	public double getOpenValue() {
		return openValue;
	}

	public double getHighValue() {
		return highValue;
	}

	public double getLowValue() {
		return lowValue;
	}

	public double getCloseValue() {
		return closeValue;
	}

	public int getVolume() {
		return volume;
	}

	@Override
	public int compareTo(Stock s) {
		return date.compareTo(s.date);
	}

	@Override
	public String toString() {
		return "Stock [date=" + date + ", openValue=" + openValue + ", highValue=" + highValue + ", lowValue="
				+ lowValue + ", closeValue=" + closeValue + ", volume=" + volume + "]";
	}
}
