package de.apt.jsonloader;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Rangel
 *
 */
public class OSMJsonImport {

	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject(readJsonFile());
		Set<String> mainKeys = jsonObject.keySet();
		for(String key : mainKeys){
			Object object = jsonObject.getJSONArray(key);
			if(object instanceof JSONArray){
				System.out.println(jsonObject.getJSONArray(key));
			} else {
				System.out.println(jsonObject.getJSONObject(key));
			}
		}
	}
	
	private static String readJsonFile(){
		String absolutePath = "D:\\Internal\\repositories\\jsonloader\\jsonloader\\src\\main\\resources\\importjson\\import060422.json";
		Path path = Paths.get(absolutePath);
		File jsonFile = path.toFile();
		
		StringBuilder st = new StringBuilder();
		try(Scanner scanner= new Scanner(jsonFile);){
			while(scanner.hasNext()){
				String currentLine = scanner.next();
				st.append(currentLine);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return st.toString();
	}
	
}
