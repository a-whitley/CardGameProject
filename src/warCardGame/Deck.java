package warCardGame;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("serial")
public class Deck extends LinkedList<Card> {
	
	//Lists of card names (2 - Ace) and suits which will not be changed, and which will be used to create a complete standard deck of cards
	private final List<String> names = List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace");
	private final List<String> suits = List.of("Clubs", "Diamonds", "Hearts", "Spades");
	
	//Constructs a deck by going through the list of names (2 - Ace) and making a card of that name for each of the 4 suits
	public Deck() {
		for (int cardPos = 0; cardPos < names.size(); cardPos ++) {
			int value = cardPos + 2;
			String name = names.get(cardPos);
			  
			for (String suit : suits) {
				add(new Card(name, suit, value));
			}
		}
	}
	  
	//Shuffles the deck
	public void shuffle() {
		Collections.shuffle(this);
	}
	//Draws the first card in the deck
	public Card draw() {
		return remove(0);
	}
}