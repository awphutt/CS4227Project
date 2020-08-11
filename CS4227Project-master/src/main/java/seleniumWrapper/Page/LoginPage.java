package seleniumWrapper.Page;


import seleniumWrapper.Browser;
import seleniumWrapper.Config;
import seleniumWrapper.WebElement.Button;
import seleniumWrapper.WebElement.TextBox;
public class LoginPage implements Page
{
	private String url;
	private String usernameXpath;
	private String paswordXpath;
	private String submitButton;
	Browser myBrowser = new Browser(Config.chrome);
	ConcreteUser user;

	public LoginPage(String usernameXpath, String paswordXpath, String submitButton, String url) 
	{
		this.url = url;
		try
		{
			this.usernameXpath = usernameXpath;
			this.paswordXpath = paswordXpath;
			this.submitButton = submitButton;
			user = new ConcreteUser("Adam", "Copeland", "lol", "lolo");
		}
		catch(Exception printstacktrace)
		{
			System.out.print(printstacktrace);
		}
	}
	
	/**
	 *@name setUser()
	 *@param Pass a Concrete user 
	 *@return void
	 *@desc - Method for setting user of website
	*/
	public void setUser(ConcreteUser user)
	{
		this.user = user;
	}

	/**
	 *@name setUser()
	 *@param Pass a Concrete user 
	 *@return void
	 *@desc - Method for setting user of website
	*/
	@Override
	public void testPage() {
		try 
		{
			
			myBrowser.get(url);
	    	Thread.sleep(2000);
	    	TextBox uname = new TextBox(usernameXpath, myBrowser);
	    	TextBox pword = new TextBox(paswordXpath, myBrowser);
			Button submit = new Button(submitButton, myBrowser);
			uname.sendKeys(user.getUserName());
			pword.sendKeys(user.getPassword());
			submit.click();
			myBrowser.passedTest();
			myBrowser.close();
		}
		catch(Exception e) 
		{
			myBrowser.errorHandler(e);  
		} 
	}
}

