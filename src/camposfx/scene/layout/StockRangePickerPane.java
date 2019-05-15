package camposfx.scene.layout;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import campos.model.Company;
import campos.model.Stock;
import camposfx.scene.control.AverageTextField;
import camposfx.scene.control.StockDatePicker;
import camposfx.util.FXUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StockRangePickerPane extends BorderPane {
	private Label lblAvg;
	private AverageTextField tfOpen, tfHigh, tfLow, tfClose, tfVolume;
	private StockDatePicker oldestDatePicker;
	private StockDatePicker latestDatePicker;
	private Company c;

	public StockRangePickerPane(StockSearchPane oldStockPane, StockSearchPane lateStockPane) {
		this.lblAvg = new Label("Average:");
		this.tfOpen = new AverageTextField("Open Value");
		this.tfHigh = new AverageTextField("High Value");
		this.tfLow = new AverageTextField("Low Value");
		this.tfClose = new AverageTextField("Close Value");
		this.tfVolume = new AverageTextField("Volume");
		this.oldestDatePicker = oldStockPane.getDatePicker();
		this.latestDatePicker = lateStockPane.getDatePicker();
		this.oldestDatePicker.addEventHandler(ActionEvent.ACTION, new StockRangePickerHandler());
		this.latestDatePicker.addEventHandler(ActionEvent.ACTION, new StockRangePickerHandler());
		this.c = oldStockPane.getC();
		this.setLeft(oldStockPane);
		this.setCenter(getCenterPane());
		this.setRight(lateStockPane);
		this.setPadding(FXUtil.DEFAULT_INSETS);
	}
	
	public GridPane getCenterPane() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_CENTER);
		gridPane.setPadding(FXUtil.DEFAULT_INSETS);
		gridPane.setVgap(10);
		gridPane.addColumn(0, lblAvg, tfOpen, tfHigh, tfLow, tfClose, tfVolume);
		return gridPane;
	}
	
	private class StockRangePickerHandler implements EventHandler<ActionEvent> {
		private LocalDate oldDate;
		private LocalDate lateDate;
		private double avgOpen, avgHigh, avgLow, avgClose;
		private int avgVolume;
		
		@Override
		public void handle(ActionEvent e) {
			oldDate = oldestDatePicker.getValue();
			lateDate = latestDatePicker.getValue();
			if (oldDate.compareTo(lateDate) < 0) { // Is oldDate older than lateDate?
				calcAveragePrices();
			}
		}
		
		public void calcAveragePrices() {
			Map<LocalDate, Stock> subStockMap = c.getStockMap().subMap(oldDate, lateDate.plusDays(1));			
			Set<LocalDate> dateSet = subStockMap.keySet();
			
			Stage stage = new Stage();
			LineChart<String, Number> lineChart = FXUtil.loadStockChart(subStockMap);
			stage.setScene(new Scene(new StackPane(lineChart)));
			stage.show();
			
			avgOpen = 0; avgHigh = 0; avgLow = 0; avgClose = 0; avgVolume = 0;
			
			for (LocalDate localDate : dateSet) {
				Stock stock = subStockMap.get(localDate);
				avgOpen += stock.getOpenValue();
				avgHigh += stock.getHighValue();
				avgLow += stock.getLowValue();
				avgClose += stock.getCloseValue();
				avgVolume += stock.getVolume();
//				System.out.println(stock);
			}
			
			avgOpen /= subStockMap.size();
			avgHigh /= subStockMap.size();
			avgLow /= subStockMap.size();
			avgClose /= subStockMap.size();
			avgVolume /= subStockMap.size();
			
			displayAvgValues();
			
//			System.out.println();
//			System.out.println("Average Open Value: " + avgOpenValue);
//			System.out.println("Average High Value: " + avgHighValue);
//			System.out.println("Average Low Value: " + avgLowValue);
//			System.out.println("Average Close Value: " + avgCloseValue);
//			System.out.println("Average Volume: " + avgVolume);
//			System.out.println();
		}
		
		public void displayAvgValues() {
			lblAvg.setText("Average: (" + oldDate + " - " + lateDate + ")");
			tfOpen.setText(String.format("%-10.2f", avgOpen));
			tfHigh.setText(String.format("%-10.2f", avgHigh));
			tfLow.setText(String.format("%-10.2f", avgLow));
			tfClose.setText(String.format("%-10.2f", avgClose));
			tfVolume.setText(String.format("%-10d", avgVolume));
		}
	}
}
