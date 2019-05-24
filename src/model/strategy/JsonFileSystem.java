package model.strategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class JsonFileSystem implements IFileSystemStrategy {
	private String path;
	private String info;
	
	public JsonFileSystem() {
		
	}
	
	public TextRepresentation convertStringtoTextRepresentation() {
		TextRepresentation textRepresentation = new TextRepresentation();
		String s = this.info;
		
		for(int i = 0; i<s.length(); i++) {
			Character character = new Character(s.charAt(i), "000000");
			textRepresentation.addCharacters(character);
		}
		
		return textRepresentation;
	} 
	
	public TextRepresentation loadFile() {
		JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader("employees.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
             
            //Iterate over employee array
            employeeList.forEach( emp -> parseFileObject( (JSONArray) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return convertStringtoTextRepresentation();
	}
	
	private void parseFileObject(JSONArray employee) {
		employee.forEach( emp -> this.info += (String) emp);
	}
	
	public void saveFile(TextRepresentation pText) {
		ArrayList<Character> characters = pText.getCharacters();
		JSONArray paragraphs = new JSONArray();
		JSONObject paragraphDetails = new JSONObject();
		String paragraph = "";
		int paragraphCount = 1;
		
		for(int i = 0; i<characters.size(); i++) {
			char currChar = characters.get(i).getCharacter();
			paragraph += currChar;
			
			if(currChar == '.') {
				if (i == characters.size()-1) {
					paragraphDetails.put("Paragraph " + paragraphCount, paragraph);
					paragraphs.add(paragraphDetails);
				} else if (characters.get(i+1).getCharacter() == '\n') {
					paragraphDetails.put("Paragraph " + paragraphCount, paragraph);
					paragraphs.add(paragraphDetails);
					paragraphDetails = new JSONObject();
					paragraphCount += 1;
					i++;
				}
			}
		}
		
		try (FileWriter file = new FileWriter(this.path)) {
			 
            file.write(paragraphs.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void setFile(String pPath) {
		this.path = pPath;
		File file = new File(pPath);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
}
