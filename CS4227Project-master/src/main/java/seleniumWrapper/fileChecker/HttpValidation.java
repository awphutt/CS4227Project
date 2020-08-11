package seleniumWrapper.fileChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import seleniumWrapper.Commands.CommandInterface;
import seleniumWrapper.Commands.HttpsCheckCommand;

public class HttpValidation implements FileFilter{
	private String response;
	
	public HttpValidation(String HttpRequest) {
    	CommandInterface httpCheck = new HttpsCheckCommand("http://webcode.me");
    	response = httpCheck.execute();
	}

	@Override
	public String validationCheck(File target) {
		String[] responseLines = response.split("\n");
		Scanner fileScanner;
		try {
			fileScanner = new Scanner(target);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return "Error: File validator not found\\n";
		}
		
		String lineFromFile;
		
		while(fileScanner.hasNextLine()) {
			for(String line: responseLines) {
				lineFromFile = fileScanner.nextLine().trim();
				if(lineFromFile.equals("</html>"))
					break;

				if(!lineFromFile.equals(line.trim())) {
					return "Error: Response does not match validator\\n";
				}
			}
        } 
		return "Response matched validator\n";
	}

}
