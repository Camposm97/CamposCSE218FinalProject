package campos.workbench;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DatePickerDemo extends Application {
	@Override
	public void start(Stage stage) {
		DatePicker datePicker = new DatePicker(LocalDate.now());
		Button bt = new Button("Add");
		bt.setOnAction(e -> {
			LocalDate date = datePicker.getValue();
			System.out.println(date);
		});
		
		BorderPane root = new BorderPane(datePicker, null, null, bt, null);
		Scene scene = new Scene(root, 300, 300);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
