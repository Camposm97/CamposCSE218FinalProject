package camposfx.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ImgUtil {
	public static final String ICON_MAIN = "resources/images/icons/main.png";
	public static final String ICON_EXIT = "resources/images/icons/exit.png";
	public static final String ICON_EXIT_BIG = "resources/images/icons/exitBig.png";
	public static final String ICON_ABOUT = "resources/images/icons/about.png";
	public static final String ICON_DEV = "resources/images/icons/github.png";
	public static final String ICON_INSERT = "resources/images/icons/insert.png";
	public static final String ICON_SEARCH = "resources/images/icons/search.png";
	public static final String BACKGROUND_MAIN = "resources/images/backgrounds/background.png";
	public static final String ICON_AMZN = "resources/images/icons/amazon.png";
	public static final String ICON_AAPL = "resources/images/icons/apple.png";
	
	public static void loadStageIcon(Stage stage) {
		stage.getIcons().add(loadImg(ICON_MAIN));
	}
	
	public static Image loadImg(String url) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(url));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new Image(fis);
	}

	public static ImageView loadImgV(String url) {
		return new ImageView(loadImg(url));
	}
}
