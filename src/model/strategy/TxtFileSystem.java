package Model.strategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TxtFileSystem implements IFileSystemStrategy{
	
	private String path;
	
	public TxtFileSystem() {
		
	}
	
	public TextRepresentation loadFile() {
		TextRepresentation textRepresentation = new TextRepresentation();
	    int i;
	    try {
	    	FileReader fr = new FileReader(path); 
			while ((i=fr.read()) != -1) {
				char currChar = (char) i;
				Character character = new Character(currChar, "000000");
				textRepresentation.addCharacters(character);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return textRepresentation;
	};
	
	public void saveFile(TextRepresentation pText) {
		
		ArrayList<Character> characters = pText.getCharacters();
		
		try {
			
			PrintWriter out = new PrintWriter(this.path);
			
			for (int i=0; i<characters.size(); i++) {
				char currCharacter = characters.get(i).getCharacter();
				out.println(currCharacter);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	};
	
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
