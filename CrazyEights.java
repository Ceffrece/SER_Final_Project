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
	public static void main(String[] args) throws InterruptedException{
		// display start game 
		//Displays the welcome message:
		System.out.println("              (           )    *                    )          (               )     )       (              )        (     ____ ");
		System.out.println(" (  (         )\\ )  (  ( /(  (  `          *   ) ( /(      (   )\\ )   (     ( /(  ( /(       )\\ ) (      ( /(   *   ))\\ ) |   / ");
		System.out.println(" )\\))(   '(  (()/(  )\\ )\\()) )\\))(  (    ` )  /( )\\())     )\\ (()/(   )\\    )\\()) )\\())  (  (()/( )\\ )   )\\())` )  /(()/( |  /  ");
		System.out.println("((_)()\\ ) )\\  /(_)|((_|(_)\\ ((_)()\\ )\\    ( )(_)|(_)\\    (((_) /(_)|(((_)( ((_)\\ ((_)\\   )\\  /(_)|()/(  ((_)\\  ( )(_))(_))| /   ");
		System.out.println("_(())\\_)(|(_)(_)) )\\___ ((_)(_()((_|(_)  (_(_())  ((_)   )\\___(_))  )\\ _ )\\ _((_)_ ((_) ((_)(_))  /(_))_ _((_)(_(_()|_))  |/    ");
		System.out.println("\\ \\((_)/ / __| | ((/ __/ _ \\|  \\/  | __| |_   _| / _ \\  ((/ __| _ \\ (_)_\\(_)_  /\\ \\ / / | __|_ _|(_)) __| || ||_   _/ __|(      ");
		System.out.println(" \\ \\/\\/ /| _|| |__| (_| (_) | |\\/| | _|    | |  | (_) |  | (__|   /  / _ \\  / /  \\ V /  | _| | |   | (_ | __ |  | | \\__ \\)\\     ");
		System.out.println("  \\_/\\_/ |___|____|\\___\\___/|_|  |_|___|   |_|   \\___/    \\___|_|_\\ /_/ \\_\\/___|  |_|   |___|___|   \\___|_||_|  |_| |___((_)    ");
		System.out.println();
		Thread.sleep(2000);
		//Displays Team Name
		System.out.println("   ____   __   __       ____    ____        _       _____   __   __       ____   U  ___ u  ____  U _____ u   ____     ____     ");
		System.out.println("U | __\")u \\ \\ / /    U /\"___|U |  _\"\\ u U  /\"\\  u  |\"_  /u  \\ \\ / /    U /\"___|   \\/\"_ \\/ |  _\"\\ \\| ___\"|/U |  _\"\\ u / __\"| u  ");
		System.out.println(" \\|  _ \\/  \\ V /     \\| | u   \\| |_) |/  \\/ _ \\/   U / //    \\ V /     \\| | u     | | | |/| | | | |  _|\"   \\| |_) |/<\\___ \\/   ");
		System.out.println("  | |_) | U_|\"|_u     | |/__   |  _ <    / ___ \\   \\/ /_    U_|\"|_u     | |/__.-,_| |_| |U| |_| |\\| |___    |  _ <   u___) |   ");
		System.out.println("  |____/    |_|        \\____|  |_| \\_\\  /_/   \\_\\  /____|     |_|        \\____|\\_)-\\___/  |____/ u|_____|   |_| \\_\\  |____/>>  ");
		System.out.println(" _|| \\\\_.-,//|(_      _// \\\\   //   \\\\_  \\\\    >>  _//<<,-.-,//|(_      _// \\\\      \\\\     |||_   <<   >>   //   \\\\_  )(  (__) ");
		System.out.println("(__) (__)\\_) (__)    (__)(__) (__)  (__)(__)  (__)(__) (_/ \\_) (__)    (__)(__)    (__)   (__)_) (__) (__) (__)  (__)(__)      ");
		System.out.println();
		
		Thread.sleep(2000);
		//Displays the press enter to start
		System.out.println(" _______ _______ _______  _______ _______    _______ _      ________________ _______   ________________    _______________________ ________________");
		System.out.println("(  ____ |  ____ |  ____ \\(  ____ (  ____ \\  (  ____ ( (    /\\__   __(  ____ (  ____ )  \\__   __(  ___  )  (  ____ \\__   __(  ___  |  ____ )__   __/");
		System.out.println("| (    )| (    )| (    \\/| (    \\/ (    \\/  | (    \\/  \\  ( |  ) (  | (    \\/ (    )|     ) (  | (   ) |  | (    \\/  ) (  | (   ) | (    )|  ) (   ");
		System.out.println("| (____)| (____)| (__    | (_____| (_____   | (__   |   \\ | |  | |  | (__   | (____)|     | |  | |   | |  | (_____   | |  | (___) | (____)|  | |   ");
		System.out.println("|  _____)     __)  __)   (_____  |_____  )  |  __)  | (\\ \\) |  | |  |  __)  |     __)     | |  | |   | |  (_____  )  | |  |  ___  |     __)  | |   ");
		System.out.println("| (     | (\\ (  | (            ) |     ) |  | (     | | \\   |  | |  | (     | (\\ (        | |  | |   | |        ) |  | |  | (   ) | (\\ (     | |   ");
		System.out.println("| )     | ) \\ \\_| (____/\\/\\____) /\\____) |  | (____/\\ )  \\  |  | |  | (____/\\ ) \\ \\__     | |  | (___) |  /\\____) |  | |  | )   ( | ) \\ \\__  | |   ");
		System.out.println("|/      |/   \\__(_______/\\_______)_______)  (_______//    )_)  )_(  (_______//   \\__/     )_(  (_______)  \\_______)  )_(  |/     \\|/   \\__/  )_(   ");
		System.out.println();
		//Initializes hands as empty ArrayLists
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

		//Player Names
		Scanner nameIn = new Scanner(System.in);
		System.out.println("Input Player 1's Name: ");
		String player1 = nameIn.nextLine();
		System.out.println("Input Player 2's Name: ");
		String player2 = nameIn.nextLine();

		//Game loop that makes the game run
		while(!(player1Hand.isEmpty()) && !(player2Hand.isEmpty())){
			boolean playedCard1 = false;
			boolean playedCard2 = false;

			Thread.sleep(1000);//Sleep function for some time in between players to not make everything seem instant
			//Player 1 Turn
			System.out.println(player1 + "'s' Turn!!");
			for(Card card: player1Hand){
				if(isCardPlayable(card,faceUp)){
					playedCard1 = true;
				}
			}
			if(playedCard1){
				System.out.println("Face Up Card: ");
				displayCard(faceUp);
				CrazyEights.displayHand(player1Hand);
				faceUp = playCard(player1Hand, faceUp);
			}
			else{
				System.out.println("You cannot play a card. Drawing a card.");
				player1Hand.add(deck.dealCard());
			}
			Thread.sleep(1000);

			//Player 2 Turn
			System.out.println(player2 + "'s' Turn!!");
			for(Card card: player2Hand){
				if(isCardPlayable(card,faceUp)){
					playedCard2 = true;
				}
			}
			if(playedCard2){
				System.out.println("Face Up Card: ");
				displayCard(faceUp);
				CrazyEights.displayHand(player2Hand);
				faceUp = playCard(player2Hand, faceUp);
			}
			else{
				System.out.println("You cannot play a card. Drawing a card.");
				player2Hand.add(deck.dealCard());
			}
		}

		if(player1Hand.isEmpty()){
			System.out.println("Player 1 Wins!");
		}
		else if(player2Hand.isEmpty()){
			System.out.println("Player 2 Wins!");
		}
	}
