package seleniumWrapper.WebElement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import seleniumWrapper.Browser;
import seleniumWrapper.BrowserInterface;
import seleniumWrapper.Commands.ClickCommand;
import seleniumWrapper.Commands.CommandInterface;
import seleniumWrapper.Commands.SendKeysCommand;
import seleniumWrapper.Commands.SubmitCommand;

public class FilterChain {
	private List<Filter> filters = new ArrayList<Filter>();
	 private WebElement target;
	 private Handler handler;
	private CommandInterface clickCommand;
   	private CommandInterface submitCommand;
	CommandInterface sendKeysCommand;
   	private BrowserInterface browser;
   	private String keys="";
   
	 

	 public FilterChain(BrowserInterface b) {
		 browser =b;
	 }
	 
	 /**
		 *@name addFilter(Filter filter)
		 *@param FileFilter
		 *@return void
		 *@desc - Adds a filter to the chain
		*/
	   public void addFilter(Filter filter){
	      filters.add(filter);
	   }
	   

	   /**
		 *@name execute(String request)
		 *@param String request
		 *@return void
		 *@desc - Executes an action on a target after executing the filters - If any filter fails the action is aborted
		*/
	   public void execute(String request){
		   //Cancel execution if any step fails
		   boolean passed=true;
	      for (Filter filter : filters) {
	         passed = filter.execute(target,browser,request);
	         if(!passed) {
	        	 System.out.println("Interceptor step failed, aborting action");
	        	 break;
	         }
	      }
	     if(passed) {
	    	 //execute request if all interceptor steps pass
	    	 handler.execute(request);
	     }
	   }

	   
	   /**
		 *@name setTarget(WebElement target)
		 *@param WebElement
		 *@return void
		 *@desc -Sets the target of the filter chain, concrete commands need to be re-registered
		*/
	   public void setTarget(WebElement target){
	      this.target = target;
	      //Need to re-register all commands and handlers if new target is set
		  clickCommand = new ClickCommand(target);
		  submitCommand = new SubmitCommand(target);
		  handler = new Handler();
		  handler.register("click", clickCommand);
		  handler.register("submit", submitCommand);
	   }
	   
	   
	   /**
		 *@name setKeys(String keys)
		 *@param String keys
		 *@return void
		 *@desc - Sets the keys that will be used for the sendKeysCommand
		*/
	   public void setKeys(String keys) {
		   this.keys = keys;
			 sendKeysCommand = new SendKeysCommand(target, keys);
			 handler.register("sendKeys", sendKeysCommand);
	   }

}
