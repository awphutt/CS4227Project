package seleniumWrapper.Page;

import seleniumWrapper.Browser;
import seleniumWrapper.Config;
import seleniumWrapper.WebElement.Button;
import seleniumWrapper.WebElement.TextBox;

public class SearchPage implements Page{
	
	String searchBarXpath;
	String submitButton;
	
	String url;
	Browser myBrowser = new Browser(Config.chrome);
	ConcreteUser user;
	
	public SearchPage(String searchBarXpath, String submitButton, String url)
	{
		this.searchBarXpath = searchBarXpath;
		this.submitButton = submitButton;
		this.url = url;
		user = new ConcreteUser();
	}
	
	/**
	 *@name testPage()
	 *@param none 
	 *@return void
	 *@desc - Method for testing website taken from the interface Page
	*/
	@Override
	public void testPage() {
		try
		{
			myBrowser.get(url);
	    	Thread.sleep(2000);
	    	TextBox searchBar = new TextBox(searchBarXpath, myBrowser);
			Button submit = new Button(submitButton, myBrowser);
			searchBar.sendKeys("hello world");
			submit.click();
			myBrowser.passedTest();
			myBrowser.close();
		}
		catch(Exception e)
		{
			myBrowser.errorHandler(e);
		}
	}
	
	
	/**
	 *@name setUser()
	 *@param Pass a Concrete user 
	 *@return void
	 *@desc - Method for setting user of website
	*/
	@Override
	public void setUser(ConcreteUser user) {
		this.user = user;
	}

}
