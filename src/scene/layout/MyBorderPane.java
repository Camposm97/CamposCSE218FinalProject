package scene.layout;

import java.util.LinkedList;

import javafx.scene.layout.BorderPane;
import model.Company;
import scene.control.MyMenuBar;

public class MyBorderPane extends BorderPane {
	private MyMenuBar menuBar;
	
	public MyBorderPane(LinkedList<Company> list) {
		menuBar = new MyMenuBar(list);
		this.setTop(menuBar);
	}
	
	
}
