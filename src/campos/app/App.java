package campos.app;

import camposfx.stage.MyLabel;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
	@Override
	public void start(Stage stage) {
		stage = new MyLabel();
		stage.show();
	}
	
	public static void main(String[] args) throws Exception {
		launch(args);
	}
}
