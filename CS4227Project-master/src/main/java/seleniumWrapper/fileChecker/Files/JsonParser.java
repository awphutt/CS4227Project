package seleniumWrapper.fileChecker.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class JsonParser {
	
	private static File schema;
	private static File fileToCheck;
	private static String id; 
	private static Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
	private static Map<String, String> tempMap = new HashMap<String, String>();
	private static Map<String, String> fileMap = new HashMap<String, String>();
	
	/**
	 *@name parseFiles
	 *@param File schemaFile - this is the schema to be parsed the user wants to check against the target file
	 *		 File file - this is the file to be parsed the user wants to check against the schema
	 *@return void
	 *@desc - Sets up and calls parser methods
	*/
	public static void parseFiles(File schemaFile, File file) {
		schema = schemaFile;
		fileToCheck = file;
		parseSchema();
		parseFileToCheck();
	}
	
	/**
	 *@name parseSchema
	 *@return void
	 *@desc - parses jsonSchema file so that it can check it against the target file
	*/
	public static void parseSchema() {
		String output = "";
		String line = null;
		
		try {
			Scanner scanner = new Scanner(schema);

            while(scanner.hasNextLine()) {
            	line = scanner.nextLine();
            	schemaCharacterChecks(line);
            }   

            scanner.close();         
        }
        catch(FileNotFoundException ex) {
            output += "Unable to open file: '" +  schema.getName() + "'";                
        }
	}
	
	/**
	 *@name parseFileToCheck
	 *@return void
	 *@desc - parses target file so that it can check it against the schema
	*/
	public static void parseFileToCheck() {
		String output = "";
		String line = null;
		
		try {
			Scanner scanner = new Scanner(fileToCheck);

            while(scanner.hasNextLine()) {
            	line = scanner.nextLine();
            	fileCharacterChecks(line);
            }   

            scanner.close();         
        }
        catch(FileNotFoundException ex) {
            output += "Unable to open file: '" +  fileToCheck.getName() + "'";                
        }
	}
	
	/**
	 *@name schemaCharacterChecks
	 *@param String line
	 *@return void
	 *@desc - handles putting json data into corresponding map elements for schema
	*/
	private static void schemaCharacterChecks(String line) {
		if(line.contains("},")) {
			map.put(id, tempMap);
			id = null;
			tempMap = new HashMap<String, String>();
		}
		else if(line.contains("{") || line.contains("}") || line.contains("properties")) {
			return;
		}
		else {
			String[] lines = line.split(":");
			if(id == null) {
				id = lines[0].replace("\"", "");
			}
			else {
				try {
				lines[0] = lines[0].replaceAll("\"", "").replaceAll(",", "").replaceAll("/s", "");
				lines[1] = lines[1].replaceAll("\"", "").replaceAll(",", "").replaceAll("/s", "");
				tempMap.put(lines[0], lines[1]);
				} catch(ArrayIndexOutOfBoundsException e) {
					//System.out.print(lines[0]);
				}
			}
		}
	}
	
	/**
	 *@name fileCharacterChecks
	 *@param String line the current line in the target file
	 *@return void
	 *@desc - handles putting json data into corresponding map elements for target file
	*/
	private static void fileCharacterChecks(String line) {
		if(line.equals("{") || line.equals("}"))  
			return;
		else {
			String[] lines = line.split(":");
			lines[0] = lines[0].replaceAll("\"", "").replaceAll(",", "").replaceAll(" ", "");
			lines[1] = lines[1].replaceAll("\"", "").replaceAll(",", "").replaceAll(" ", "");
			fileMap.put(lines[0], lines[1]);
		}
	}
	
	/**
	 *@name fileCharacterChecks
	 *@return String
	 *@desc - handles checking if the file matches the json schema
	*/
	public static String validateFileToSchema() {
		String result = "";
		boolean dataFound = false;
		for (Entry<String, Map<String, String>> entry : map.entrySet()) {
			dataFound = true;
		   //System.out.println(entry.getKey());
			for (Entry<String, String> entry2 : entry.getValue().entrySet()) {
			    //System.out.println(entry2.getKey() + ":" + entry2.getValue());
			     result += valueChecks(entry.getKey(), entry2.getKey(), entry2.getValue());
			}
		}
		if(!dataFound)
			return "Error: No Data Was Found In File";
		return result;
	}
	
	/**
	 *@name fileCharacterChecks
	 *@param String id - id of the json entry
	 *       String valueID - id of the specific header in the json object
	 *       String value - value corresponding to valueID
	 *@return String - message for later error handling
	 *@desc - checks that the values in target file line up to what the schema says
	*/
	private static String valueChecks(String id, String valueID, String value) { 
		String stringValue = "";
		String result = "";
		int intValue = -1;
		try {
			if(valueID.contains("type")) {
				switch(value) {
				case " integer": intValue = Integer.parseInt(fileMap.get(id.replaceAll(" ", "")));break;
				case " string": stringValue = fileMap.get(id.replaceAll(" ", ""));break;
				default:  break;
				}
			}
			else {
					if(!(fileMap.get(id.replaceAll(" ", ""))).matches(value.replaceAll(" ", "")))
						result = "Error: Values did not match json schema regex patterns\n";
			}
		}
		catch (NumberFormatException num) {
			result = "Error: Was meant to find a number and didnt\n";
		}
		return result;
	}
}
