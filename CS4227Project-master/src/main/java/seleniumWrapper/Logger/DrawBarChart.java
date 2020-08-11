package seleniumWrapper.Logger;

import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class DrawBarChart extends Application {
	
	/**
	 *@name start()
	 *@param Stage primaryStage
	 *@return void
	 *@desc - Draws the bar chart	
	*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void start(Stage primaryStage) throws Exception	{
		Parameters p = getParameters();
		Map<String, String> named = p.getNamed();
		
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("Pass/Fails");
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Number");
		BarChart chart = new BarChart(xAxis, yAxis);
		XYChart.Series dataSeries = new XYChart.Series();
		dataSeries.setName("Test Data");
		dataSeries.getData().add(new XYChart.Data("Total Tests", Integer.parseInt(named.get("TotalTests"))));
		dataSeries.getData().add(new XYChart.Data("Passed Tests", Integer.parseInt(named.get("PassedTests"))));
		dataSeries.getData().add(new XYChart.Data("Failed Tests", Integer.parseInt(named.get("FailedTests"))));
		chart.getData().add(dataSeries);
		Stage s1 = new Stage();
		VBox vbox = new VBox(chart);
        Scene scene = new Scene(vbox, 400, 200);

        s1.setScene(scene);
        s1.setTitle("Test data");
        s1.setHeight(300);
        s1.setWidth(1200);
        s1.show();
	}
}