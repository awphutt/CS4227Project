package seleniumWrapper.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.Assert;

public class Log {

	 ArrayList<String> actionList;
	int test,passed,failed;
	
	public Log() {
		actionList = new ArrayList<>();
	}
	
	public void addAction(String action) {
		actionList.add(action);
	}
	
	/**
	 *@name getReport
	 *@param None
	 *@return void
	 *@desc - Writes the log to a txt file	
	*/
	public void getReport() throws IOException {
	
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		Path path = Paths.get(timeStamp+".txt");
		Files.write(path, actionList, StandardCharsets.UTF_8);
	}
	/**
	 *@name startTest()
	 *@param None
	 *@return void
	 *@desc - Logs the start of a test case	
	*/
	public void startTest() {
		actionList.add("Starting test " + test);
		test++;
	}
	/**
	 *@name errorHandler()
	 *@param None
	 *@return void
	 *@desc - Logs an error in a test case	
	*/
	public void errorHandler(Exception e) {
		actionList.add("Failed test " + test);
		failed++;
		actionList.add(e.toString());
		Assert.fail();
	}
	/**
	 *@name passedTest()
	 *@param None
	 *@return void
	 *@desc - Logs a passed test case	
	*/
	public void passedTest() {
		actionList.add("Passed test " + test);
		passed++;
	}
	/**
	 *@name getTestStats
	 *@param None
	 *@return int[]
	 *@desc - Returns the amount of total tests, passed tests and failed tests	
	*/
	public int[] getTestStats() {
		int [] results = {test,passed,failed};
		return results;
	}
	
}
