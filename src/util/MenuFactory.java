package util;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import scene.control.MenuEnum;

public class MenuFactory {
	public static Menu loadMenu(MenuEnum menuEnum) {
		Menu menu = new Menu(menuEnum.toString());
		switch (menu.getText().toUpperCase()) {
		case "FILE":
			impFileItems(menu);
			break;
		case "VIEW":
			impViewItems(menu);
			break;
		case "OPERATION":
			impOpItems(menu);
			break;
		case "HELP":
			impHelpItems(menu);
		}
		return menu;
	}

	private static void impFileItems(Menu menu) {
		MenuItem miExit = new MenuItem("Exit");
		miExit.setOnAction(e -> {
			Platform.exit();
		});
		menu.getItems().addAll(miExit);
	}
	
	private static void impViewItems(Menu menu) {
		MenuItem miAmzn = new MenuItem("Amazon");
		MenuItem miAppl = new MenuItem("Apple");
		menu.getItems().addAll(miAmzn, miAppl);
	}

	private static void impOpItems(Menu menu) {
		MenuItem miInsert = new MenuItem("Add Stock Data");
		menu.getItems().addAll(miInsert);
	}

	private static void impHelpItems(Menu menu) {
		MenuItem miDev = new MenuItem("Developer's Github");
		miDev.setOnAction(e -> {
			// TODO CODE
		});
		MenuItem miAbout = new MenuItem("About");
		miAbout.setOnAction(e -> {
			// TODO CODE
		});
		menu.getItems().addAll(miDev, miAbout);
	}
}
