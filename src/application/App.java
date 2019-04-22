package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import scene.control.MyMenuBar;
import util.ImgUtil;

public class App extends Application {
	private static final String TITLE = "Historical Stock Data Analysis";
	private BorderPane root;
	
	@Override
	public void init() {
		root = new BorderPane();
		root.setTop(new MyMenuBar());
	}
	
	@Override
	public void start(Stage stage) {
		ImgUtil.loadStageIcon(stage);
		stage.setTitle(TITLE);
		stage.setScene(new Scene(root));
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
