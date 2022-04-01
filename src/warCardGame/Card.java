package warCardGame;

public class Card {
	
	private String name;
	private int value;
	private String suit;
	
	public Card(String name, String suit, int value) {
		this.name = name;
		this.suit = suit;
		this.value = value;
	}
	
	//Getters. (Setters unnecessary since name, suit, and value are always from the same lists.
	public String getName() {
		return name;
	}
	public int getValue() {
		return value;
	}
	public String getSuit() {
		return suit;
	}
	
	//Describes the card
	public String describe() {
		return name + "	of " + suit;
	}
}
