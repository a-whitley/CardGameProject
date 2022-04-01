package warCardGame;

import java.util.Scanner;

public class App {
	//the main method which calls the "run" method, and is where the program begins
	public static void main(String[] args) {
		new App().run();
	}
	
	//The method containing everything needed to run the game
	private void run() {
		//The deck and both players are instantiated
		Deck deck = new Deck();
		Player player1 = new Player();
		Player player2 = new Player();
		
		//The user enters two names to assign the name for player 1 and 2
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Player 1 Enter Name (no spaces): ");
			player1.setName(scanner.next());
			System.out.println("Player 2 Enter Name (no spaces): ");
			player2.setName(scanner.next());
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
		
		//The deck gets shuffled
		deck.shuffle();
		
		//The players are dealt their cards
		deal(deck, player1, player2);
		
		//Prints the hand each player starts out with
		System.out.println(player1.describe());
		System.out.println(player2.describe());
		
		//The game is played
		play(player1, player2);
		
		//The winner is announced, or a tie is declared.
		declareWinner(player1, player2);
		
	}

	//Takes the top card from the deck and gives it to player 1, then gives the next top card to player 2, and so on until the deck is empty and
	//each player has half of the deck in their hand
	private void deal(Deck deck, Player player1, Player player2) {
		int size = deck.size();
		for (int index = 0; index < size; index++) {
			if (index % 2 == 0) {
		    player1.draw(deck);
		    } else {
		    player2.draw(deck);
		    }
		}
	}
	
	//Sets the game to end after the players run out of cards. Flips the top card from each players hand, checks to see which card has highest
	//value, then gives 1 point to the player with the bigger value. It does this until it has checked each card from the hand
	private void play(Player player1, Player player2) {
		int turns = player1.getHand().size();
		
		for (int round = 0; round < turns; round++) {
			Card card1 = player1.flip();
			Card card2 = player2.flip();
			if (card1.getValue() > card2.getValue()) {
				player1.incrementScore();
			} else if (card1.getValue() < card2.getValue()) {
				player2.incrementScore();
			}
		}
	}
	
	//Checks which player's score is highest and prints out the winner and loser along with their scores. If the points are equal, 
	//it declares the game as a draw and shows the final scores.
	private void declareWinner(Player player1, Player player2) {
		if (player1.getScore() > player2.getScore()) {
			printWinner(player1);
			printLoser(player2);
		} else if (player1.getScore() < player2.getScore()) {
			printWinner(player2);
			printLoser(player1);
		} else {
			System.out.println("The game has ended in a draw. Final score: " + player1.getScore() + " & " + player2.getScore());
		}
	}
	
	//Prints a message for the winning player
	private void printWinner(Player player) {
		System.out.println(player.getName() + " wins! Final score: " + player.getScore());
	}
	//Prints a message for the losing player
	private void printLoser(Player player) {
		System.out.println(player.getName() + " loses. Final score: " + player.getScore());
	}
}