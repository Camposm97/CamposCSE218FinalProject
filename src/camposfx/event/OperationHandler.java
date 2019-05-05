package camposfx.event;

import campos.model.Company;
import campos.model.ChosenOnes;
import campos.util.AlertFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OperationHandler implements EventHandler<ActionEvent> {
	private Company c;
	private String name;
	
	public OperationHandler(String name) {
		this.c = ChosenOnes.chosenOne;
		this.name = name.toUpperCase();
	}
	
	@Override
	public void handle(ActionEvent event) {
		switch(name) {
		case "INSERT":
			insertStockData();
			break;
		case "SEARCH":
			searchStockData();
			break;
		}
	}
	
	public void insertStockData() {
		if (c != null) {
			
		} else {
			AlertFactory.emitError("Solution: Please select a company to insert stock data to.");
		}
	}
	
	public void searchStockData() {
		if (c != null) {
			
		} else {
			AlertFactory.emitError("Solution: Please select a company to before searching for stock data.");
		}
	}
}
