package seleniumWrapper.Commands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import seleniumWrapper.Browser;
import seleniumWrapper.BrowserInterface;


public class UICheckCommand implements CommandInterface {
    private CommandInterface click;
    private CommandInterface sendKeys;
    private CommandInterface submit;
    private CommandInterface textCheck;
    private int secondsToWaitForOutput;
    private BrowserInterface browser;
    private String elementToCheckID;
    private String textToCheck;

	/**
	 *@name InputDataAndCheckCommand
	 *@param elementForInput - WebElement in which we want to input data into.
	 *		 textForInput - Data we want to input to element
	 *       elementToCheckID - ID for WebElement we wish to perform text check on after submission
	 *       textToCheck - Data we wish to check
	 *       secondsToWaitForOutput - seconds of delay after submission
	 *       browser - fallback for searching for check element
	 *@return NONE
	 *@desc - Command used to check a fields data after a submission request. IE after login a certain text box appears
	*/
    public UICheckCommand(WebElement elementForInput, String textForInput, 
    		 String elementToCheckID, String textToCheck, int secondsToWaitForOutput, BrowserInterface browser) {
        click = new ClickCommand(elementForInput);
        sendKeys = new SendKeysCommand(elementForInput, textForInput);
        submit = new SubmitCommand(elementForInput);
        textCheck = new TextCheckCommand(browser.findElement(By.name(elementToCheckID)).get(0), textToCheck);
        this.secondsToWaitForOutput = secondsToWaitForOutput;
        this.browser = browser;
        this.elementToCheckID = elementToCheckID;
        this.textToCheck = textToCheck;
    }

    /**
	 *@name execute
	 *@return String to be used for error handling if results are bad
	 *@desc - execution causes a given text field to be filled with text and then submitted. 
	 *Then after a delay it checks the text in another field
	*/
    public String execute() {
    	click.execute();
    	sendKeys.execute();
    	submit.execute();
    	try {
			Thread.sleep(secondsToWaitForOutput * 1000);
		} catch (InterruptedException e) {
			return "Thread Failure";
		}

    	String result = textCheck.execute(); 
    	if(result.equals("Stale Element")) {
    		textCheck = new TextCheckCommand(browser.findElement(By.name(elementToCheckID)).get(0), textToCheck);
    		result = textCheck.execute();
    	}
    	return result;
    }
}
