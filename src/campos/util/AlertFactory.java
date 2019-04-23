package campos.util;

import java.util.Optional;

import campos.stage.MyStage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

public class AlertFactory {
	public static boolean emitAlertExit() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(MyStage.TITLE);
		alert.setHeaderText("Are you sure you want to exit?");
		alert.setContentText("Note: Any modifications you made to a company will be saved.");
		
		ButtonType btYes = new ButtonType("Yes", ButtonData.YES);
		ButtonType btNo = new ButtonType("No", ButtonData.NO);
		alert.getButtonTypes().setAll(btYes, btNo);
		
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == btYes) {
			return true;
		}
		return false;
	}
}
