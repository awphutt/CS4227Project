package seleniumWrapper.Commands;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import seleniumWrapper.WebElement.ElementHandler;

import static org.junit.Assert.fail;

import java.net.URL;
import java.util.List;


public class TextCheckCommand implements CommandInterface {
    private final WebElement elementHandler;
    private String textToMatch;

    public TextCheckCommand(WebElement elementHandler, String textToMatch) {
        this.elementHandler = elementHandler;
        this.textToMatch = textToMatch;
    }

    public String execute() {
    	try {
    		if(elementHandler == null)
    			return "Element Null";
    	    else if(elementHandler.getText().matches(textToMatch)) 
    			return "Text Matched";
    		else 
    			return "Text did not match: Expected: " + textToMatch + " Actual: " + elementHandler.getText();
    	}
    	catch (StaleElementReferenceException stale) {
    		return "Stale Element";
    	}
    }
}
