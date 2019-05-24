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

    public String getText() {
        return Character.toString(character);
    }

    public char getChar() {
        return character;
    }

}
