package scene;

import java.util.LinkedList;

import io.DataOperator;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Company;
import scene.layout.MyBorderPane;
import util.FXUtil;
import util.ImgUtil;

public class MainWindow {
	private static final String TITLE = "Historical Stock Data Analysis";
	private LinkedList<Company> companyBag;
	private MyBorderPane root;
	private Stage stage;
	
	public MainWindow(Stage stage) {
		this.companyBag = DataOperator.loadCompanyBag();
		this.root = new MyBorderPane(companyBag);
		this.stage = stage;
	}
	
	public void display() {
		ImgUtil.loadStageIcon(stage);
		stage.setTitle(TITLE);
		stage.setScene(new Scene(root));
		stage.show();
	}
}
