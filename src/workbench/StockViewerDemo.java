package workbench;

import java.util.LinkedList;

import io.DataOperator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Company;
import scene.layout.StockViewerPane;

public class StockViewerDemo extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		LinkedList<Company> list = DataOperator.loadCompanyBag();
		stage.setScene(new Scene(new StockViewerPane(list.get(0))));
		stage.show();
	}
}
