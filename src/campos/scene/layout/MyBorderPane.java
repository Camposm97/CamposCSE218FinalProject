package campos.scene.layout;

import java.util.LinkedList;

import campos.model.Company;
import campos.scene.control.MyMenuBar;
import javafx.scene.layout.BorderPane;

public class MyBorderPane extends BorderPane {
	private MyMenuBar menuBar;
	
	public MyBorderPane(LinkedList<Company> list) {
		menuBar = new MyMenuBar(list);
		this.setTop(menuBar);
	}
	
	
}
