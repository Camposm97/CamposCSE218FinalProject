package workbench;

import java.util.LinkedList;

import campos.io.DataOperator;
import campos.model.Company;
import campos.scene.layout.StockViewerPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
