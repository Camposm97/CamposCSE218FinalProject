package campos.stage;

import java.util.LinkedList;

import campos.io.DataLoader;
import campos.model.Company;
import campos.scene.layout.MyBorderPane;
import campos.util.AlertFactory;
import campos.util.ImgUtil;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class MyStage extends Stage {
	public static final String TITLE = "Historical Stock Data Analysis";
	private LinkedList<Company> companyBag;
	private MyBorderPane root;

	public MyStage() {
		this.companyBag = DataLoader.loadCompanyBag();
		this.root = new MyBorderPane(companyBag);
		ImgUtil.loadStageIcon(this);
		this.setTitle(TITLE);
		this.setScene(new Scene(root));
		this.setOnCloseRequest(e -> {
			boolean flag = AlertFactory.emitAlertExit();
			if (flag) {
				Platform.exit();
			} else {
				e.consume();
			}
		});
	}
	
	public MyBorderPane getRoot() {
		return root;
	}
}
