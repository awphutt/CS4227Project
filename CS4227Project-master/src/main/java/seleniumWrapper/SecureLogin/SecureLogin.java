package seleniumWrapper.SecureLogin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SecureLogin {

	private static String filePath = "./logins.txt";
	private static HashMap<String,List<String>> loginsHolder;
	
	/**
	 * @desc Reads in all the logins from txt file into a HashMap, encrypts them too
	 * @throws FileNotFoundException
	 */
	public static void read() throws FileNotFoundException {
		File file = new File(filePath);
		loginsHolder= new HashMap();
		String username,password,secret,id;
		String line;
		String[] lineSplit;
		Scanner in = new Scanner(file);
		List<String> temp ;
		
		while(in.hasNext()) {
			temp = new ArrayList<>();
			line = in.nextLine();
			lineSplit = line.split(",");
			secret = lineSplit[2];
			//Encrypt the details
			username = EncryptionDecryption.encrypt(lineSplit[0],secret);
			password = EncryptionDecryption.encrypt(lineSplit[1],secret);
			id = lineSplit[3];
			temp.add(username);
			temp.add(password);
			temp.add(secret);
			loginsHolder.put(id, temp);
		}
		in.close();
		//Empty contents of variables for security
		lineSplit = null;
		line = null;
		username = null;
		password = null;
	
	}
	
	/**
	 * @desc Returns a specified login and decrypts it
	 * @param key
	 * @return
	 */
	public static List<String> getLogin(String key){
		List<String> temp = loginsHolder.get(key);
		String username,password;
		username = EncryptionDecryption.decrypt(temp.get(0), temp.get(2));
		password = EncryptionDecryption.decrypt(temp.get(1), temp.get(2));
		temp.clear();
		temp.add(username);
		temp.add(password);
		return temp;
	}
	
	

}
