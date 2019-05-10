package camposfx.scene.control;

import java.time.LocalDate;

import campos.model.Stock;
import camposfx.scene.layout.StockInsertPane;
import camposfx.util.AlertFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonInsert extends Button {
	private StockInsertPane pane;
	
	public ButtonInsert(StockInsertPane pane) {
		super("Insert");
		this.pane = pane;
		super.setOnAction(new InsertHandler());
	}
	
	private class InsertHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			System.out.println("Inserting to " + pane.getC().getName() + "...");
			try {
				LocalDate date = pane.getDatePicker().getValue();
				double openValue = pane.getTfOpenValue().getValue();
				double highValue = pane.getTfHighValue().getValue();
				double lowValue = pane.getTfLowValue().getValue();
				double closeValue = pane.getTfCloseValue().getValue();
				int volume = (int) pane.getTfVolume().getValue();
				Stock stock = new Stock(date, openValue, highValue, lowValue, closeValue, volume);
				pane.getC().getStockMap().put(stock.getLocalDate(), stock);
				AlertFactory.emitInfo("Insert", "Successfully added stock on " + date, "Close this window to continue.");
			} catch (NumberFormatException e) {
				AlertFactory.emitError("The TextFields can only contain numbers.");
			}
		}
	}
}
