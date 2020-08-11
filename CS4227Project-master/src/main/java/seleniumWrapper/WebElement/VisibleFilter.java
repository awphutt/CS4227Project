package seleniumWrapper.WebElement;

import org.openqa.selenium.WebElement;

import seleniumWrapper.Browser;
import seleniumWrapper.BrowserInterface;

public class VisibleFilter implements Filter {

	public VisibleFilter() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 *@name execute(WebElement e,Browser b,String request)
	 *@param WebElement e - The target, Browser b - For Logging purposes, String request
	 *@return boolean
	 *@desc - Checks if the specified element is visible	
	*/
	@Override
	public boolean execute(WebElement e,BrowserInterface b,String request) {
		System.out.println("Element is visible:"+e.isDisplayed());
		return e.isDisplayed();
	}

}
