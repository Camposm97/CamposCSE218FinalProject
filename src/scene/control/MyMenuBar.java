package scene.control;

import javafx.scene.control.MenuBar;

public class MyMenuBar extends MenuBar {	
	public MyMenuBar() {
		initMenus();
	}
	
	private void initMenus() {
		MyMenu menuFile = new MyMenu(MenuEnum.File);
		MyMenu menuView = new MyMenu(MenuEnum.View);
		MyMenu menuOp = new MyMenu(MenuEnum.Operation);
		getMenus().addAll(menuFile, menuView, menuOp);
	}
}
