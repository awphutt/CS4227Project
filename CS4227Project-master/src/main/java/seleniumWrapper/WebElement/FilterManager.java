package seleniumWrapper.WebElement;

import org.openqa.selenium.WebElement;

import seleniumWrapper.Browser;
import seleniumWrapper.BrowserInterface;

public class FilterManager {

	FilterChain filterChain;
	

	   public FilterManager(WebElement target,BrowserInterface browser){
	      filterChain = new FilterChain(browser);
	      filterChain.setTarget(target);
	   }
	   
	   
	   /**
		 *@name setKeys(String keys)
		 *@param String keys
		 *@return void
		 *@desc - Sets the keys that will be used for the sendKeysCommand
		*/
	   public void setKeys(String keys) {
		   filterChain.setKeys(keys);
	   }
	   
	   
	   /**
		 *@name setFilter(Filter)
		 *@param FileFilter
		 *@return void
		 *@desc - Adds a filter to the chain
		*/
	   public void setFilter(Filter filter){
	      filterChain.addFilter(filter);
	   }

	   
	   /**
		 *@name filterRequest(String request)
		 *@param String request
		 *@return void
		 *@desc - Executes the request
		*/
	   public void filterRequest(String request){
	      filterChain.execute(request);
	   }
}
