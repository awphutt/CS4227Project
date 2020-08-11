package seleniumWrapper.fileChecker;

import java.io.File;

public class ContentValidation implements FileFilter{
	
	private String fileExtension;
	private int fileSize;

	public ContentValidation(String ext, int size) {
		fileExtension = ext;
		fileSize = size;
	}
	
	/**
	 *@name validationCheck
	 *@param File target - the file in which we want to perform validation checks on
	 *@return String - the feedback from the validation checks	 
	 **@desc - performs validations checks on the target file
	*/
	@Override
	public String validationCheck(File target) {
		String output = "";
		if(!getFileExtension(target).equals(fileExtension))
			output += "Error: Extension on file was: " + getFileExtension(target) + " but was meant to be: " + fileExtension + "\n";
		output += sizeChecks(target);
		if(output.equals(""))
			System.out.println("Content test passed");
		return output; 
	}
	
	/**
	 *@name getFileExtension
	 *@param target - the file in which we want to get the extension from
	 *@return String - the file extension of the target
	 *@desc - returns the file extension of the given target file
	*/
	private String getFileExtension(File target) {
		String filePath = target.getAbsolutePath();
	    int indexOfDot = filePath.indexOf(".");
	    return filePath.substring(indexOfDot);
	}
	
	/**
	 *@name sizeChecks
	 *@param File target - the file in which we want to perform the size checks on
	 *@return String - the feedback to send back for error handling by client user
	 *@desc - Checks the size of the file in terms to the limit set by configurations
	*/
	private String sizeChecks(File target) {
		if(target.length() > fileSize)
			return "Error: File size was greater than: " + target.length() + " but was meant to be less than: " + fileSize + "\n";
		else if(target.length() == fileSize)
			return "File size was the same size as the limit: " + fileSize + "\n";
		return "";
	}
}
