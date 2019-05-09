package camposfx.scene.layout;

import campos.model.ChosenOnes;
import campos.model.Company;
import javafx.scene.control.TabPane;

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
		super.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		super.getTabs().addAll(new OneStockSearchTab(c));
	}
}
