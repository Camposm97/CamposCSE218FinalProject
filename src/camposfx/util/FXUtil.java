package camposfx.util;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import campos.model.Company;
import campos.model.Stock;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ValueAxis;
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
	
	public static DatePicker loadInsertDatePicker() {
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
	
	public static DatePicker loadSearchDatePicker() {
		DatePicker datePicker = new DatePicker(LocalDate.now());
		datePicker.setEditable(false);
		return datePicker;
	}
	
	public static StackPane loadBackground() {
		ImageView iv = ImgUtil.loadImgV(ImgUtil.BACKGROUND_MAIN);
		iv.setOpacity(0.25);
		StackPane pane = new StackPane(iv);
		pane.setPadding(new Insets(50, 200, 50, 200));
		return pane;
	}
	
	public static LineChart<LocalDate, Number> loadStockChart(Company c) {
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("Date");
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Stock Price");
		
		Series<String, Number> series = new Series<>();
		TreeMap<LocalDate, Stock> stockMap = c.getStockMap();
		Set<LocalDate> dateSet = stockMap.keySet();
		Iterator<LocalDate> iter = dateSet.iterator();
		
		for (int i = 0; i < stockMap.size(); i++) {
			LocalDate localDate = iter.next();
			Stock s = stockMap.get(localDate);
			Data<String, Number> data = new Data<>(localDate.toString(), s.getOpenValue());
			series.getData().add(data);
		}
		
		series.setName(c.getName());
		
		LineChart lineChart = new LineChart(xAxis, yAxis);
		lineChart.getData().add(series);
		return lineChart;
	}
}
