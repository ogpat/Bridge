import java.util.ArrayList;
import java.util.Scanner;

public class Bridge {

	static Scanner s = new Scanner(System.in);

	// dealing
	static ArrayList<Card> player1 = new ArrayList();
	static ArrayList<Card> player2 = new ArrayList();
	static ArrayList<Card> player3 = new ArrayList();
	static ArrayList<Card> player4 = new ArrayList();

	static int score1 = 0;
	static int score2 = 0;	

	// generate 52 cards in 2 for loops
	// add those cards to the deck
	static ArrayList<Card> deck = new ArrayList();

	public static void generate() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 2; j <= 14; j++) {
				deck.add(new Card(i, j));
			}
		}
	}

	// e is an array list of cards
	public static String showCards(ArrayList<Card> e) {
		String cards = "";
		for (int i = 0; i < e.size(); i++) {

			cards += " (" + i + ")" + e.get(i).toString();
		}

		return cards;
	}

	// create a winner method
	public static Card winner(ArrayList<Card> pile) {

		int firstSuit = pile.get(0).suit;
		Card max = pile.get(0);
		// loop through the cards in the middle
		// make the first card max
		for (Card c : pile)
			if (c.suit == firstSuit && max.value < c.value)
				max = c;
		return max;
		
	}

	public static String points(Card max) {
		int p1 = 0;
		int p2 = 0;
		int p3 = 0;
		int p4 = 0;
		/*
		 * The person who gets the points is the one who won that round Call the
		 * method on the winning card
		 * 
		 * if that card belongs to the Hand (ArrayList) if p1,p2,p3, or p4
		 * contained this then then that user wins from the pile in the middle
		 */
		if (player1.contains(max))
			p1 += 1;
		if (player2.contains(max))
			p2 += 1;
		if (player3.contains(max))
			p3 += 1;
		else
			p4 += 1;
		// who has highest score?
		int winningPlayer = p1;
		if (p2 > winningPlayer)
			winningPlayer = p2;
		if (p3 > winningPlayer)
			winningPlayer = p3;
		else
			winningPlayer = p4;

		return "The winner card is" + winningPlayer;
	}

	// this takes care of dealing and shuffling.
	// every player has 13 cards now
	public static void deal() {
		for (int i = 0; i < 13; i++) {
			Card randomCard = deck.remove(((int) (Math.random() * deck.size())));
			
			player1.add(randomCard);
			
			randomCard = deck.remove(((int) (Math.random() * deck.size())));
			player2.add(randomCard);
			randomCard = deck.remove(((int) (Math.random() * deck.size())));
			player3.add(randomCard);
			randomCard = deck.remove(((int) (Math.random() * deck.size())));
			player4.add(randomCard);
		}
	}

	// making suits
	// playYourCard

	public static void playCard(ArrayList<Card> player, ArrayList<Card> base) {
		if(base.isEmpty()){
			base.add(player.remove(player.indexOf(winner(player))));
		}
		
		else {
		
		ArrayList<Card> temp = new ArrayList<Card>();
		// find card
		Card tempC = new Card();
		int min = 14;
		for (int i = 0; i < player.size(); i++) {
			if (player.get(i).getSuit() == base.get(0).getSuit()) {
				temp.add(player.get(i));
			}

			if (player.get(i).getValue() < min) {
				min = player.get(i).getValue();
				tempC = player.get(i);
			}
			// suit is first
			// 4 of diamonds is Card(2,4) 4 = suit = diamonds
		}
		int max = 0;
		// make a temp card
		if (!temp.isEmpty()) {
			for (int j = 0; j < temp.size(); j++) {
				// look for max value
				if (temp.get(j).getValue() > max) {
					max = temp.get(j).getValue();
					tempC = temp.get(j);
				}

			}
			// ADD to the middle what you are removing
			base.add(player.remove(player.indexOf(tempC)));

		} else
			// ADD to the middle what you are removing
			base.add(player.remove(player.indexOf(tempC)));
		// play card - make a new array list for the center here all cards are
		// make an arraylist that you can add cards that represents the middle
		// (cards played)

		// ArrayList<Card> Middle = new ArrayList<Card>()
	
		// remove card
		}
	}

	public static void main(String[] args) {
		
	
		// create a giant while loop so that the game can be continuous
		// array list has a clear method to clear the middle
		// boolean to tell you if the game
		// method that returns a boolean to check if a player's hand is empty

		System.out.println("Welcome to the game of Bridge!");
		System.out.println("You have been dealt the following Cards: ");
		ArrayList<Card> Middle = new ArrayList<Card>();
		generate();
		deal();
		// try to do score
		int winnerIndex = 0;
		for (int i = 0; i < 13; i++) {
			// while loop would start here**
			// because it is a a string use Syso
			int x = winnerIndex;
			System.out.println("Player " + winnerIndex + " is starting the round.");
						for(int j = 0 ; j < 4; j++) {
							if (x == 0) {
								System.out.println(showCards(player1));
								// tell to enter card
								System.out.println("Your Turn, Please play a card");
								// save the card they want to play

								int k = s.nextInt();
								Middle.add(player1.remove(k));
								System.out.println(showCards(player1));							}
							if (x == 1) 
							playCard(player2, Middle);
							
							if (x == 2) 
								playCard(player3, Middle);

							if (x == 3) {
								playCard(player4, Middle);
								x = 0;
							}
							else
								x++;
			
						}

////
////			System.out.println(showCards(player1));
////			// tell to enter card
////			System.out.println("Your Turn, Please play a card");
////			// save the card they want to play
////
////			int k = s.nextInt();
////			Middle.add(player1.remove(k));
////			System.out.println(showCards(player1));
//			// cpu playeer2 turn
//			// Display Player 2's Hand
//
//			playCard(player2, Middle);
//			playCard(player3, Middle);
//			playCard(player4, Middle);
			// show the middle
			System.out.println("In the Middle there is: ");
			System.out.println(showCards(Middle));

			// Determine who wins the round
			Card winner = winner(Middle);
			System.out.println("The winning card is: " + winner);

			// find the winner
			winnerIndex = Middle.indexOf(winner);
			System.out.println("****winner is: " + winnerIndex + "****");
			
			//scoring
			
			if(winner==Middle.get(0) || winner==Middle.get(2))
				score1++;
			else
				score2++;


			System.out.println("Scores: player team has " + score1 + " point(s)" + " , the other team has " + score2 + "point(s)" + "\n");
			Middle.clear();
		}
	}
}