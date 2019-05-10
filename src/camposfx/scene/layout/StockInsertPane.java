package camposfx.scene.layout;

import campos.model.ChosenOnes;
import campos.model.Company;
import camposfx.scene.control.ButtonInsert;
import camposfx.scene.control.DoubleTextField;
import camposfx.util.FXUtil;
import camposfx.scene.control.MyLabel;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class StockInsertPane extends BorderPane {
	private Company c;
	private DatePicker datePicker;
	private DoubleTextField tfOpenValue, tfHighValue, tfLowValue, tfCloseValue, tfVolume;
	private Button btInsert;
	
	public StockInsertPane() {
		initControls();
		displayControls();
	}
	
	public Company getC() {
		return c;
	}
	
	public DatePicker getDatePicker() {
		return datePicker;
	}

	public DoubleTextField getTfOpenValue() {
		return tfOpenValue;
	}

	public DoubleTextField getTfHighValue() {
		return tfHighValue;
	}

	public DoubleTextField getTfLowValue() {
		return tfLowValue;
	}

	public DoubleTextField getTfCloseValue() {
		return tfCloseValue;
	}

	public DoubleTextField getTfVolume() {
		return tfVolume;
	}
	
	public void clearAll() {
		tfOpenValue.clear();
		tfHighValue.clear();
		tfLowValue.clear();
		tfCloseValue.clear();
		tfVolume.clear();
	}

	private void initControls() {
		c = ChosenOnes.company;
		datePicker = FXUtil.loadInsertDatePicker();
		tfOpenValue = new DoubleTextField();
		tfHighValue = new DoubleTextField();
		tfLowValue = new DoubleTextField();
		tfCloseValue = new DoubleTextField();
		tfVolume = new DoubleTextField();
		btInsert = new ButtonInsert(this);
	}
	
	private void displayControls() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_CENTER);
		gridPane.setPadding(FXUtil.DEFAULT_INSETS);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.add(new MyLabel("Adding Stock Data to: " + c.getName() + " (" + c.getSymbol() + ")", Font.font(20)), 0, 0, 2, 1);
		gridPane.addRow(1, new Label("Date:"), FXUtil.asHBox(datePicker));
		gridPane.addRow(2, new Label("Open Value:"), tfOpenValue);
		gridPane.addRow(3, new Label("High Value:"), tfHighValue);
		gridPane.addRow(4, new Label("Low Value:"), tfLowValue);
		gridPane.addRow(5, new Label("Close Value:"), tfCloseValue);
		gridPane.addRow(6, new Label("Volume:"), tfVolume);
		
		VBox vBox = FXUtil.asVBox(btInsert);
		vBox.setPadding(FXUtil.DEFAULT_INSETS);
		super.setBottom(vBox);
		super.setCenter(gridPane);
	}
}
