package campos.model;

import javafx.scene.layout.BorderPane;

public class ChosenOnes {
	public static BorderPane root = null;
	public static Company chosenOne = null;
	
	public static void setRoot(BorderPane borderPane) {
		root = borderPane;
	}
	
	public static void setCompany(Company c) {
		chosenOne = c;
	}
}
