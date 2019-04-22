package scene.control;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class MyMenu extends Menu {
	
	public MyMenu(MenuEnum menuType) {
		super(menuType.toString());
		addMenuItems();
	}
	
	private void addMenuItems() {
		switch(this.getText().toUpperCase()) {
		case "FILE":
			impFileItems();
			break;
		case "VIEW":
			impViewItems();
			break;
		case "OPERATION":
			impOpItems();
			break;
		case "HELP":
			impHelpItems();	
		}
	}
	
	private void impFileItems() {
		MenuItem miExit = new MenuItem("Exit");
		miExit.setOnAction(e -> {
			Platform.exit();
		});
		this.getItems().addAll(miExit);
	}
	
	private void impViewItems() {
		MenuItem miAmzn = new MenuItem("Amazon");
		MenuItem miAppl = new MenuItem("Apple");
		this.getItems().addAll(miAmzn, miAppl);
	}
	
	private void impOpItems() {
		MenuItem miInsert = new MenuItem("Add Stock Data");
		
		this.getItems().addAll(miInsert);
	}
	
	private void impHelpItems() {
		
	}
}
