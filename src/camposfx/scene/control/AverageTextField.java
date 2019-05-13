package camposfx.scene.control;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class AverageTextField extends TextField {
	public AverageTextField(String prompt) {
		super.setPromptText(prompt);
		super.setAlignment(Pos.CENTER);
		super.setEditable(false);
	}
}
