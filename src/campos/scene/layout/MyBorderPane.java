package campos.scene.layout;

import java.util.LinkedList;

import campos.model.Company;
import campos.scene.control.MyMenuBar;
import campos.util.ImgUtil;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class MyBorderPane extends BorderPane {
	private MyMenuBar menuBar;
	private StackPane centerPane;
	
	public MyBorderPane(LinkedList<Company> list) {
		menuBar = new MyMenuBar(list);
		this.setTop(menuBar);
		ImageView iv = ImgUtil.loadImgV(ImgUtil.BACKGROUND_MAIN);
		iv.setOpacity(0.2);
		this.centerPane = new StackPane(iv);
		this.setCenter(centerPane);
	}
	
	
}
