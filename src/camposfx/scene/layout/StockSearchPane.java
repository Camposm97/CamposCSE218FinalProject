package camposfx.scene.layout;

import campos.model.ChosenOnes;
import campos.model.Company;
import campos.util.FXUtil;
import camposfx.scene.control.ButtonSearch;
import camposfx.scene.control.MyLabel;
import camposfx.scene.control.NonEditTextField;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class StockSearchPane extends TabPane {
	private Company c;

	public StockSearchPane() {
		initControls();
		displayControls();
	}

	public Company getC() {
		return c;
	}

	private void initControls() {
		c = ChosenOnes.company;
	}

	private void displayControls() {
		VBox vBox = FXUtil.asVBox(btSearch);
		vBox.setPadding(FXUtil.DEFAULT_INSETS);
		super.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		super.getTabs().addAll(loadTabOneStock(), loadTabRangeStock());
	}
	
	private Tab loadTabOneStock() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_CENTER);
		gridPane.setPadding(FXUtil.DEFAULT_INSETS);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		gridPane.add(new MyLabel("Searching Stock Data in: " + c.getName() + " (" + c.getSymbol() + ")", Font.font(20)), 0, 0, 2, 1);
		gridPane.addRow(1, new Label("Date:"), FXUtil.asHBox(datePicker));
		gridPane.addRow(2, new Label("Open Value:"), tfOpenValue);
		gridPane.addRow(3, new Label("High Value:"), tfHighValue);
		gridPane.addRow(4, new Label("Low Value:"), tfLowValue);
		gridPane.addRow(5, new Label("Close Value:"), tfCloseValue);
		gridPane.addRow(6, new Label("Volume:"), tfVolume);
		Tab tab = new Tab("One Stock");
		tab.setContent(gridPane);
		return tab;
	}
	
	private Tab loadTabRangeStock() {
		Tab tab = new Tab("Range of Stocks");
		return tab;
	}
}
