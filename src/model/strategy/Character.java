package Model.strategy;

public class Character {
    private char character;
    private String color;

    public Character(char pCharacter, String pColor) {
        this.character = pCharacter;
        this.color = pColor;
    }

    public void setCharacter(char pCharacter) {
        this.character = pCharacter;
    }

    public char getCharacter() {
        return this.character;
    }

    public void setColor(String pColor) {
        this.color = pColor;
    }

    public String getColor() {
        return this.color;
    }
}
