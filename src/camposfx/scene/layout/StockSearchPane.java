package camposfx.scene.layout;

import campos.model.ChosenOnes;
import campos.model.Company;
import camposfx.scene.control.ButtonSearch;
import camposfx.scene.control.NonEditTextField;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;

public class StockSearchPane extends OperationPane {
	private Company c;
	private DatePicker datePicker;
	private TextField tfOpenValue, tfHighValue, tfLowValue, tfCloseValue, tfVolume;
	private Button btSearch;

	public StockSearchPane() {
		initControls();
		displayControls();
	}

	public Company getC() {
		return c;
	}

	public DatePicker getDatePicker() {
		return datePicker;
	}

	public TextField getTfOpenValue() {
		return tfOpenValue;
	}

	public TextField getTfHighValue() {
		return tfHighValue;
	}

	public TextField getTfLowValue() {
		return tfLowValue;
	}

	public TextField getTfCloseValue() {
		return tfCloseValue;
	}

	public TextField getTfVolume() {
		return tfVolume;
	}

	private void initControls() {
		c = ChosenOnes.company;
		datePicker = new DatePicker();
		tfOpenValue = new NonEditTextField();
		tfHighValue = new NonEditTextField();
		tfLowValue = new NonEditTextField();
		tfCloseValue = new NonEditTextField();
		tfVolume = new NonEditTextField();
		btSearch = new ButtonSearch(this);
	}

	private void displayControls() {
		Tab tab = new Tab("Search For One Stock");
		
		TabPane tabPane = new TabPane();
		tabPane.getTabs().addAll(tab);
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		super.setCenter(tabPane);
	}
}
