package seleniumWrapper.Commands;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import seleniumWrapper.WebElement.ElementHandler;

import static org.junit.Assert.fail;

import java.util.List;

public class SubmitCommand implements CommandInterface {
    private final WebElement elementHandler;

    public SubmitCommand(WebElement elementHandler) {
        this.elementHandler = elementHandler;
    }

    
    public String execute() {
    	try {
    		elementHandler.submit();
    	}
    	catch (StaleElementReferenceException stale) {
    		return "Stale Element";
    	}
    	return "Submitted";
    }
}
