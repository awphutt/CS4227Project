package seleniumWrapper;

import java.util.List;
import org.openqa.selenium.WebDriver;
import seleniumWrapper.Logger.LogController;

public class BrowserMemento {
	
	private WebDriver driver;
	private LogController log;
	private BrowserState state;
	private List<String> url;
	
	public BrowserMemento(WebDriver driver, LogController log, BrowserState state, List<String> url)	{
		this.driver = driver;
		this.log = log;
		this.state = state;
		this.url = url;
	}
	
	/**
	 * @name getDriver()
	 * @return WebDriver
	 * @desc - Returns the BrowserMemento's driver
	 */
	public WebDriver getDriver()	{
		return driver;
	}
	
	/**
	 * @name setDriver()
	 * @param WebDriver driver
	 * @return void
	 * @desc - Sets the BrowserMemento's driver
	 */
	public void setDriver(WebDriver driver)	{
		this.driver = driver;
	}
	
	/**
	 * @name getLogController()
	 * @return LogController
	 * @desc - Returns the BrowserMemento's log controller
	 */
	public LogController getLogController()	{
		return log;
	}
	
	/**
	 * @name setLogController()
	 * @param LogController log
	 * @return void
	 * @desc - Sets the BrowserMemento's log controller
	 */
	public void setLogController(LogController log)	{
		this.log = log;
	}
	
	/**
	 * @name getState()
	 * @return BrowserState
	 * @desc - Returns the BrowserMemento's state
	 */
	public BrowserState getState()	{
		return state;
	}
	
	/**
	 * @name setState()
	 * @param BrowserState
	 * @return void
	 * @desc - Sets the BrowserMemento's state
	 */
	public void getState(BrowserState state)	{
		this.state = state;
	}
	
	/**
	 * @name getURL()
	 * @return List<String>
	 * @desc - Returns the BrowserMemento's URL
	 */
	public List<String> getURL()	{
		return url;
	}
	
	/**
	 * @name setURL()
	 * @param List<String>
	 * @return void
	 * @desc - Set the BrowserMemento's URL
	 */
	public void setURL(List<String> url)	{
		this.url = url;
	}
}
