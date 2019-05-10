package camposfx.util;

import java.util.Optional;

import campos.model.Company;
import campos.model.Stock;
import campos.model.Symbol;
import camposfx.stage.MyStage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class AlertFactory {
	public static void emitInfo(String title, String header, String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
	
	public static void emitCompanyWentPublic(Stock firstStock, Company c) {
		Alert alert = new Alert(AlertType.INFORMATION);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		
		if (c.getSymbol().equals(Symbol.AAPL)) {
			stage.getIcons().add(ImgUtil.loadImg(ImgUtil.ICON_AAPL));
		} else if (c.getSymbol().equals(Symbol.AMZN)) {
			stage.getIcons().add(ImgUtil.loadImg(ImgUtil.ICON_AMZN));
		}
		
		alert.setTitle("Note");
		alert.setHeaderText("On this date: " + firstStock.getLocalDate() + " was the day " + c.getName() + " went public.");
		alert.setContentText("Click \"OK\" to continue");
		alert.showAndWait();
	}
	
	public static boolean emitExit() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setGraphic(ImgUtil.loadImgV(ImgUtil.ICON_EXIT_BIG));
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
