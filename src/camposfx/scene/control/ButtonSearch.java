package camposfx.scene.control;

import java.time.LocalDate;

import campos.model.Stock;
import campos.util.AlertFactory;
import camposfx.scene.layout.OneStockSearchTab;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonSearch extends Button {
	private OneStockSearchTab pane;
	
	public ButtonSearch(OneStockSearchTab pane) {
		super("Search");
		this.pane = pane;
		super.setOnAction(new SearchHandler());
	}
	
	private class SearchHandler implements EventHandler<ActionEvent> {
		private Stock stock; 
		
		@Override
		public void handle(ActionEvent event) {
			LocalDate key = pane.getDatePicker().getValue();
			stock = pane.getC().getStockMap().get(key);
			if (stock != null) {
				displayStock();
			} else {
				AlertFactory.emitError("No stock price listed on " + key);
			}
		}
		
		public void displayStock() {
			pane.getTfOpenValue().setText(stock.getOpenValue() + "");
			pane.getTfHighValue().setText(stock.getHighValue() + "");
			pane.getTfLowValue().setText(stock.getLowValue() + "");
			pane.getTfCloseValue().setText(stock.getCloseValue() + "");
			pane.getTfVolume().setText(stock.getVolume() + "");
		}
	}
}
