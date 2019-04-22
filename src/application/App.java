package application;

import javafx.application.Application;
import javafx.stage.Stage;
import scene.MainWindow;

public class App extends Application {
	@Override
	public void start(Stage stage) {
		MainWindow main = new MainWindow(stage);
		main.display();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
