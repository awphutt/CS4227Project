package seleniumWrapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import seleniumWrapper.Logger.Log;
import seleniumWrapper.Logger.LogBarChart;
import seleniumWrapper.Logger.LogController;

public class Browser implements BrowserInterface{
	private WebDriver driver;
	private LogController log;
	private BrowserState state;
	private static final String linuxPath = System.getProperty("user.dir") + "//src//test//java//drivers//chromedriver";
	private static final String windowsPath = System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\chromedriver.exe";
	
	/**
	 *@name close()
	 *@param browserType - which type of browser the user wishes to have
	 *@return void
	 *@desc - Strategy as to what browser to use as well as configurations set up for different browsers	
	*/
	public Browser(String browserType) {
		String chromeDriverPath;
		state = new TestingState();
		 if(browserType.equals(Config.chrome)) {
			 if(System.getProperty("os.name").toLowerCase().equals("linux"))
				 chromeDriverPath = linuxPath;
			 else
				 chromeDriverPath = windowsPath;
			 
			 System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	         driver = new ChromeDriver();
		 }
		 else if(browserType.equals(Config.chromeHeadless)) {
			 System.setProperty("webdriver.chrome.driver", windowsPath);
			 
			 ChromeOptions options = new ChromeOptions();
		     options.addArguments("headless");
		     options.addArguments("window-size=1200x600");
		     
		     driver = new ChromeDriver(options);
		 }
	     else if(browserType.equals(Config.firefox)) {
	         driver = new FirefoxDriver();
	     }
	     else if(browserType.equals(Config.edge)) {
	    	 System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\iexplore.exe");
	    	 driver = new EdgeDriver();
	     }
		 log = new LogController(new Log(),new LogBarChart());
	}
	
	

	/**
	 *@name close()
	 *@return void
	 *@desc - Closes the browser	
	*/
	public void close() {
		if (state instanceof TestingState)	{
			driver.close();
			state = new ClosedState();
		}
		else	{
			System.out.println("Browser already closed");
		}
	}
	
	/**
	 *@name setLog()
	 *@return void
	 *@desc - **TEST METHOD - To demonstrate what happens when an interceptor step fails	
	*/
	public void setLog() {
		log = null;
	}
	
	/**
	 *@name findElement(By arg0)
	 *@param By arg0 
	 *@return void
	 *@desc - Returns the element matching the input (Default selenium method)	
	*/
	public List<WebElement> findElement(By arg0) {
		if (state instanceof TestingState)	{
			List<WebElement> temp = new ArrayList<>();
			temp.add(driver.findElement(arg0));
			return temp;
		}
		else	{
			System.out.println("Browser closed, findElement() not a valid command");
			return null;
		}
	}

	/**
	 *@name findElements(By arg0)
	 *@param By arg0 
	 *@return void
	 *@desc - Returns the list of elements matching the input (Default selenium method)	
	*/
	public List<List<WebElement>> findElements(By arg0) {
		if (state instanceof TestingState)	{
			List<List<WebElement>> temp = new ArrayList<>();
			temp.add(driver.findElements(arg0));
			return temp;
		}
		else	{
			System.out.println("Browser closed, findElements() not a valid command");
			return null;
		}
	}

	/**
	 *@name get(String arg0)
	 *@param String arg0 
	 *@return void
	 *@desc - Goes to the specified URL (Default selenium method)	
	*/
	public void get(String arg0) {
		if (state instanceof TestingState)	{
			driver.get(arg0);
		}
		else	{
			System.out.println("Browser closed, get() not a valid command");
		}
	}

	/**
	 *@name getCurrentUrl()
	 *@return void
	 *@desc - Gets current URL (Default selenium method)	
	*/
	public List<String> getCurrentUrl() {
		if (state instanceof TestingState)	{
			List<String> temp = new ArrayList<>();
			temp.add(driver.getCurrentUrl());
			return temp;
		}
		else	{
			System.out.println("Browser closed, getCurrentUrl() not a valid command");
			return null;
		}
	}

	/**
	 *@name getPageSource()
	 *@return String
	 *@desc - Gets the page source (Default selenium method)	
	*/
	public List<String> getPageSource() {
		if (state instanceof TestingState)	{
			List<String> temp = new ArrayList<>();
			temp.add(driver.getPageSource());
			return temp;
		}
		else	{
			System.out.println("Browser closed, getPageSource() not a valid command");
			return null;
		}
	}

	
	/**
	 *@name getTitle()
	 *@return String
	 *@desc - Gets page title (Default selenium method)	
	*/
	public List<String> getTitle() {
		if (state instanceof TestingState)	{
			List<String> temp = new ArrayList<>();
			temp.add(driver.getTitle());
			return temp;
		}
		else	{
			System.out.println("Browser closed, getTitle() not a valid command");
			return null;
		}
	}

	
	/**
	 *@name getWindowHandle()
	 *@return String
	 *@desc - Gets the window handle (Default selenium method)	
	*/
	public List<String> getWindowHandle() {
		if (state instanceof TestingState)	{
			List<String> temp = new ArrayList<>();
			temp.add(driver.getWindowHandle());
			return temp;
		}
		else	{
			System.out.println("Browser closed, getWindowHandle() not a valid command");
			return null;
		}
	}

