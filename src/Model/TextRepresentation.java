/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Todo
 * - get as rich text should return a valid representation for visualization
 * ... with colors and bold
 * @author Charlie
 */
public class TextRepresentation {
    ArrayList<CharacterRepresentation> characters;

    public TextRepresentation() {
        characters = new ArrayList<CharacterRepresentation>();
    }
    
    public String getAsText(){
        String res = "";
        for (int i = 0; i < characters.size(); i++) {
            res += characters.get(i).getText();
        }
        return res;
    }
    
    public String GetAsRichText(){
        return getAsText();
    }
    
    
    public void addText(String newText,Color color){
        if(color == null) color = new ColorHTML("#000000");
        CharacterRepresentation currentCharacter;
        for (int i = 0; i < newText.length(); i++) {
            //System.out.print(newText.charAt(i));
            currentCharacter = new CharacterRepresentation(newText.charAt(i),new ColorHTML("#000000"),false);
            characters.add(currentCharacter);
	}
    }
    
     public void addAtIndexText(int index, String newText,Color color){
        if(color == null) color = new ColorHTML("#000000");
        CharacterRepresentation currentCharacter;
        for (int i = 0; i < newText.length(); i++) {
            //System.out.print(newText.charAt(i));
            currentCharacter = new CharacterRepresentation(newText.charAt(i),new ColorHTML("#000000"),false);
            characters.add(index + i,currentCharacter);
	}
    }
    
    public void removeChar(int index){
        if(index < characters.size() && index >= 0)
        characters.remove(index);
    }
    
    public List<CharacterRepresentation> removePiece(int initialIdex, int finalIndex){
        if(initialIdex < 0) initialIdex = 0;
        if(finalIndex >= characters.size())  finalIndex = characters.size()-1;
        
        List removedChars = characters.subList(initialIdex, finalIndex);
        characters.removeAll(removedChars);
        
        return removedChars;
    }

    public ArrayList<CharacterRepresentation> getCharacters() {
        return characters;
    }
    
    
    
}
