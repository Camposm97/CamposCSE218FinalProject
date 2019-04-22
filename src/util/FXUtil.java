package util;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FXUtil {
	public static VBox asVBox(Node...nodes) {
		VBox vBox = new VBox(10);
		vBox.setAlignment(Pos.CENTER);
		for (Node e : nodes)
			vBox.getChildren().add(e);
		return vBox;
	}
	
	public static HBox asHBox(Node...nodes) {
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		for (Node e : nodes)
			hBox.getChildren().add(e);
		return hBox;
	}
}
