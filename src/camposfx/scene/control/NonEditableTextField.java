package camposfx.scene.control;

import javafx.scene.control.TextField;

public class NonEditableTextField extends TextField {
	public NonEditableTextField() {
		super.setEditable(false);
	}
}
