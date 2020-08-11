package seleniumWrapper.WebElement;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.fail;

import java.util.List;

public class WebElementHandlers {
	
	private List<WebElement> elements;
	
	public int size() {
		return elements.size();
	}
	
    public static void waitForElementToDissapear(WebElement element, int secondsToWaitFor){
        for(int i = 0; i < secondsToWaitFor; i++) {
            try {
                element.isDisplayed();
                Thread.sleep(1000);
            } catch (StaleElementReferenceException exc) {
                return;
            } catch (NoSuchElementException e) {
                return;
            } catch (InterruptedException e) {
                System.out.println("Thread Failure");
            }
        }
        fail("WebElement did not disappear after " + secondsToWaitFor + " seconds");
    }
}