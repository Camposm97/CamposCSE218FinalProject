package campos.scene.layout;

import java.util.LinkedList;

import campos.model.Company;
import campos.scene.control.MyMenuBar;
import campos.util.FXUtil;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MyBorderPane extends BorderPane {
	private MyMenuBar menuBar;
	
	public MyBorderPane(LinkedList<Company> list) {
		menuBar = new MyMenuBar(list);
		this.setTop(menuBar);		
		this.setCenter(FXUtil.loadBackground());
	}	
}
