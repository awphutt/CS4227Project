package seleniumWrapper.fileChecker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LogFilter implements FileFilter{
	
	public LogFilter() {
		
	}
	
	@Override
	public String validationCheck(File target) {
		String output = "";
		String line = null;
		System.out.println("Log Filter on the file: " + target.getPath());
		
		 try {
			    Scanner scanner = new Scanner(target);

	            while(scanner.hasNextLine()) {
	                output += scanner.nextLine() + "\n";
	            }   

	            scanner.close();         
	        }
	        catch(FileNotFoundException ex) {
	            output += "Error: Unable to open file: '" +  target.getName() + "'";                
	        }
	        catch(IOException ex) {
	            output += "Error: Error reading file: '" + target.getName() + "'";     
	        }
		return output; 
    }
}
