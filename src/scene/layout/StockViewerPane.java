package scene.layout;

import javafx.scene.chart.LineChart;
import javafx.scene.layout.StackPane;
import model.Company;
import util.FXUtil;

public class StockViewerPane extends StackPane {
	private Company c;
	private LineChart<Number, Number> lineChart;
	
	public StockViewerPane(Company c) {
		this.c = c;
		this.lineChart = FXUtil.loadStockChart(c);
		displayControls();
	}
	
	private void displayControls() {
		this.setPadding(FXUtil.DEFAULT_INSETS);
		this.getChildren().add(lineChart);
	}
}
