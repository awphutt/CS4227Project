package seleniumWrapper.WebElement;

import org.openqa.selenium.WebElement;

import seleniumWrapper.Browser;
import seleniumWrapper.BrowserInterface;

public class LogFilter implements Filter{

	public LogFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 *@name execute(WebElement e,Browser b,String request)
	 *@param WebElement e - The target
	 *		 Browser b - For Logging purposes
	 *		 String request
	 *@return boolean
	 *@desc - Logs an action
	*/
	@Override
	public boolean execute(WebElement e, BrowserInterface b,String request) {
		try {
			//b.setLog();   //--Uncomment this line to see interceptor aborting steps
			b.addAction(request+"On Element:"+e);
			System.out.println(request+"On Element:"+e);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	

}
