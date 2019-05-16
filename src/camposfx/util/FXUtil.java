package camposfx.util;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import campos.model.Stock;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
		iv.setOpacity(0.5);
		StackPane pane = new StackPane(iv);
		pane.setPadding(new Insets(50, 200, 50, 200));
		
		iv.setPreserveRatio(true);
		iv.fitWidthProperty().bind(pane.widthProperty().multiply(0.70));
		iv.fitHeightProperty().bind(pane.heightProperty().multiply(0.70));
		
		return pane;
	}
		
	public static void emitStockCharts(Map<LocalDate, Stock> subMap) {
		CategoryAxis xAxis1 = new CategoryAxis();
		xAxis1.setLabel("Date");
		NumberAxis yAxis1 = new NumberAxis();
		yAxis1.setLabel("Stock Price");
		
		CategoryAxis xAxis2 = new CategoryAxis();
		xAxis2.setLabel("Date");
		NumberAxis yAxis2 = new NumberAxis();
		yAxis2.setLabel("Stock Price");
		
		CategoryAxis xAxis3 = new CategoryAxis();
		xAxis3.setLabel("Date");
		NumberAxis yAxis3 = new NumberAxis();
		yAxis3.setLabel("Stock Volume");
		
		Series<String, Number> openSeries = new Series<>();
		Series<String, Number> highSeries = new Series<>();
		Series<String, Number> lowSeries = new Series<>();
		Series<String, Number> closeSeries = new Series<>();
		Series<String, Number> volSeries = new Series<>();

		openSeries.setName("Stock Open Series");
		highSeries.setName("Stock High Series");
		lowSeries.setName("Stock Low Series");
		closeSeries.setName("Stock Close Series");
		volSeries.setName("Stock Volume Series");
		
		Set<LocalDate> dateSet = subMap.keySet();
		Iterator<LocalDate> iter = dateSet.iterator();
		
		while (iter.hasNext()) {
			LocalDate localDate = iter.next();
			Stock s = subMap.get(localDate);
			Data<String, Number> openData = new Data<>(localDate.toString(), s.getOpenValue());
			Data<String, Number> highData = new Data<>(localDate.toString(), s.getHighValue());
			Data<String, Number> lowData = new Data<>(localDate.toString(), s.getLowValue());
			Data<String, Number> closeData = new Data<>(localDate.toString(), s.getCloseValue());
			Data<String, Number> volumeData = new Data<>(localDate.toString(), s.getVolume());

			openSeries.getData().add(openData);
			highSeries.getData().add(highData);
			lowSeries.getData().add(lowData);
			closeSeries.getData().add(closeData);
			volSeries.getData().add(volumeData);
		}
		
		LineChart<String, Number> lineChartOpenClose = new LineChart<>(xAxis1, yAxis1);
		lineChartOpenClose.setTitle("Stock Open vs. Close Monitor");
		lineChartOpenClose.getData().add(openSeries);
		lineChartOpenClose.getData().add(closeSeries);
		
		LineChart<String, Number> lineChartHighLow = new LineChart<>(xAxis2, yAxis2);
		lineChartHighLow.setTitle("Stock High vs. Low Monitor");
		lineChartHighLow.getData().add(highSeries);
		lineChartHighLow.getData().add(lowSeries);
		
		LineChart<String, Number> lineChartVol = new LineChart<>(xAxis3, yAxis3);
		lineChartVol.setTitle("Stock Volume Monitor");
		lineChartVol.getData().add(volSeries);
		
		Tab tab1 = new Tab("Open vs. Close Chart");
		tab1.setContent(lineChartOpenClose);
		
		Tab tab2 = new Tab("High vs. Low Chart");
		tab2.setContent(lineChartHighLow);
		
		Tab tab3 = new Tab("Volume Chart");
		tab3.setContent(lineChartVol);
		
		TabPane tabPane = new TabPane();
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		tabPane.getTabs().addAll(tab1, tab2, tab3);
		
		Stage stage = new Stage();
		ImgUtil.loadStageIcon(stage);
		stage.setScene(new Scene(tabPane));
		stage.show();
	}
}
