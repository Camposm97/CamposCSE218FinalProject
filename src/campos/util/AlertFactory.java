package campos.util;

import java.util.Optional;

import camposfx.stage.MyStage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

public class AlertFactory {
	public static boolean emitExit() {
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
	
	public static void emitAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About");
		alert.setHeaderText(MyStage.TITLE);
		alert.showAndWait();
	}

	public static void emitError(String msg) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(Random.emitErrorMsg());
		alert.setContentText(msg);
		alert.showAndWait();
	}
}