	/**
	 *@name getWindowHandles()
	 *@return Set<String>
	 *@desc -Returns a set of window handles (Default selenium method)	
	*/
	public Set<String> getWindowHandles() {
		if (state instanceof TestingState)	{
			return driver.getWindowHandles();
		}
		else	{
			System.out.println("Browser closed, getWindowHandle() not a valid method");
			return null;
		}
	}

	/**
	 *@name manage()
	 *@return Options
	 *@desc - Returns the driver options (Default selenium method)	
	*/
	public Options manage() {
		if (state instanceof TestingState)	{
			return driver.manage();
		}
		else	{
			System.out.println("Browser closed, manage() not a valid method");
			return null;
		}
	}

	/**
	 *@name navigate()
	 *@return Navigation
	 *@desc - Returns browser navigation (Default selenium method)	
	*/
	public Navigation navigate() {
		if (state instanceof TestingState)	{
			return driver.navigate();
		}
		else	{
			System.out.println("Browser closed, navigate() not a valid method");
			return null;
		}
	}

	
	/**
	 *@name quit()
	 *@return void
	 *@desc - Closes the browser (Default selenium method)	
	*/
	public void quit() {
		driver.quit();
	}
	
	/**
	 *@name getDriver()
	 *@return WebDriver
	 *@desc - Returns the assosciated driver (Default selenium method)	
	*/
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 *@name switchTo()
	 *@return TargetLocator
	 *@desc - Returns a TargetLocator for the browser, used for IFramed mostly (Default selenium method)	
	*/
	public TargetLocator switchTo() {
		if (state instanceof TestingState)	{
			return driver.switchTo();
		}
		else	{
			System.out.println("Browser closed, switchTo() not a valid command");
			return null;
		}
	}
	
	/**
	 *@name addAction(String action)
	 *@param String action 
	 *@return void
	 *@desc - Adds an action to the log of this browser
	*/
	public void addAction(String action) {
		if (state instanceof TestingState)	{
			log.addAction(action);
		}
		else	{
			System.out.println("Browser closed, addAction() not a valid command");
		}
	}
	
	/**
	 *@name writeReport()
	 *@return void
	 *@desc - Writes the log report to a txt file	
	*/
	public void writeReport() throws IOException {
		if (state instanceof TestingState)	{
			log.getReport();
		}
		else	{
			System.out.println("Browser closed, writeReport() not a valid command");
		}
	}
	
	/**
	 *@name startTest()
	 *@return void
	 *@desc - Logs the start of a test	
	*/
	public void startTest() {
		if (state instanceof TestingState)	{
			log.startTest();
		}
		else	{
			System.out.println("Browser closed, startTest() not a valid command");
		}
	}
	
	/**
	 *@name passedTest()
	 *@return void
	 *@desc - Logs a passed test case	
	*/
	public void passedTest() {
		if (state instanceof TestingState)	{
			log.passedTest();
		}
		else	{
			System.out.println("Browser closed, startTest() not a valid command");
		}
	}
	
	/**
	 *@name displayTestStatistics()
	 *@return void
	 *@desc - Displays results of test suite	
	*/
	public void displayTestStats() {
		if (state instanceof TestingState)	{
			log.updateView();
		}
		else	{
			System.out.println("Browser closed, displayTestStats() not a valid command");
		}
	}

	/**
	 *@name errorHandler()
	 *@return void
	 *@desc - Logs an error in a test case	
	*/
	public void errorHandler(Exception e) {
		// TODO Auto-generated method stub
		log.errorHandler(e);
	}

	/**
	 * @name saveToMemento()
	 * @return BrowserMemento
	 * @desc - Saves the current state of the browser to a memento
	 */
	public BrowserMemento saveToMemento()	{
		return new BrowserMemento(driver, log, state, getCurrentUrl());
	}
	
	/**
	 * @name restoreToState()
	 * @param BrowserMemento m
	 * @return None
	 * @desc - Sets this browser to a saved state
	 */
	public void restoreToState(BrowserMemento m)	{
		this.driver = m.getDriver();
		this.log = m.getLogController();
		this.state = m.getState();
		this.get(m.getURL().get(0));
	}
}