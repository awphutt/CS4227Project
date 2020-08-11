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
import seleniumWrapper.Commands.SendKeysCommand;

public class TextBox extends ElementHandler{

	private Browser browse;
	private String xPath;
	
	public TextBox (String xPath, Browser browse) {
		super(browse.getDriver().findElement(By.xpath(xPath)));		
		this.xPath = xPath;
		this.browse = browse;
	}
	
	/**
	 *@name getBrowser()
	 *@param None
	 *@return Browser
	 *@desc - Returns browser of the element
	*/
	public Browser getBrowser()	{
		return browse;
	}
	
	/**
	 *@name setBrowser()
	 *@param Browser browse
	 *@return void
	 *@desc - Sets the browser of the element
	*/
	public void setBrowser(Browser browse)	{
		this.browse = browse;
	}
	
	/**
	 *@name getXpath()
	 *@param None
	 *@return String
	 *@desc - Returns element's xPath
	*/
	public String getXPath()	{
		return xPath;
	}
	
	/**
	 *@name setXpath()
	 *@param String xPath
	 *@return void
	 *@desc - Sets element's xPath
	*/
	public void setXPath(String xPath)	{
		this.xPath = xPath;
	}
}
