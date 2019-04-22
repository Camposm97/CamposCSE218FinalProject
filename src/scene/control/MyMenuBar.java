package scene.control;

import java.util.LinkedList;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import model.Company;
import util.MenuFactory;

public class MyMenuBar extends MenuBar {	
	public MyMenuBar(LinkedList<Company> list) {
		initMenus(list);
	}
	
	private void initMenus(LinkedList<Company> list) {
		Menu menuFile = MenuFactory.loadMenu(MenuEnum.File);
		Menu menuView = MenuFactory.loadMenu(MenuEnum.View);
		Menu menuOp = MenuFactory.loadMenu(MenuEnum.Operation);
		Menu menuHelp = MenuFactory.loadMenu(MenuEnum.Help);
		getMenus().addAll(menuFile, menuView, menuOp, menuHelp);
	}
}
