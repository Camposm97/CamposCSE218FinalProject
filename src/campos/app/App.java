package campos.app;

import camposfx.stage.MyStage;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
	@Override
	public void start(Stage stage) {
		stage = new MyStage();
		stage.show();
	}
	
	public static void main(String[] args) throws Exception {
		launch(args);
	}
}
