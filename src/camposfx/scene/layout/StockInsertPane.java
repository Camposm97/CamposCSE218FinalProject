package camposfx.scene.layout;

import java.time.LocalDate;

import campos.model.Company;
import campos.model.ChosenOnes;
import javafx.scene.control.DatePicker;

public class StockInsertPane extends OperationPane {
	private Company c;
	private DatePicker datePicker;
	
	public StockInsertPane() {
		this.c = ChosenOnes.chosenOne;
		this.datePicker = new DatePicker(LocalDate.now());
	}
	
	
}
