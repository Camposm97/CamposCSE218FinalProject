package campos.stage;

import java.util.LinkedList;

import campos.io.DataOperator;
import campos.model.Company;
import campos.scene.layout.MyBorderPane;
import campos.util.ImgUtil;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CamposStage extends Stage {
	public static final String TITLE = "Historical Stock Data Analysis";
	private LinkedList<Company> companyBag;
	private MyBorderPane root;

	public CamposStage() {
		this.companyBag = DataOperator.loadCompanyBag();
		this.root = new MyBorderPane(companyBag);
		ImgUtil.loadStageIcon(this);
		this.setTitle(TITLE);
		this.setScene(new Scene(root));
	}
}
