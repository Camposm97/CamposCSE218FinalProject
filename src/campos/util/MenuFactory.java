package campos.util;

import campos.event.ViewerHandler;
import campos.scene.control.MenuEnum;
import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

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
		miExit.setGraphic(ImgUtil.loadImgV(ImgUtil.ICON_EXIT));
		miExit.setOnAction(e -> {
			boolean flag = AlertFactory.emitAlertExit();
			if (flag) {
				Platform.exit();
			}
		});
		menu.getItems().addAll(miExit);
	}
	
	private static void impViewItems(Menu menu) {
		ToggleGroup t1 = new ToggleGroup();
		RadioMenuItem miAmzn = new RadioMenuItem("Amazon");
		miAmzn.setOnAction(new ViewerHandler(miAmzn));
		miAmzn.setToggleGroup(t1);
		RadioMenuItem miAppl = new RadioMenuItem("Apple");
		miAppl.setToggleGroup(t1);
		miAppl.setOnAction(new ViewerHandler(miAppl));
		menu.getItems().addAll(miAmzn, miAppl);
	}

	private static void impOpItems(Menu menu) {
		MenuItem miInsert = new MenuItem("Insert");
		miInsert.setGraphic(ImgUtil.loadImgV(ImgUtil.ICON_INSERT));
		MenuItem miSearch = new MenuItem("Search");
		miSearch.setGraphic(ImgUtil.loadImgV(ImgUtil.ICON_SEARCH));
		menu.getItems().addAll(miInsert, miSearch);
	}

	private static void impHelpItems(Menu menu) {
		MenuItem miDev = new MenuItem("Developer's Github");
		miDev.setGraphic(ImgUtil.loadImgV(ImgUtil.ICON_DEV));
		miDev.setOnAction(e -> {
			// TODO CODE
		});
		MenuItem miAbout = new MenuItem("About");
		miAbout.setGraphic(ImgUtil.loadImgV(ImgUtil.ICON_ABOUT));
		miAbout.setOnAction(e -> {
			// TODO CODE
		});
		menu.getItems().addAll(miDev, miAbout);
	}
}
