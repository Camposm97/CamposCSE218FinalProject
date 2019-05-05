package campos.util;

import java.awt.Desktop;
import java.net.URI;

public class Web {
	private static final String MY_GITHUB = "https://github.com/Camposm97";
	
	public static void browse(String url) {
		try {
			Desktop desktop = Desktop.getDesktop();
			desktop.browse(new URI(url));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void openMyGithub() {
		browse(MY_GITHUB);
	}
}
