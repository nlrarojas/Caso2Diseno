/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Charlie
 */
public class CharacterRepresentation {
    char character;
    Color color;
    boolean bold;

    public CharacterRepresentation(char character, Color color, boolean bold) {
        this.character = character;
        this.color = color;
        this.bold = bold;
    }
    
    public String getText(){
        return Character.toString(character);
    }
    
    public char getChar(){
        return character;
    }
    
    public Color getColor(){
       return color;
    }
    
}
