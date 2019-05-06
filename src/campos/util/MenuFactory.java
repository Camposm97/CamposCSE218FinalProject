package campos.util;

import java.util.LinkedList;

import campos.model.Company;
import camposfx.event.ExitHandler;
import camposfx.event.OperationHandler;
import camposfx.event.ViewerHandler;
import camposfx.scene.control.MenuEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

public class MenuFactory {
	private LinkedList<Company> companyBag;
	
	public MenuFactory(LinkedList<Company> companyBag) {
		this.companyBag = companyBag;
	}
	
	public ObservableList<Menu> loadMenus() {
		ObservableList<Menu> list = FXCollections.observableArrayList();
		list.add(loadMenu(MenuEnum.File));
		list.add(loadMenu(MenuEnum.View));
		list.add(loadMenu(MenuEnum.Operation));
		list.add(loadMenu(MenuEnum.Help));
		return list;
	}
	
	public Menu loadMenu(MenuEnum menuEnum) {
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

	private void impFileItems(Menu menu) {
		MenuItem miExit = new MenuItem("Exit");
		miExit.setOnAction(new ExitHandler<ActionEvent>(companyBag));
		menu.getItems().addAll(miExit);
	}
	
	private void impViewItems(Menu menu) {
		ToggleGroup t1 = new ToggleGroup();
		
		RadioMenuItem miAmzn = new RadioMenuItem("Amazon");
		miAmzn.setOnAction(new ViewerHandler(miAmzn, companyBag));
		miAmzn.setToggleGroup(t1);
		
		RadioMenuItem miAppl = new RadioMenuItem("Apple");
		miAppl.setToggleGroup(t1);
		miAppl.setOnAction(new ViewerHandler(miAppl, companyBag));
		menu.getItems().addAll(miAmzn, miAppl);
	}

	private void impOpItems(Menu menu) {
		MenuItem miInsert = new MenuItem("Insert");
		miInsert.setOnAction(new OperationHandler(miInsert.getText()));
		miInsert.setGraphic(ImgUtil.loadImgV(ImgUtil.ICON_INSERT));

		MenuItem miSearch = new MenuItem("Search");
		miSearch.setOnAction(new OperationHandler(miSearch.getText()));
		miSearch.setGraphic(ImgUtil.loadImgV(ImgUtil.ICON_SEARCH));
		menu.getItems().addAll(miInsert, miSearch);
	}

	private void impHelpItems(Menu menu) {
		MenuItem miDev = new MenuItem("Developer's Github");
		miDev.setOnAction(e -> { Web.openMyGithub(); });
		MenuItem miAbout = new MenuItem("About");
		miAbout.setOnAction(e -> { AlertFactory.emitAbout(); });
		menu.getItems().addAll(miDev, miAbout);
	}
}
