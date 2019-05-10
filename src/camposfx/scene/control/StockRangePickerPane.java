package camposfx.scene.control;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import campos.model.Company;
import campos.model.Stock;
import camposfx.scene.layout.StockSearchPane;
import camposfx.util.FXUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;

public class StockRangePickerPane extends BorderPane {
	private StockDatePicker oldestDatePicker;
	private StockDatePicker latestDatePicker;
	private Company c;

	public StockRangePickerPane(StockSearchPane pane1, StockSearchPane pane2) {
		this.oldestDatePicker = pane1.getDatePicker();
		this.latestDatePicker = pane2.getDatePicker();
		this.oldestDatePicker.addEventHandler(ActionEvent.ACTION, new StockRangePickerHandler());
		this.latestDatePicker.addEventHandler(ActionEvent.ACTION, new StockRangePickerHandler());
		this.c = pane1.getC();
		this.setLeft(pane1);
		this.setRight(pane2);
		this.setPadding(FXUtil.DEFAULT_INSETS);
	}
	
	private class StockRangePickerHandler implements EventHandler<ActionEvent> {
		private LocalDate oldDate;
		private LocalDate lateDate;
		
		@Override
		public void handle(ActionEvent e) {
			oldDate = oldestDatePicker.getValue();
			lateDate = latestDatePicker.getValue();
			if (oldDate.compareTo(lateDate) < 0) {
				calcAveragePrices();
			}
		}
		
		public void calcAveragePrices() {
			Map<LocalDate, Stock> subMap = c.getStockMap().subMap(oldDate, lateDate.plusDays(1));			
			Set<LocalDate> dateSet = subMap.keySet();
			
			double avgOpenValue = 0;
			double avgHighValue = 0;
			double avgLowValue = 0;
			double avgCloseValue = 0;
			int avgVolume = 0;
			
			for (LocalDate localDate : dateSet) {
				Stock stock = subMap.get(localDate);
				avgOpenValue += stock.getOpenValue();
				avgHighValue += stock.getHighValue();
				avgLowValue += stock.getLowValue();
				avgCloseValue += stock.getCloseValue();
				avgVolume += stock.getVolume();
				System.out.println(stock);
			}
			
			avgOpenValue /= subMap.size();
			avgHighValue /= subMap.size();
			avgLowValue /= subMap.size();
			avgCloseValue /= subMap.size();
			avgVolume /= subMap.size();
			
			System.out.println();
			System.out.println("Average Open Value: " + avgOpenValue);
			System.out.println("Average High Value: " + avgHighValue);
			System.out.println("Average Low Value: " + avgLowValue);
			System.out.println("Average Close Value: " + avgCloseValue);
			System.out.println("Average Volume: " + avgVolume);
			System.out.println();
		}
	}
}
