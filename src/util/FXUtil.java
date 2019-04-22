package util;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FXUtil {
	private static final Insets DEFAULT_INSETS = new Insets(10);
	
	/**
	 * Returns a VBox with 10 spacing and Alignment set to Center
	 * @param nodes
	 * @return
	 */
	public static VBox asVBox(Node...nodes) {
		VBox vBox = new VBox(10);
		vBox.setAlignment(Pos.CENTER);
		for (Node e : nodes)
			vBox.getChildren().add(e);
		return vBox;
	}
	
	/**
	 * Returns a HBox with 10 spacing and Alignment set to Center
	 * @param nodes
	 * @return
	 */
	public static HBox asHBox(Node...nodes) {
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		for (Node e : nodes)
			hBox.getChildren().add(e);
		return hBox;
	}
}
