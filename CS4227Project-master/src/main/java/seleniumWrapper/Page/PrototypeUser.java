package seleniumWrapper.Page;

public abstract class PrototypeUser implements Cloneable {
	
	protected String firstName;
	protected String lastName;
	protected String userName;
	protected String password;
	
	public abstract Object clone();
}
