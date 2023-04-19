import java.util.ArrayList;
import java.util.Scanner;

public class CrazyEights {

	// Checks if the card is playable 
	public static boolean isCardPlayable(Card card, Card faceUp){
		if(faceUp.getFace().equals(card.getFace()) || faceUp.getSuit().equals(card.getSuit())){
			return true;
		}
		if(card.getFace().equals("8")){
			return true;
		}
		else{
			return false;
		}
	}
	public static void main(String[] args) {
		// display start game 
		System.out.println("Welcome to Crazy Eights!!");
		ArrayList<Card> player1Hand = new ArrayList<Card>();
		ArrayList<Card> player2Hand = new ArrayList<Card>();

		System.out.println("Game Start");
		//	calls DeckOfCards function
		DeckOfCards deck = new DeckOfCards();
		deck.shuffle();
		//Deals 5 cards to each player 
		for(int count = 0; count < 5; count++){
			player1Hand.add(deck.dealCard());
			player2Hand.add(deck.dealCard());
		}
		//Current faceUp card 
		Card faceUp = deck.dealCard();

		//Game loop that makes the game run
		while(!(player1Hand.isEmpty()) || !(player2Hand.isEmpty())){
			boolean playedCard1 = false;
			boolean playedCard2 = false;

			//Player 1 Turn
			for(Card card: player1Hand){
				if(isCardPlayable(card,faceUp)){
					playedCard1 = true;
				}
			}
			if(playedCard1){
				System.out.println("Face Up Card: ");
				displayCard(faceUp);
				CrazyEights.displayHand(player1Hand);
				playCard(player1Hand);
			}
			else{
				System.out.println("You cannot play a card. Drawing a card.");
				player1Hand.add(deck.dealCard());
			}

			//Player 2 Turn
			for(Card card: player2Hand){
				if(isCardPlayable(card,faceUp)){
					playedCard2 = true;
				}
			}
			if(playedCard2){
				System.out.println("Face Up Card: ");
				displayCard(faceUp);
				CrazyEights.displayHand(player2Hand);
				playCard(player2Hand);
			}
		}
	}
// GETS USER INPUT AND REMOVES HAND
	public static void playCard(ArrayList<Card> playerHand) {
		System.out.println("Please pick a card in your hand to play");
		Scanner scan = new Scanner(System.in);
		int removeIndex = scan.nextInt();
		playerHand.remove(removeIndex - 1);
	}

//DISPLAY FACE UP CARD 
	public static void displayCard(Card card){
		String displayCard = "";
		displayCard += "+-----+ ";
		displayCard += "\n";
		displayCard += "|     | ";
		displayCard += "\n";
		String face = card.face;
        if (face.length() == 1) {
            face = " " + face; 
        }
		displayCard += "|  " + face + " | ";
		displayCard += "\n";
		displayCard += "|  " + card.suit.charAt(0) + "  | ";
		displayCard += "\n";
		displayCard += "|     | ";
		displayCard += "\n";
		displayCard += "+-----+ ";
		System.out.println(displayCard);
	}
// DISPLAYS PLAYERS HAND 
	public static void displayHand(ArrayList<Card> playerHand){
		//DisplayHand Function
		String displayHand = "";
		for(Card item: playerHand){
    		displayHand += "+-----+ ";
		}
		displayHand += "\n";
		for(Card item: playerHand){
    		displayHand += "|     | ";
		}
		displayHand += "\n";
		for(Card item: playerHand){
			String face = item.face;
            if (face.length() == 1) {
                face = " " + face; 
            }
            displayHand += "|  " + face + " | ";
        }
		displayHand += "\n";
		for(Card item: playerHand){
    		displayHand += "|  " + item.suit.charAt(0) + "  | ";
		}
		displayHand += "\n";
		for(Card item: playerHand){
    		displayHand += "|     | ";
		}
		displayHand += "\n";
		for(Card item: playerHand){
    		displayHand += "+-----+ ";
		}
		System.out.println(displayHand);
	}
}
