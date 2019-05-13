package camposfx.scene.layout;

import campos.model.Company;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class StockSearchTabPane extends TabPane {
	private Company c;

	public StockSearchTabPane(Company c) {
		this.c = c;
		Tab tab1 = new Tab("One Stock Search");
		tab1.setContent(new StockSearchPane(c));
		Tab tab2 = new Tab("Stock Range Picker");
		tab2.setContent(new StockRangePickerPane(new StockSearchPane(c), new StockSearchPane(c)));
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		this.getTabs().addAll(tab1, tab2);
	}

	public Company getC() {
		return c;
	}
}
