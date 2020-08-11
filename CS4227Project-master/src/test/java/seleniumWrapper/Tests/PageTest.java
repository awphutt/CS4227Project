package seleniumWrapper.Tests;

import org.junit.Test;

import seleniumWrapper.Page.ConcreteUser;
import seleniumWrapper.Page.Page;
import seleniumWrapper.Page.PageFactory;
import seleniumWrapper.Page.PageFactory.PageType;

public class PageTest {
	ConcreteUser user = new ConcreteUser("James", "Kirby", "lol", "lolo"); 
	ConcreteUser user2 = (ConcreteUser) user.clone();
	Page page;
	
	@Test
    public void GoogleSignUpCheck()
    {
		System.out.print("hello");
		page = PageFactory.getPage(PageType.GOOGLESIGNUPPAGE);
		page.setUser(user);
    	System.out.print("hello");
    	page.testPage();
    }
	
	@Test
    public void loginPageCheck()
    {
		user2.setFirstName("Adam");
		page = PageFactory.getPage(PageType.LOGINPAGE);
		page.setUser(user2);
		page.testPage();
    }
	
	 @Test
	 public void SearchPageCheck()
    {
		 page = PageFactory.getPage(PageType.GOOGLESEARCH);
		 page.testPage();
	}
	 
	@Test
	public void ButtonOnPageCheck()
    {
		page = PageFactory.getPage(PageType.BUTTONONPAGE);
		page.testPage();
	}
	
	@Test
	public void GithubLoginPageCheck()
	{
		page = PageFactory.getPage(PageType.GITHUBLOGIN);
		page.testPage();
	}
	
	@Test
	public void InstaLoginPageCheck()
	{
		page = PageFactory.getPage(PageType.INSTALOGIN);
		page.testPage();
	}
	
	@Test
	public void netflixLoginCheck()
	{
		page = PageFactory.getPage(PageType.NETFLIXLOGIN);
		page.testPage();
	}

	@Test
	public void youtubeSearchCheck()
	{
		page = PageFactory.getPage(PageType.YOUTUBESEARCH);
		page.testPage();
	}
}
