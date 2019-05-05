package campos.util;

import java.time.LocalDate;
import java.util.LinkedList;

import campos.model.Company;
import campos.model.Stock;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class FXUtil {
	public static final Insets DEFAULT_INSETS = new Insets(10);
	
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
	
	public static DatePicker loadDatePicker() {
		DatePicker datePicker = new DatePicker(LocalDate.now());
		datePicker.setEditable(false);
		datePicker.setDayCellFactory(e -> new DateCell() {
			public void updateItem(LocalDate date, boolean empty) {
	            super.updateItem(date, empty);
	            LocalDate today = LocalDate.now();
	            setDisable(empty || date.compareTo(today) < 0 );
	        }
		});
		return datePicker;
	}
	
	public static StackPane loadBackground() {
		ImageView iv = ImgUtil.loadImgV(ImgUtil.BACKGROUND_MAIN);
		iv.setOpacity(0.25);
		StackPane pane = new StackPane(iv);
		pane.setPadding(new Insets(50, 200, 50, 200));
		return pane;
	}
	
	public static LineChart<Number, Number> loadStockChart(Company c) {
		final NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel("Day");
		final NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Stock Price");
		
		Series<Number, Number> series = new Series<>();
		LinkedList<Stock> stockList = c.getStockList();
		
		for (int i = 0; i < stockList.size(); i++) {
			Stock s = stockList.get(i);
			Data<Number, Number> data = new Data<>(i, s.getOpenValue());
			series.getData().add(data);
		}
		
		series.setName(c.getName());
		
		LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.getData().add(series);
		return lineChart;
	}
}
