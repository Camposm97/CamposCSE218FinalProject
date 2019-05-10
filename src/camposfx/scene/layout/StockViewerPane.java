package camposfx.scene.layout;

import java.time.LocalDate;

import campos.model.Company;
import camposfx.util.FXUtil;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.BorderPane;

@Deprecated
public class StockViewerPane extends BorderPane {
//	private Company c;
	private LineChart<LocalDate, Number> lineChart;
	
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
