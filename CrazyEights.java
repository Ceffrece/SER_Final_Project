import java.util.ArrayList;

public class CrazyEights {
	public static boolean isCardPlayable(Card card, Card faceUp){
		if(faceUp.getFace().equals(card.getFace()) || faceUp.getSuit().equals(card.getSuit())){
			return true;
		}
		if(card.getFace().equals("Eight")){
			return true;
		}
		else{
			return false;
		}
	}
	public static void main(String[] args) {
		System.out.println("Welcome to Crazy Eights!!");
		ArrayList<Card> player1Hand = new ArrayList<Card>();
		ArrayList<Card> player2Hand = new ArrayList<Card>();
		System.out.println("Game Start");
		DeckOfCards deck = new DeckOfCards();
		deck.shuffle();
		for(int count = 0; count < 5; count++){
			player1Hand.add(deck.dealCard());
			player2Hand.add(deck.dealCard());
		}
		while(!(player1Hand.isEmpty()) || !(player2Hand.isEmpty())){
			Card faceUp = deck.dealCard();
			boolean playedCard = false;
			for(Card card: player1Hand){
				if(isCardPlayable(card,faceUp)){
					//displayHand();
					playedCard = true;
				}
			}
			if(playedCard){
				
			}
		}
	}
}
