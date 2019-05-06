package camposfx.scene.layout;

import campos.util.FXUtil;
import camposfx.scene.control.ButtonSearch;
import camposfx.scene.control.MyLabel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class OneStockTab extends StockSearchTab {
	private ButtonSearch btSearch;
	
	public OneStockTab() {
		super("One Stock");
		this.btSearch = new ButtonSearch(this);
		displayControls();
	}
	
	private void displayControls() {
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
		setContent(gridPane);
	}
}