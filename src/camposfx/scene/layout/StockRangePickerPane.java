package camposfx.scene.layout;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import campos.model.Company;
import campos.model.Stock;
import camposfx.scene.control.AverageTextField;
import camposfx.scene.control.MyLabel;
import camposfx.scene.control.StockDatePicker;
import camposfx.util.AlertFactory;
import camposfx.util.FXUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class StockRangePickerPane extends BorderPane {
	private MyLabel lblAvg;
	private AverageTextField tfOpen, tfHigh, tfLow, tfClose, tfVolume;
	private StockDatePicker oldestDatePicker;
	private StockDatePicker latestDatePicker;
	private Company c;

	public StockRangePickerPane(StockSearchPane oldStockPane, StockSearchPane lateStockPane) {
		this.lblAvg = new MyLabel("Avg:", Font.font(20));
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
			Map<LocalDate, Stock> subMap = c.getStockMap().subMap(oldDate, lateDate.plusDays(1));			
			Set<LocalDate> dateSet = subMap.keySet();
			
			avgOpen = 0; avgHigh = 0; avgLow = 0; avgClose = 0; avgVolume = 0;
			
			for (LocalDate localDate : dateSet) {
				Stock stock = subMap.get(localDate);
				avgOpen += stock.getOpenValue();
				avgHigh += stock.getHighValue();
				avgLow += stock.getLowValue();
				avgClose += stock.getCloseValue();
				avgVolume += stock.getVolume();
			}
			
			avgOpen /= subMap.size();
			avgHigh /= subMap.size();
			avgLow /= subMap.size();
			avgClose /= subMap.size();
			avgVolume /= subMap.size();
			displayAvgValues();
			AlertFactory.emitGraph("(" + oldDate + " - " + lateDate + ")", subMap);
		}
		
		public void displayAvgValues() {
			lblAvg.setText("Avg: (" + oldDate + " - " + lateDate + ")");
			tfOpen.setText(String.format("%-10.2f", avgOpen));
			tfHigh.setText(String.format("%-10.2f", avgHigh));
			tfLow.setText(String.format("%-10.2f", avgLow));
			tfClose.setText(String.format("%-10.2f", avgClose));
			tfVolume.setText(String.format("%-10d", avgVolume));
		}
	}
}
