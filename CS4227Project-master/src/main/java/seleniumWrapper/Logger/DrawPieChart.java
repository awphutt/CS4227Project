package seleniumWrapper.Logger;

import java.util.Map;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DrawPieChart extends Application{
	
	/**
	 *@name start()
	 *@param Stage primaryStage
	 *@return void
	 *@desc - Draws the pie chart	
	*/
	public void start(Stage primaryStage) throws Exception	{
		Parameters p = getParameters();
		Map<String, String> named = p.getNamed();
		
		ObservableList<PieChart.Data> pieChartData = 
				FXCollections.observableArrayList(
						new PieChart.Data("Total Tests", Integer.parseInt(named.get("TotalTests"))),
						new PieChart.Data("Passed Tests", Integer.parseInt(named.get("PassedTests"))),
						new PieChart.Data("Final Tests", Integer.parseInt(named.get("FailedTests"))));
		
		PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Test Data");
		Stage s1 = new Stage();
		VBox vbox = new VBox(chart);
        Scene scene = new Scene(vbox, 400, 200);

        s1.setScene(scene);
        s1.setTitle("Test data");
        s1.setHeight(500);
        s1.setWidth(500);
        s1.show();
	}
}