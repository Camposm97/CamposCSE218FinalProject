package campos.model;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Stock implements Comparable<Stock>, Serializable {
	private LocalDate localDate;
	private double openValue;
	private double highValue;
	private double lowValue;
	private double closeValue;
	private int volume;
	
	public Stock(LocalDate localDate, double openValue, double highValue, double lowValue, double closeValue, int volume) {
		this.localDate = localDate;
		this.openValue = openValue;
		this.highValue = highValue;
		this.lowValue = lowValue;
		this.closeValue = closeValue;
		this.volume = volume;
	}

	public LocalDate getLocalDate() {
		return localDate;
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
		return localDate.compareTo(s.localDate);
	}

	@Override
	public String toString() {
		return "Stock [date=" + localDate + ", openValue=" + openValue + ", highValue=" + highValue + ", lowValue="
				+ lowValue + ", closeValue=" + closeValue + ", volume=" + volume + "]";
	}
}
