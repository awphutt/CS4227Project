package seleniumWrapper.Logger;

import javafx.application.Application;

public class LogBarChart extends LogView{

	
	public LogBarChart() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param int [] testStats
	 * @desc Displays test results in a Bar Chart
	 */
	@Override
	public void displayResults(int[] testStats) {
		Application.launch(DrawBarChart.class, ("--TotalTests=" + testStats[0]),
				("--PassedTests=" + testStats[1]), ("--FailedTests=" + testStats[2]));
	}
}
