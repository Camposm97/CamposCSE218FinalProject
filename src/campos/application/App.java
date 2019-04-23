package campos.application;

import campos.stage.CamposStage;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
	@Override
	public void start(Stage stage) {
		stage = new CamposStage();
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
