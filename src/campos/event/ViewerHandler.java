package campos.event;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioMenuItem;

public class ViewerHandler implements EventHandler<ActionEvent> {
	private RadioMenuItem menuItem;
	public ViewerHandler(RadioMenuItem menuItem) {
		this.menuItem = menuItem;
	}
	
	@Override
	public void handle(ActionEvent e) {
		switch(menuItem.getText().toUpperCase()) {
		case "AMAZON":
			System.out.println("Switching to Amazon's Stocks");
			break;
		case "APPLE":
			System.out.println("Switching to Apple's Stocks");
			break;
		}
	}
}
