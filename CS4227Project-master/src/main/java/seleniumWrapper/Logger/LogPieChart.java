package seleniumWrapper.Logger;

import javafx.application.Application;

public class LogPieChart extends LogView{

	public LogPieChart() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param int [] testStats
	 * @desc Displays test results in a Pie Chart
	 */
	@Override
	public void displayResults(int[] testStats) {
		Application.launch(DrawPieChart.class, ("--TotalTests=" + testStats[0]),
				("--PassedTests=" + testStats[1]), ("--FailedTests=" + testStats[2]));
	}

}
