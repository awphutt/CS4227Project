package seleniumWrapper.fileChecker;

import java.io.File;

import seleniumWrapper.fileChecker.Files.JsonParser;

public class JsonSchemaValidation implements FileFilter {

	private File jsonSchema;
	
	/**
	 *@name JsonSchemaValidation
	 *@param File jsonSchema - this is the schema the user wants to check against the target file
	 *@return None
	 *@desc - Validates a json file against a schema
	*/
	public JsonSchemaValidation(File jsonSchema) {
		this.jsonSchema = jsonSchema;
	}
	
	@Override
	public String validationCheck(File target) {
		JsonParser.parseFiles(jsonSchema, target);
		String result = JsonParser.validateFileToSchema();
		if(result.matches(""))
			System.out.println("Json Check passed");
		return result;
	}
}
