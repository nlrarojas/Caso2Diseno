package Model.strategy;

import java.util.ArrayList;

public class TextRepresentation {
	private ArrayList<Character> Characters;
	
	public TextRepresentation(){
		this.Characters = new ArrayList<Character>();
	}
	
	public void addCharacters(Character pCharacter) {
		Characters.add(pCharacter);
	}
	
	public ArrayList<Character> getCharacters() {
		return this.Characters;
	}
}
