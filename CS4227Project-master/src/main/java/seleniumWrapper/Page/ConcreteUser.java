package seleniumWrapper.Page;

public class ConcreteUser extends PrototypeUser
{
	public ConcreteUser()
	{
		this.firstName = "";
		this.lastName = ""; 
		this.userName = "";
		this.password = "";
	}
	
	public ConcreteUser(String userName, String password)
	{
		this.firstName = "";
		this.lastName = ""; 
		this.userName = userName;
		this.password = password;
	}
	
	public ConcreteUser(String firstName, String lastName, String userName, String password)
	{
		this.firstName = firstName;
		this.lastName = lastName; 
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 *@name getFirstName()
	 *@return String
	 *@desc - Method for getting first name of user
	*/
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 *@name getLastName()
	 *@return String
	 *@desc - Method for getting last name of user
	*/
	public String getLastName()
	{
		return lastName;
	}
	
	/**
//	 *@name getUserName()
	 *@return String
	 *@desc - Method for getting username of user
	*/
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 *@name setUser()
	 *@return String
	 *@desc - Method for getting password of user
	*/
	public String getPassword()
	{
		return password;
	}
	
	/**
	 *@name setFirstName()
	 *@param Pass a String for first name 
	 *@return void
	 *@desc - Method for setting users first name
	*/
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	/**
	 *@name setLastName()
	 *@param  Pass a String for last name
	 *@return void
	 *@desc - Method for setting users last name
	*/
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	/**
	 *@name setUserName()
	 *@param  Pass a String for username
	 *@return void
	 *@desc - Method for setting username
	*/
	public void setUserName(String username)
	{
		this.userName = username;
	}
	
	/**
	 *@name setPassword()
	 *@param  Pass a String for password
	 *@return void
	 *@desc - Method for setting users password
	*/
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	/**
	 *@name clone()
	 *@param None 
	 *@return ConcreteUser
	 *@desc - Method for cloning this ConcreteUser
	*/
	@Override
	public Object clone() {
		return new ConcreteUser(this.firstName, this.lastName, this.userName, this.password);
	}

}
