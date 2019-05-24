package Model.strategy;

import Model.CharacterRepresentation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import Model.TextRepresentation;
import java.lang.Character;

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
				textRepresentation.addText(Character.toString(currChar),null);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return textRepresentation;
	};
	
	public void saveFile(TextRepresentation pText) {
		
		ArrayList<CharacterRepresentation> characters = pText.getCharacters();
		
		try {
			
			PrintWriter out = new PrintWriter(this.path);
			
			for (int i=0; i<characters.size(); i++) {
				char currentChar = characters.get(i).getChar();
				out.println(currentChar);
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
