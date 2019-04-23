package campos.util;

import java.util.Optional;

import campos.stage.CamposStage;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

public class AlertFactory {
	public static Alert emitAlertExit() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(CamposStage.TITLE);
		alert.setHeaderText("Are you sure you want to exit?");
		alert.setContentText("Note: Any modifications you made to a company will be saved.");
		
		ButtonType btYes = new ButtonType("Yes", ButtonData.YES);
		ButtonType btNo = new ButtonType("No", ButtonData.NO);
		alert.getButtonTypes().setAll(btYes, btNo);
		
		Optional<ButtonType> result = alert.showAndWait();
		result.ifPresent(e -> {
			if (e == btYes) {
				Platform.exit();
			}
		});
		return alert;
	}
}
