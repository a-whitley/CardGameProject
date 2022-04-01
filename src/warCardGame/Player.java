 package warCardGame;

import java.util.LinkedList;
import java.util.List;

public class Player {
	//The player object will be made up of a list of cards (hand), a player name, and a score starting at 0
	private List<Card> hand = new LinkedList<>();
	private String name;
	private int score = 0;
	
	//Getters and setters (only setter I need is for the name so the user can enter it in themselves)
	public List<Card> getHand() {
		return hand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	
	//Draws from the deck and adds the card to the hand
	public void draw(Deck deck) {
	    getHand().add(deck.draw());
	}
	
	//Returns a string of the player's hand
	public String describe() {
		StringBuilder desc = new StringBuilder();
		desc.append(name.toUpperCase()).append("'S HAND: ").append("\n");
		for (Card card : getHand()) {
			desc.append(card.describe() + "; ").append("\n");
		}
		return desc.toString();
	}
	
	//returns the first card from the hand and removes it from the hand.
	public Card flip() {
		return hand.remove(0);
	}
	
	//Adds 1 to the score
	public void incrementScore() {
		score = getScore() + 1;
	}
}
