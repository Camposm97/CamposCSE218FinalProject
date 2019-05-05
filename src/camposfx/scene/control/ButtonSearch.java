package camposfx.scene.control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonSearch extends Button {
	public ButtonSearch() {
		super("Search");
		super.setOnAction(new SearchHandler());
	}
	
	private class SearchHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			System.out.println("Searching...");
		}
	}
}
