package camposfx.scene.layout;

import java.util.LinkedList;

import campos.model.ChosenOnes;
import campos.model.Company;
import camposfx.scene.control.MyMenuBar;
import camposfx.util.FXUtil;
import javafx.scene.layout.BorderPane;

public class MyBorderPane extends BorderPane {	
	public MyBorderPane(LinkedList<Company> list) {
		super(FXUtil.loadBackground(), new MyMenuBar(list), null, null, null);
		ChosenOnes.setRoot(this);
	}
}
