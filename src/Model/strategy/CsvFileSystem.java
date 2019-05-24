package Model.strategy;

import Model.TextRepresentation;
import Model.CharacterRepresentation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CsvFileSystem implements IFileSystemStrategy{
	private String path;
	
	public CsvFileSystem() {
		
	}
	
	@Override
	public TextRepresentation loadFile() {
		TextRepresentation textRepresentation = new TextRepresentation();
	    int i;
	    try {
	    	FileReader fr = new FileReader(path); 
			while ((i=fr.read()) != -1) {
				char currChar = (char) i;
				System.out.println("currChar " + currChar);
				if (currChar == ',') {
					textRepresentation.addText(Character.toString(' '), null);
				} else {
					textRepresentation.addText(Character.toString(currChar), null);
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return textRepresentation;
	};
	
	@Override
	public void saveFile(TextRepresentation pText) {
		
		ArrayList<CharacterRepresentation> characters = pText.getCharacters();
		
		try {
			
			File file = new File(this.path);
			file.getParentFile().mkdirs();
			
			PrintWriter out = new PrintWriter(file);
			
			for (int i=0; i<characters.size(); i++) {
				char currCharacter = characters.get(i).getChar();
				if(currCharacter == ' ') {
					out.print(',');
				} else {
					out.print(currCharacter);
				}
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	};
	
	@Override
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
