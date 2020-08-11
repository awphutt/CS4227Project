package seleniumWrapper.Page;

import seleniumWrapper.Browser;
import seleniumWrapper.Config;
import seleniumWrapper.WebElement.Button;
import seleniumWrapper.WebElement.TextBox;

public class SignUpPage implements Page{
	
	String firstNameXpath;
	String lastNameXpath;
	String usernameXpath;
	String passwordXpath;
	String confirmPWXpath;
	String submitButton;
	String url;
	Browser myBrowser = new Browser(Config.chrome);
	ConcreteUser user;
	
	public SignUpPage(String firstNameXpath, String lastNameXpath, String usernameXpath, String passwordXpath, String confirmPWXpath, String submitButton, String url) 
	{
		this.firstNameXpath = firstNameXpath;
		this.lastNameXpath = lastNameXpath;
		this.usernameXpath = usernameXpath;
		this.passwordXpath = passwordXpath;
		this.confirmPWXpath = confirmPWXpath;
		this.submitButton = submitButton;
		this.url = url;
		user = new ConcreteUser("Adam", "Copeland", "lol", "lolo");
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
	    	System.out.print("skjdfhisufhwisjfbsoigigfiuehfiuh");
			TextBox firstName = new TextBox(firstNameXpath, myBrowser);
			TextBox lastName = new TextBox(lastNameXpath, myBrowser);
			TextBox username = new TextBox(usernameXpath, myBrowser);
			TextBox password = new TextBox(passwordXpath, myBrowser);
			TextBox confirmPassword = new TextBox(confirmPWXpath, myBrowser);
			Button submit = new Button(submitButton, myBrowser);
			
	    	firstName.sendKeys(user.getFirstName());
			lastName.sendKeys(user.getLastName());
			username.sendKeys(user.getUserName());
			password.sendKeys(user.getPassword());
			confirmPassword.sendKeys(user.getPassword());
			
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