// GETS USER INPUT AND REMOVES HAND
	public static Card playCard(ArrayList<Card> playerHand, Card faceUp) {
		int removeIndex;
		Card playedCard;
		while(true){
			System.out.println("Please pick a card in your hand to play");
			Scanner scan = new Scanner(System.in);
			removeIndex = scan.nextInt();
			playedCard = playerHand.get(removeIndex - 1);
			if(isCardPlayable(playedCard, faceUp)){
				break;
			}
			else{
				System.out.println("That card is not legally playable. Please choose another.");
			}
		}
		
		playerHand.remove(removeIndex - 1);
		if(playedCard.getFace().equals("8")){
			System.out.println("CRAZY EIGHT!!! PICK A SUIT!!!!");
			System.out.println("1. Hearts");
			System.out.println("2. Diamonds");
			System.out.println("3. Clubs");
			System.out.println("4. Spades");
			Scanner suitChange = new Scanner(System.in);
			int suitChangeNum = suitChange.nextInt();
			if(suitChangeNum == 1){
				playedCard.setSuit("Hearts");
			}
			else if(suitChangeNum == 2){
				playedCard.setSuit("Diamonds");
			}
			else if(suitChangeNum == 3){
				playedCard.setSuit("Clubs");
			}
			else if(suitChangeNum == 4){
				playedCard.setSuit("Spades");
			}
			else{
				System.out.println("Not a valid option");
			}
		}
		return playedCard;
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
		displayCard += "|  " + card.getSuitIcon() + "  | ";
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
    		displayHand += "|  " + item.getSuitIcon() + "  | ";
		}
		displayHand += "\n";
		for(Card item: playerHand){
    		displayHand += "|     | ";
		}
		displayHand += "\n";
		for(Card item: playerHand){
    		displayHand += "+-----+ ";
		}
		displayHand += "\n";
		int cardNum = 1;
		for(Card item: playerHand){
			displayHand += cardNum;
			displayHand += "       ";
			cardNum++;
		}
		System.out.println(displayHand);
	}
}
