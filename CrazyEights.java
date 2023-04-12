import java.util.ArrayList;

public class CrazyEights {
	public static void main(String[] args) {
		System.out.println("Welcome to Crazy Eights!!");
		ArrayList<Card> playerHand = new ArrayList<Card>();
		System.out.println("Game Start");
		DeckOfCards deck = new DeckOfCards();
		deck.shuffle();
		for(int count = 0; count < 5; count++){
			playerHand.add(deck.dealCard());
		}
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
