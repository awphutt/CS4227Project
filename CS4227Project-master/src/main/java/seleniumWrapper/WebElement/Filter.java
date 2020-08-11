package seleniumWrapper.WebElement;

import org.openqa.selenium.WebElement;

import seleniumWrapper.Browser;
import seleniumWrapper.BrowserInterface;

public interface Filter {
	/**
	 *@name execute(WebElement e,Browser b,String request)
	 *@param None
	 *@return void
	 *@desc - Logs a passed test case	
	*/
	public boolean execute(WebElement e,BrowserInterface b,String request); 

}
