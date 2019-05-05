package camposfx.scene.control;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MyLabel extends Label {
	public MyLabel(String string) {
		super(string);
	}
	
	public MyLabel(String string, Font font) {
		super(string);
		super.setFont(font);
	}
	
	public MyLabel(String string, Font font, Color color) {
		super(string);
		super.setFont(font);
		super.setTextFill(color);
	}
}
