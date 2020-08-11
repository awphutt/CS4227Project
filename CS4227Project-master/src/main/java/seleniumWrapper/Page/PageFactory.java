package seleniumWrapper.Page;

public abstract class PageFactory {
	
	public enum PageType {
	    LOGINPAGE,
	    GOOGLESIGNUPPAGE,	    
	    GOOGLESEARCH,	    
	    BUTTONONPAGE,	    
	    GITHUBLOGIN,	    
	    INSTALOGIN,	    
	    NETFLIXLOGIN,	    
	    YOUTUBESEARCH
	}
	
	/**
	 *@name getPage()
	 *@param Pass the type of page to create
	 *@return page
	 *@desc - factory for creating pages
	*/
	public static Page getPage(PageType name) {
		Page page = null;
		switch(name) 
		{
			case LOGINPAGE:
				page = new LoginPage("//*[@id=\"email\"]", "//*[@id=\"pass\"]", "//*[@id=\"loginbutton\"]", "https://www.facebook.com/?stype=lo&jlou=Afe3LTKY9wMMPDeuhoMupdZq1rRtykGVVKEK4H3zjxXLczrk1ikN2JlMUHa7ZZxUDmQxYkZERmEqcJL9KReRt-BScx2qwLkWa901rA6QKxbkag&smuh=9211&lh=Ac_4cCfhZ6w2ek2m");
				break;
			case GOOGLESIGNUPPAGE:
				page = new SignUpPage("//*[@id=\"firstName\"]", "//*[@id=\"lastName\"]", "//*[@id=\"username\"]", "//*[@id=\"passwd\"]/div[1]/div/div[1]/input", "//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input", "//*[@id=\"accountDetailsNext\"]/span/span", "https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
				break;
			case GOOGLESEARCH:
				page = new SearchPage("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input", "//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]", "https://www.google.com");
				break;
			case BUTTONONPAGE:
				page = new ButtonOnPage("//*[@id=\"nav_toggle\"]", "https://www.thegamecollection.net");
				break;
			case GITHUBLOGIN:
				page = new LoginPage("//*[@id=\"login_field\"]", "/html/body/div[3]/main/div/form/div[3]/input[2]", "//*[@id=\"login\"]/form/div[3]/input[8]", "https://github.com/login");
				break;
			case INSTALOGIN:
				page = new LoginPage("/html/body/span/section/main/div/article/div/div[1]/div/form/div[2]/div/label/input", "//*[@id=\"react-root\"]/section/main/div/article/div/div[1]/div/form/div[3]/div/label/input", "//*[@id=\"react-root\"]/section/main/div/article/div/div[1]/div/form/div[4]", "https://www.instagram.com/accounts/login/?hl=en&source=auth_switcher");
				break;
			case NETFLIXLOGIN:
				page = new LoginPage("//*[@id=\"id_userLoginId\"]", "//*[@id=\"id_password\"]", "//*[@id=\"appMountPoint\"]/div/div[3]/div/div/div[1]/form/button", "https://www.netflix.com/ie/login");
				break;
			case YOUTUBESEARCH:
				page = new SearchPage("//*[@id=\"search\"]", "//*[@id=\"search-icon-legacy\"]/yt-icon", "https://www.youtube.com/");
				break;
		} 
		return page;	
	}
}
