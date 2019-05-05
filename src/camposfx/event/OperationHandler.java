package camposfx.event;

import campos.model.ChosenOnes;
import campos.model.Company;
import campos.util.AlertFactory;
import camposfx.scene.layout.StockInsertPane;
import camposfx.scene.layout.StockSearchPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OperationHandler implements EventHandler<ActionEvent> {
	private String name;
	
	public OperationHandler(String name) {
		this.name = name.toUpperCase();
	}
	
	@Override
	public void handle(ActionEvent event) {
		switch(name) {
		case "INSERT":
			toInsertPane();
			break;
		case "SEARCH":
			toSearchPane();
			break;
		}
	}
	
	public void toInsertPane() {
		Company c = ChosenOnes.company;
		if (c != null) {
			ChosenOnes.root.setCenter(new StockInsertPane());
		} else {
			AlertFactory.emitError("Solution: Please select a company to insert stock data to.");
		}
	}
	
	public void toSearchPane() {
		Company c = ChosenOnes.company;
		if (c != null) {
			ChosenOnes.root.setCenter(new StockSearchPane());
		} else {
			AlertFactory.emitError("Solution: Please select a company to before searching for stock data.");
		}
	}
}
