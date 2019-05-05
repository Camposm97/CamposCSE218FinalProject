package camposfx.scene.control;

import javafx.scene.control.TextField;

/**
 * Added Listener.  Listens for any characters that are in the TextField.
 * @author Camposm97
 */
public class DoubleTextField extends TextField {
	public DoubleTextField() {
		super("0.0");
		super.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
				Double.parseDouble(newValue);
				setStyle("");
			} catch (NumberFormatException e) {
				setStyle("-fx-border-color: red; -fx-background-color: #FFF0F0;");
			}
		});
	}
	
	public double getValue() {
		return Double.parseDouble(getText());
	}
}
