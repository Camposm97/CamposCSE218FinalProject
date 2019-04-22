package model;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Stock implements Serializable {
	private GregorianCalendar gCal;
	private double openValue;
	private double highValue;
	private double lowValue;
	private double closeValue;
	private int volume;
	
	public Stock(GregorianCalendar gCal, double openValue, double highValue, double lowValue, double closeValue, int volume) {
		this.gCal = gCal;
		this.openValue = openValue;
		this.highValue = highValue;
		this.lowValue = lowValue;
		this.closeValue = closeValue;
		this.volume = volume;
	}

	public GregorianCalendar getgCal() {
		return gCal;
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
	public String toString() {
		return "Stock [gCal=" + gCal.getTime() + ", openValue=" + openValue + ", highValue=" + highValue + ", lowValue="
				+ lowValue + ", closeValue=" + closeValue + ", volume=" + volume + "]";
	}
}
