package camposfx.scene.layout;

import campos.model.Company;
import campos.util.FXUtil;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.BorderPane;

public class StockViewerPane extends BorderPane {
//	private Company c;
	private LineChart lineChart;
	
	public StockViewerPane(Company c) {
//		this.c = c;
		this.lineChart = FXUtil.loadStockChart(c);
		displayControls();
	}
	
	private void displayControls() {
		this.setPadding(FXUtil.DEFAULT_INSETS);
		this.setCenter(lineChart);
	}
}
