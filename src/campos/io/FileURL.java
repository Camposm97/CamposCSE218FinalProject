package campos.io;

public class FileURL {
	public static final String DAILY_AAPL = "systemData/alphaVantage/daily_AAPL.csv"; 
	public static final String DAILY_AMZN = "systemData/alphaVantage/daily_AMZN.csv";
	public static final String COMP_BAG_SRC = "systemData/companyBag.dat";
	
	public static void main(String[] args) {
		DataSaver.writeObject(DataLoader.loadCompanyList(), COMP_BAG_SRC);
	}
}
