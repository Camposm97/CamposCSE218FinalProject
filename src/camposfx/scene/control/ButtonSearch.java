package camposfx.scene.control;

import camposfx.scene.layout.StockSearchPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonSearch extends Button {
	private StockSearchPane pane;
	
	public ButtonSearch(StockSearchPane pane) {
		super("Search");
		this.pane = pane;
		super.setOnAction(new SearchHandler());
	}
	
	private class SearchHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			System.out.println("Searching in " + pane.getC().getName());
		}
	}
}
