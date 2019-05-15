package camposfx.util;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import campos.model.Stock;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
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
	
	@SuppressWarnings("unchecked")
	public static LineChart<String, Number> loadStockChart(Map<LocalDate, Stock> subStockMap) {
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("Date");
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Stock Price");
		
		Series<String, Number> openSeries = new Series<>();
		Series<String, Number> highSeries = new Series<>();
		Series<String, Number> lowSeries = new Series<>();
		Series<String, Number> closeSeries = new Series<>();
		Series<String, Number> volumeSeries = new Series<>();

		
		openSeries.setName("Stock Open Series");
		highSeries.setName("Stock High Series");
		lowSeries.setName("Stock Low Series");
		closeSeries.setName("Stock Close Series");
		volumeSeries.setName("Stock Volume Series");
		
		Set<LocalDate> dateSet = subStockMap.keySet();
		Iterator<LocalDate> iter = dateSet.iterator();
		
		while (iter.hasNext()) {
			LocalDate localDate = iter.next();
			Stock s = subStockMap.get(localDate);
			Data<String, Number> openData = new Data<>(localDate.toString(), s.getOpenValue());
			Data<String, Number> highData = new Data<>(localDate.toString(), s.getHighValue());
			Data<String, Number> lowData = new Data<>(localDate.toString(), s.getLowValue());
			Data<String, Number> closeData = new Data<>(localDate.toString(), s.getCloseValue());
			Data<String, Number> volumeData = new Data<>(localDate.toString(), s.getVolume());

			openSeries.getData().add(openData);
			highSeries.getData().add(highData);
			lowSeries.getData().add(lowData);
			closeSeries.getData().add(closeData);
			volumeSeries.getData().add(volumeData);
		}
		
		LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.getData().addAll(openSeries, highSeries, lowSeries, closeSeries, volumeSeries);
		return lineChart;
	}
}
