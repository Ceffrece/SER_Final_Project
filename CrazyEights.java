/**
 * Charlize Aponte and Caden Effrece 
 * Date: 04/26/23
 * Description: This code runs and plays the game Crazy Eights in both single player and double player mode
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.IOException;

public class CrazyEights {

	// Checks if the card is playable 
	public static boolean isCardPlayable(Card card, Card faceUp){
		if(faceUp.getFace().equals(card.getFace()) || faceUp.getSuit().equals(card.getSuit())){
			return true;
		}
		if(card.getFace().equals("8")){ //If it is an eight, it is always playable
			return true;
		}
		else{
			return false; //if the card doesn't equal the faceUp card in the suit or number, it is not playable
		} 
	}
	public static void main(String[] args) throws InterruptedException, IOException{
		// display start game 
		//Displays the welcome message:
		System.out.println("\t\t\t              (           )    *                    )          (               )     )       (              )        (     ____ ");
		System.out.println("\t\t\t (  (         )\\ )  (  ( /(  (  `          *   ) ( /(      (   )\\ )   (     ( /(  ( /(       )\\ ) (      ( /(   *   ))\\ ) |   / ");
		System.out.println("\t\t\t )\\))(   '(  (()/(  )\\ )\\()) )\\))(  (    ` )  /( )\\())     )\\ (()/(   )\\    )\\()) )\\())  (  (()/( )\\ )   )\\())` )  /(()/( |  /  ");
		System.out.println("\t\t\t((_)()\\ ) )\\  /(_)|((_|(_)\\ ((_)()\\ )\\    ( )(_)|(_)\\    (((_) /(_)|(((_)( ((_)\\ ((_)\\   )\\  /(_)|()/(  ((_)\\  ( )(_))(_))| /   ");
		System.out.println("\t\t\t_(())\\_)(|(_)(_)) )\\___ ((_)(_()((_|(_)  (_(_())  ((_)   )\\___(_))  )\\ _ )\\ _((_)_ ((_) ((_)(_))  /(_))_ _((_)(_(_()|_))  |/    ");
		System.out.println("\t\t\t\\ \\((_)/ / __| | ((/ __/ _ \\|  \\/  | __| |_   _| / _ \\  ((/ __| _ \\ (_)_\\(_)_  /\\ \\ / / | __|_ _|(_)) __| || ||_   _/ __|(      ");
		System.out.println("\t\t\t \\ \\/\\/ /| _|| |__| (_| (_) | |\\/| | _|    | |  | (_) |  | (__|   /  / _ \\  / /  \\ V /  | _| | |   | (_ | __ |  | | \\__ \\)\\     ");
		System.out.println("\t\t\t  \\_/\\_/ |___|____|\\___\\___/|_|  |_|___|   |_|   \\___/    \\___|_|_\\ /_/ \\_\\/___|  |_|   |___|___|   \\___|_||_|  |_| |___((_)    ");
		System.out.println();
		Thread.sleep(2000);
		//Displays Team Name
		System.out.println("\t\t\t   ____   __   __       ____    ____        _       _____   __   __       ____   U  ___ u  ____  U _____ u   ____     ____     ");
		System.out.println("\t\t\tU | __\")u \\ \\ / /    U /\"___|U |  _\"\\ u U  /\"\\  u  |\"_  /u  \\ \\ / /    U /\"___|   \\/\"_ \\/ |  _\"\\ \\| ___\"|/U |  _\"\\ u / __\"| u  ");
		System.out.println("\t\t\t \\|  _ \\/  \\ V /     \\| | u   \\| |_) |/  \\/ _ \\/   U / //    \\ V /     \\| | u     | | | |/| | | | |  _|\"   \\| |_) |/<\\___ \\/   ");
		System.out.println("\t\t\t  | |_) | U_|\"|_u     | |/__   |  _ <    / ___ \\   \\/ /_    U_|\"|_u     | |/__.-,_| |_| |U| |_| |\\| |___    |  _ <   u___) |   ");
		System.out.println("\t\t\t  |____/    |_|        \\____|  |_| \\_\\  /_/   \\_\\  /____|     |_|        \\____|\\_)-\\___/  |____/ u|_____|   |_| \\_\\  |____/>>  ");
		System.out.println("\t\t\t _|| \\\\_.-,//|(_      _// \\\\   //   \\\\_  \\\\    >>  _//<<,-.-,//|(_      _// \\\\      \\\\     |||_   <<   >>   //   \\\\_  )(  (__) ");
		System.out.println("\t\t\t(__) (__)\\_) (__)    (__)(__) (__)  (__)(__)  (__)(__) (_/ \\_) (__)    (__)(__)    (__)   (__)_) (__) (__) (__)  (__)(__)      ");
		System.out.println();

		Thread.sleep(2000);//Small delay
		//Displays the press enter to start
		System.out.println("\t\t _______ _______ _______  _______ _______    _______ _      ________________ _______   ________________    _______________________ ________________");
		System.out.println("\t\t(  ____ |  ____ |  ____ \\(  ____ (  ____ \\  (  ____ ( (    /\\__   __(  ____ (  ____ )  \\__   __(  ___  )  (  ____ \\__   __(  ___  |  ____ )__   __/");
		System.out.println("\t\t| (    )| (    )| (    \\/| (    \\/ (    \\/  | (    \\/  \\  ( |  ) (  | (    \\/ (    )|     ) (  | (   ) |  | (    \\/  ) (  | (   ) | (    )|  ) (   ");
		System.out.println("\t\t| (____)| (____)| (__    | (_____| (_____   | (__   |   \\ | |  | |  | (__   | (____)|     | |  | |   | |  | (_____   | |  | (___) | (____)|  | |   ");
		System.out.println("\t\t|  _____)     __)  __)   (_____  |_____  )  |  __)  | (\\ \\) |  | |  |  __)  |     __)     | |  | |   | |  (_____  )  | |  |  ___  |     __)  | |   ");
		System.out.println("\t\t| (     | (\\ (  | (            ) |     ) |  | (     | | \\   |  | |  | (     | (\\ (        | |  | |   | |        ) |  | |  | (   ) | (\\ (     | |   ");
		System.out.println("\t\t| )     | ) \\ \\_| (____/\\/\\____) /\\____) |  | (____/\\ )  \\  |  | |  | (____/\\ ) \\ \\__     | |  | (___) |  /\\____) |  | |  | )   ( | ) \\ \\__  | |   ");
		System.out.println("\t\t|/      |/   \\__(_______/\\_______)_______)  (_______//    )_)  )_(  (_______//   \\__/     )_(  (_______)  \\_______)  )_(  |/     \\|/   \\__/  )_(   ");
		System.out.println();

		Scanner enterToStart = new Scanner(System.in);
		enterToStart.nextLine();//Dummy nextLine read to make the program stop until the user hits enter
		clearConsole();
		//Displays how to play the game 

		Thread.sleep(2000);
		System.out.println("\t\t\t\t\t           _______            _________ _______    _______  _        _______          ");
		System.out.println("\t\t\t\t\t |\\     /|(  ___  )|\\     /|  \\__   __/(  ___  )  (  ____ )( \\      (  ___  )|\\     /|");
		System.out.println("\t\t\t\t\t | )   ( || (   ) || )   ( |     ) (   | (   ) |  | (    )|| (      | (   ) |( \\   / )");
		System.out.println("\t\t\t\t\t | (___) || |   | || | _ | |     | |   | |   | |  | (____)|| |      | (___) | \\ (_) / ");
		System.out.println("\t\t\t\t\t |  ___  || |   | || |( )| |     | |   | |   | |  |  _____)| |      |  ___  |  \\   /  ");
		System.out.println("\t\t\t\t\t | (   ) || |   | || || || |     | |   | |   | |  | (      | |      | (   ) |   ) (  ");
		System.out.println("\t\t\t\t\t | )   ( || (___) || () () |     | |   | (___) |  | )      | (____/\\| )   ( |   | | ");
		System.out.println("\t\t\t\t\t |/     \\|(_______)(_______)     )_(   (_______)  |/       (_______/|/     \\|   \\_/   ");
		System.out.println();
		System.out.println();

		//Displays the instructions of the game and when the user finishes reading the instructions
		Thread.sleep(2000);//Small delay

		System.out.println("\t\t\t\t Each player is dealt 5 cards at the start of the game and then the rest of the deck is placed face down."); 
		System.out.println("\t\t\t\t The top card is flipped face up and that is the card the players start the game off of.");   
		System.out.println("\t\t\t\t Each player can only play one card per turn, and if they cannot play a card, ");
		System.out.println("\t\t\t\t they can draw from the deck up to three times before their turn is passed."); 
		System.out.println("\t\t\t\t If an eight is played, the player declares a suit and that is the next suit to be played.");
		System.out.println("\t\t\t\t The winner of the game is the first person to have no cards left in their hand before anyone else.");
		System.out.println("\t\t\t\t You are able to play this game as 1 player vs. CPU or 2 players.");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t\t\t\t\t\t\t\t\t Press Enter to Continue");

		enterToStart.nextLine();//Dummy enter readLine
		clearConsole();

		//dispplays game menu 
		Thread.sleep(2000);
		System.out.println("\t\t\t\t\t\t _______  _______  _______  _______    _______  _______  _                ");
		System.out.println("\t\t\t\t\t\t(  ____ \\(  ___  )(       )(  ____ \\  (       )(  ____ \\( (    /||\\     /|");
		System.out.println("\t\t\t\t\t\t| (    \\/| (   ) || () () || (    \\/  | () () || (    \\/|  \\  ( || )   ( |");
		System.out.println("\t\t\t\t\t\t| |      | (___) || || || || (__      | || || || (__    |   \\ | || |   | |");
		System.out.println("\t\t\t\t\t\t| | ____ |  ___  || |(_)| ||  __)     | |(_)| ||  __)   | (\\ \\) || |   | |");
		System.out.println("\t\t\t\t\t\t| | \\_  )| (   ) || |   | || (        | |   | || (      | | \\   || |   | |");
		System.out.println("\t\t\t\t\t\t| (___) || )   ( || )   ( || (____/\\  | )   ( || (____/\\| )  \\  || (___) |");
		System.out.println("\t\t\t\t\t\t(_______)|/     \\||/     \\|(_______/  |/     \\|(_______/|/    )_)(_______)");
		System.out.println();
		Thread.sleep(1000);

		System.out.println("\t\t\t\t\t ____ ____ __   ____ ___ ____    _  _ __  _  _ ____     ___  __  _  _ ____    _  _  __ ____ ____ ");
		System.out.println("\t\t\t\t\t/ ___(  __(  ) (  __/ __(_  _)  ( \\/ /  \\/ )( (  _ \\   / __)/ _\\( \\/ (  __)  ( \\/ )/  (    (  __)");
		System.out.println("\t\t\t\t\t\\___ \\) _)/ (_/\\) _( (__  )(     )  (  O ) \\/ ()   /  ( (_ /    / \\/ \\) _)   / \\/ (  O ) D () _) ");
		System.out.println("\t\t\t\t\t(____(____\\____(____\\___)(__)   (__/ \\__/\\____(__\\_)   \\___\\_/\\_\\_)(_(____)  \\_)(_/\\__(____(____)");
		System.out.println();
		Thread.sleep(1000);
		//Displays options of the game mode
		System.out.println("\t\t\t\t\t\t\t .----------------.             .----------------. ");
		System.out.println("\t\t\t\t\t\t\t| .--------------. |            | .--------------. |");
		System.out.println("\t\t\t\t\t\t\t| |     __       | |            | |    _____     | |");
		System.out.println("\t\t\t\t\t\t\t| |    /  |      | |            | |   / ___ `.   | |");
		System.out.println("\t\t\t\t\t\t\t| |    `| |      | |            | |  |_/___) |   | |");
		System.out.println("\t\t\t\t\t\t\t| |     | |      | |            | |   .'____.'   | |");
		System.out.println("\t\t\t\t\t\t\t| |    _| |_     | |            | |  / /____     | |");
		System.out.println("\t\t\t\t\t\t\t| |   |_____|    | |            | |  |_______|   | |");
		System.out.println("\t\t\t\t\t\t\t| |              | |            | |              | |");
		System.out.println("\t\t\t\t\t\t\t| '--------------' |            | '--------------' |");
		System.out.println("\t\t\t\t\t\t\t '----------------'              '----------------' ");

		//Reads the user input of the which game mode that they want
		int gameChoice = 0;
		boolean choosingGame = true;
		while(choosingGame){//Doesn't end the loop until they choose a gamemode
			//Try catches to that handle the exceptions if user inputs the wrong input
			try{
				gameChoice = enterToStart.nextInt();
				choosingGame = false;
			}
			catch(InputMismatchException ime){
				System.out.println("Not a correct input. Input an INTEGER. Try again");
				String dummy = enterToStart.nextLine();//Need this to reset the scanner and allow for a new integer input
			}
			if(gameChoice > 2){
				System.out.println("Not a valid choice. Please type '1' for Single-Player or '2' for 2-Player.");
				choosingGame = true;
			}
		}
		clearConsole();
		
		//Single Player Mode
		if(gameChoice == 1){
			//Initialize hands
			ArrayList<Card> playerHand = new ArrayList<Card>();
			ArrayList<Card> computerHand = new ArrayList<Card>();

			System.out.println("Game Start");
			//	calls DeckOfCards function
			DeckOfCards deck = new DeckOfCards();
			deck.shuffle();
			//Deals 5 cards to player and computer
			for(int count = 0; count < 5; count++){
				playerHand.add(deck.dealCard());
				computerHand.add(deck.dealCard());
			}
			//Current faceUp card 
			Card faceUp = deck.dealCard();

			//Runs game while the player hand and computer hand are both not empty
			while(!(playerHand.isEmpty()) && !(computerHand.isEmpty())){
				//Initialize variables that both players didn't play a card
				boolean playedCard1 = false;
				boolean playedCard2 = false;

				Thread.sleep(1000);//Sleep function for some time in between players to not make everything seem instant

				//Player Turn
				System.out.println("Your Turn!!");
				for(Card card: playerHand){
					if(isCardPlayable(card,faceUp)){
						playedCard1 = true;//If player can play a card in their hand, they will
					}
				}
				if(playedCard1){ //If the player can play a card
					System.out.println("Face Up Card: ");
					displayCard(faceUp);//Display the face up card
					CrazyEights.displayHand(playerHand); //Display the player's hand
					faceUp = playCard(playerHand, faceUp); //Change the faceUp card to what the player plays
				}
				else{ //If they can't play a card
					boolean playedCardDraw = false; //Variable for if they can play a card in their hand after they draw
					for(int count = 0; count < 3; count++){ //Max of drawing 3 times before their turn is over
						//Checks if deck is empty
						if(deck.isDeckEmpty()){
							System.out.println("No Cards left in deck... Reshuffling");
							deck = new DeckOfCards();//Puts more cards to be played
							deck.shuffle();
						}
						System.out.println("You cannot play a card. Drawing a card.");
						Thread.sleep(100);
						playerHand.add(deck.dealCard());
						for(Card card: playerHand){
							if(isCardPlayable(card,faceUp)){
								playedCardDraw = true; //If in the draw sequence they can play a card, let them be able to play a card
							}
						}
						//displays the card that player put down if they got a card from drawing 
						if(playedCardDraw){
							//Plays card like normally
							System.out.println("Face Up Card: ");
							displayCard(faceUp);
							CrazyEights.displayHand(playerHand);
							faceUp = playCard(playerHand, faceUp);
							break;//Exits for loop because player played a card
						}
					}//end for
				}//end else
				if(deck.isDeckEmpty()){ //If deck is empty at the end of the turn
					System.out.println("No Cards left in Deck... Reshuffling");
					deck = new DeckOfCards();//Adds more cards
					deck.shuffle();
				}

				clearConsole();
				Thread.sleep(1000);

				//Computer Turn
				System.out.println("CPU Turn!!");
				for(Card card: computerHand){
					if(isCardPlayable(card,faceUp)){
						playedCard2 = true;//If the CPU can play a card in their hand, it will
					}
				}
				// displays the card that player 2 put down 
				if(playedCard2){
					System.out.println("Face Up Card: ");
					displayCard(faceUp);
					CrazyEights.displayCPUHand(computerHand);//DIfferent display for CPU hand because player doensn't know the CPU's cards
					faceUp = playCardCPU(computerHand, faceUp); //CPU plays first playable card in their hand using this function
				}
				else{//If the CPU can't play, it enters the draw sequence
					boolean playedCardDraw = false;
					for(int count = 0; count < 3; count++){ //Max 3 draws for the CPU
						//Checks if deck is empty
						if(deck.isDeckEmpty()){
							System.out.println("No Cards left in deck... Reshuffling");
							deck = new DeckOfCards();//Puts more cards to be played
							deck.shuffle();
						}
						System.out.println("CPU cannot play a card. Drawing a card.");
						Thread.sleep(100);
						computerHand.add(deck.dealCard());
						for(Card card: computerHand){
							if(isCardPlayable(card,faceUp)){
								playedCardDraw = true;
							}
						}
						//displays the card that CPU put down if they got a card from drawing 
						if(playedCardDraw){
							//If the CPU can play a card in the draw sequence, it will play normally
							System.out.println("Face Up Card: ");
							displayCard(faceUp);
							CrazyEights.displayCPUHand(computerHand);
							faceUp = playCardCPU(computerHand, faceUp);
							break;//Ends the loop because the CPU played a card
						}
					}//end for
				}//end else
				if(deck.isDeckEmpty()){
					System.out.println("No Cards left in deck... Reshuffling");
					deck = new DeckOfCards();
					deck.shuffle();
				}
				clearConsole();
			}//End while loop (Game)
			
			// if player hand is empty, player wins 
			if(playerHand.isEmpty()){
				System.out.println("You Win!");
			}
			// if CPU hand is empty computer wins
			else if(computerHand.isEmpty()){
				System.out.println("Computer Wins!");
			}

		}
		else{

			//2 Player

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

			clearConsole();

			//Game loop that makes the game run
			while(!(player1Hand.isEmpty()) && !(player2Hand.isEmpty())){
				boolean playedCard1 = false;
				boolean playedCard2 = false;

				Thread.sleep(1000);//Sleep function for some time in between players to not make everything seem instant
				//Player 1 Turn
				System.out.println(player1 + "'s' Turn!!");
				for(Card card: player1Hand){
					if(isCardPlayable(card,faceUp)){
						playedCard1 = true;//If there is a playable card in player 1's hand, they will play it
					}
				}
				if(playedCard1){//Plays a card for p1 if they can
					System.out.println("Face Up Card: ");
					displayCard(faceUp);//displays face up card
					CrazyEights.displayHand(player1Hand); //Displays p1 hand
					faceUp = playCard(player1Hand, faceUp); //sets faceUp card to the card p1 played
				}
				else{//Draw sequence
					boolean playedCardDraw = false; //Variable for if p1 can play during the draw sequence
					for(int count = 0; count < 3; count++){//Max 3 draws
						//Checks if deck is empty
						if(deck.isDeckEmpty()){
							System.out.println("No Cards left in deck... Reshuffling");
							deck = new DeckOfCards();//Puts more cards to be played
							deck.shuffle();
						}
						System.out.println(player1 + " cannot play a card. Drawing a card.");
						Thread.sleep(100);
						player1Hand.add(deck.dealCard());
						for(Card card: player1Hand){
							if(isCardPlayable(card,faceUp)){
								playedCardDraw = true;
							}
						}
						if(playedCardDraw){//If p1 can play a card during the draw sequence
							//Plays card normally
							System.out.println("Face Up Card: ");
							displayCard(faceUp);
							CrazyEights.displayHand(player1Hand);
							faceUp = playCard(player1Hand, faceUp);
							break;//Exits for loop because p1 played a card
						}
					}//end for
				}//end else

				if(player1Hand.isEmpty()){
					break;//Aborts game early if p1 wins
				}
				clearConsole();
				Thread.sleep(1000);
				//Checks if deck is empty
				if(deck.isDeckEmpty()){
					System.out.println("No Cards left in deck... Reshuffling");
					deck = new DeckOfCards();//Puts more cards to be played
					deck.shuffle();
				}

				//Player 2 Turn
				System.out.println(player2 + "'s' Turn!!");
				for(Card card: player2Hand){
					if(isCardPlayable(card,faceUp)){
						playedCard2 = true;
					}
				}
				if(playedCard2){//If p2 can play a card
					System.out.println("Face Up Card: ");
					displayCard(faceUp);//Display face up card
					CrazyEights.displayHand(player2Hand);//display p2 hand
					faceUp = playCard(player2Hand, faceUp);//change face up card to the card p2 played
				}
				else{//Draw sequence
					boolean playedCardDraw = false;
					for(int count = 0; count < 3; count++){//max 3 draws
						//Checks if deck is empty
						if(deck.isDeckEmpty()){
							System.out.println("No Cards left in deck... Reshuffling");
							deck = new DeckOfCards();//Puts more cards to be played
							deck.shuffle();
						}
						System.out.println(player2 + " cannot play a card. Drawing a card.");
						Thread.sleep(100);
						player2Hand.add(deck.dealCard());
						for(Card card: player2Hand){
							if(isCardPlayable(card,faceUp)){
								playedCardDraw = true;
							}
						}
						if(playedCardDraw){//if p2 can play a card during the draw sequence
							//Plays card normally
							System.out.println("Face Up Card: ");
							displayCard(faceUp);
							CrazyEights.displayHand(player2Hand);
							faceUp = playCard(player2Hand, faceUp);
							break;//exits for loop because p2 played a card
						}
					}//end for
				}//end else

				//Checks if deck is empty
				if(deck.isDeckEmpty()){
					System.out.println("No Cards left in deck... Reshuffling");
					deck = new DeckOfCards();//Puts more cards to be played
					deck.shuffle();
				}
				clearConsole();
			}//end while (game)

			clearConsole();

			if(player1Hand.isEmpty()){//if p1 hand is empty, p1 wins
				System.out.println(player1 + " Wins!");
			}
			else if(player2Hand.isEmpty()){ //otherwidse p2 wins
				System.out.println(player2 + " Wins!");
			}
			else{//Not possible, but figured i'd add it anyways
				System.out.println("Draw");
			}
		}//End else (2 player gamemode)
	}//end main
	
	public static Card playCardCPU(ArrayList<Card> hand, Card faceUp){
		Card dummyCard = hand.get(0);
		try {
			for(Card card : hand){
				if(isCardPlayable(card,faceUp)){
					hand.remove(card);
					return card;
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("The CPU's turn was skipped due to an exception");
		}
		return dummyCard;
	}
 	

	public static void displayCPUHand(ArrayList<Card> hand){
		String displayHand = "";
		for(Card item: hand){
    		displayHand += "+-----+ ";
		}
		displayHand += "\n";
		for(Card item: hand){
    		displayHand += "|+++++| ";
		}
		displayHand += "\n";
		for(Card item: hand){
            displayHand += "|+++++| ";
        }
		displayHand += "\n";
		for(Card item: hand){
    		displayHand += "|+++++| ";
		}
		displayHand += "\n";
		for(Card item: hand){
    		displayHand += "|+++++| ";
		}
		displayHand += "\n";
		for(Card item: hand){
    		displayHand += "+-----+ ";
		}
		System.out.println(displayHand);
	}

// GETS USER INPUT AND REMOVES HAND
	public static Card playCard(ArrayList<Card> playerHand, Card faceUp) {
		int removeIndex;
		Card playedCard;
		while(true){
			System.out.println("Please pick a card in your hand to play");
			Scanner scan = new Scanner(System.in);
			playedCard = null;
			removeIndex = -1;
			try{
				removeIndex = scan.nextInt();
				playedCard = playerHand.get(removeIndex - 1);
			}
			catch(InputMismatchException ie){
				System.out.println("Not a valid card integer. Skipping your turn!");
				String dummy = scan.nextLine();
			}
			catch(IndexOutOfBoundsException ioobe){
				System.out.println("Not a card in your hand. Skipping your turn!");
				String dummy = scan.nextLine();
			}
			
			if(removeIndex > playerHand.size() || removeIndex == -1){
				return faceUp;
			}

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
			int suitChangeNum = 0;
			try{
				suitChangeNum = suitChange.nextInt();
			}
			catch(InputMismatchException ie){
				System.out.println("NO. Nice Try, my code won't break");
			}
			
			if(suitChangeNum == 0){
				//Keep the current suit because they're rebellious
			}
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
	public static void clearConsole() throws IOException, InterruptedException {
		//new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  
	}  
}
