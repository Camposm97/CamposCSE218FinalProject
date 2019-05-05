package camposfx.scene.control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonInsert extends Button {
	public ButtonInsert() {
		super("Insert");
		super.setOnAction(new InsertHandler());
	}
	
	private class InsertHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			System.out.println("Inserting...");
		}
	}
}
