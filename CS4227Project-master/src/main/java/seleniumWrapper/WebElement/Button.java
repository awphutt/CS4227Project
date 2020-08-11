package seleniumWrapper.WebElement;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import seleniumWrapper.Browser;
import seleniumWrapper.Commands.ClickCommand;
import seleniumWrapper.Commands.SubmitCommand;

public class Button extends ElementHandler {

	private Browser browse;
	private String xPath;
	
	public Button (String xPath, Browser browse) {
		super(browse.getDriver().findElement(By.xpath(xPath)));	
		this.xPath = xPath;
		this.browse = browse;
	}
	
	/**
	 *@name sendKeys()
	 *@param CharSequence... keysToSend
	 *@return void
	 *@desc - Method invalid for buttons
	*/
	@Override
	public void sendKeys(CharSequence... keysToSend) {
		browse.addAction("sendKeys() invalid for Buttons");
	}
	
	/**
	 *@name clear()
	 *@param None
	 *@return void
	 *@desc - Method invalid for buttons	
	*/
	@Override
	public void clear() {
		browse.addAction("clear() invalid for Button");
	}
	
	/**
	 *@name getBrowser()
	 *@param None
	 *@return Browser
	 *@desc - Returns the button's browser	
	*/
	public Browser getBrowser()	{
		return browse;
	}
	
	/**
	 *@name setBrowser()
	 *@param Browser browse
	 *@return void
	 *@desc - Sets button's browser	
	*/
	public void setBrowser(Browser browse)	{
		this.browse = browse;
	}
	
	/**
	 *@name getXPath()
	 *@param None
	 *@return String xPath
	 *@desc - Returns the xPath of the element
	*/
	public String getXPath()	{
		return xPath;
	}
	
	/**
	 *@name setXpath()
	 *@param String xPath
	 *@return void
	 *@desc - Sets xPath of the element
	*/
	public void setXPath(String xPath)	{
		this.xPath = xPath;
	}
}