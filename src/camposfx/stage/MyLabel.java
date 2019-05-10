package camposfx.stage;

import java.util.LinkedList;

import campos.io.DataLoader;
import campos.model.Company;
import camposfx.event.ExitHandler;
import camposfx.scene.layout.MyBorderPane;
import camposfx.util.ImgUtil;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MyLabel extends Stage {
	public static final String TITLE = "Historical Stock Data Analysis";
	private LinkedList<Company> companyBag;
	private MyBorderPane root;

	public MyLabel() {
		this.companyBag = DataLoader.loadCompanyBag();
		this.root = new MyBorderPane(companyBag);
		ImgUtil.loadStageIcon(this);
		this.setTitle(TITLE);
		this.setScene(new Scene(root));
		this.setOnCloseRequest(new ExitHandler<WindowEvent>(companyBag));
	}
}
