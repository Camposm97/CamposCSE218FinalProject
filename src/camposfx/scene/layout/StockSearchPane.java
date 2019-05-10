package camposfx.scene.layout;

import campos.model.Company;
import camposfx.scene.control.MyLabel;
import camposfx.scene.control.NonEditableTextField;
import camposfx.scene.control.StockDatePicker;
import camposfx.util.FXUtil;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class StockSearchPane extends GridPane {
	protected Company c;
	private StockDatePicker datePicker;
	protected TextField tfOpenValue, tfHighValue, tfLowValue, tfCloseValue, tfVolume;

	public StockSearchPane(Company c) {
		this.c = c;
		this.datePicker = new StockDatePicker(this);
		tfOpenValue = new NonEditableTextField();
		tfHighValue = new NonEditableTextField();
		tfLowValue = new NonEditableTextField();
		tfCloseValue = new NonEditableTextField();
		tfVolume = new NonEditableTextField();
		displayControls();
	}
	
	private void displayControls() {
		this.setAlignment(Pos.TOP_CENTER);
		this.setPadding(FXUtil.DEFAULT_INSETS);
		this.setHgap(10);
		this.setVgap(10);
		
		this.add(new MyLabel("Searching Stock Data in: " + c.getName() + " (" + c.getSymbol() + ")", Font.font(20)), 0, 0, 2, 1);
		this.addRow(1, new Label("Date:"), FXUtil.asHBox(datePicker));
		this.addRow(2, new Label("Open Value:"), tfOpenValue);
		this.addRow(3, new Label("High Value:"), tfHighValue);
		this.addRow(4, new Label("Low Value:"), tfLowValue);
		this.addRow(5, new Label("Close Value:"), tfCloseValue);
		this.addRow(6, new Label("Volume:"), tfVolume);
	}
	
	public Company getC() {
		return c;
	}
	
	public StockDatePicker getDatePicker() {
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
}
