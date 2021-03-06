package Model.strategy;

import Model.CharacterRepresentation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import Model.TextRepresentation;

public class TxtTabSystem implements IFileSystemStrategy {

    private String path;

    public TxtTabSystem() {

    }
    
    @Override
    public TextRepresentation loadFile() {
        TextRepresentation textRepresentation = new TextRepresentation();
        int i;
        try {
            FileReader fr = new FileReader(path);
            while ((i = fr.read()) != -1) {
                char currChar = (char) i;
                if (currChar != '\t') {
                    //Character character = new Character(currChar, "000000");
                    //textRepresentation.addCharacters(character);
                    textRepresentation.addText(Character.toString(currChar), null);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textRepresentation;
    }

    @Override
    public void saveFile(TextRepresentation pText) {

        ArrayList<CharacterRepresentation> characters = pText.getCharacters();

        try {
        	File file = new File(this.path);
                file.getParentFile().mkdirs();

            PrintWriter out = new PrintWriter(file);

            for (int i = 0; i < characters.size(); i++) {
                char currCharacter = characters.get(i).getChar();
                if (i % 10 == 0) {
                    out.print('\t');
                }
                out.print(currCharacter);
            }
            
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setFile(String pPath) {
        this.path = pPath;
        File file = new File(pPath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
