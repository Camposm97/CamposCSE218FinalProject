package camposfx.scene.control;

import javafx.scene.control.TextField;

public class NonEditTextField extends TextField {
	public NonEditTextField() {
		super.setEditable(false);
	}
}
