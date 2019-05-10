package camposfx.scene.control;

import java.util.LinkedList;

import campos.model.Company;
import camposfx.util.MenuFactory;
import javafx.scene.control.MenuBar;

public class MyMenuBar extends MenuBar {
	public MyMenuBar(LinkedList<Company> list) {
		super.getMenus().addAll(new MenuFactory(list).loadMenus());
	}
}
