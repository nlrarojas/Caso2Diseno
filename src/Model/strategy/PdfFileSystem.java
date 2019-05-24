package Model.strategy;

import Model.CharacterRepresentation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import Model.TextRepresentation;

public class PdfFileSystem implements IFileSystemStrategy {
	private String path;
	
	public PdfFileSystem() {
		
	}
	
	@Override
	public TextRepresentation loadFile() {
		return null;
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
				System.out.println("currCharacter " + currCharacter);
				out.print(currCharacter);				
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
