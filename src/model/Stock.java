package model;

import java.util.GregorianCalendar;

public class Stock {
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



	public void setgCal(GregorianCalendar gCal) {
		this.gCal = gCal;
	}

	public double getOpenValue() {
		return openValue;
	}

	public void setOpenValue(double openValue) {
		this.openValue = openValue;
	}

	public double getHighValue() {
		return highValue;
	}

	public void setHighValue(double highValue) {
		this.highValue = highValue;
	}

	public double getLowValue() {
		return lowValue;
	}

	public void setLowValue(double lowValue) {
		this.lowValue = lowValue;
	}

	public double getCloseValue() {
		return closeValue;
	}

	public void setCloseValue(double closeValue) {
		this.closeValue = closeValue;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Stock [gCal=" + gCal.getTime() + ", openValue=" + openValue + ", highValue=" + highValue + ", lowValue="
				+ lowValue + ", closeValue=" + closeValue + ", volume=" + volume + "]";
	}
}
