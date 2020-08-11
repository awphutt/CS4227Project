package seleniumWrapper.fileChecker;

import java.io.File;

public interface FileFilter {
	/**
	 *@name validationCheck
	 *@return void
	 *@desc - Is a method to be used by any class that hopes to be used for validation interceptor points
	*/
	public String validationCheck(File target);
}
