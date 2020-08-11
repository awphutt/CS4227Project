package seleniumWrapper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface BrowserInterface {
	public void close();
	public void quit();
	public void get(String URL);
	public void startTest();
	public void errorHandler(Exception e);
	public void passedTest();
	public List<WebElement> findElement(By b);
	public List<List<WebElement>> findElements(By b);
	public List<String> getCurrentUrl();
	public List<String> getPageSource();
	public List<String> getTitle();
	public List<String> getWindowHandle();
	public void addAction(String string);
	
}
