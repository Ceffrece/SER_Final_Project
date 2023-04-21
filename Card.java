// Fig. 7.9: Card.java
// Card class represents a playing card.

public class Card {
    final String face; // face of card ("Ace", "Deuce", ...)
    String suit; // suit of card ("Hearts", "Diamonds", ...)
 
    // two-argument constructor initializes card's face and suit
    public Card(String cardFace, String cardSuit) {
       this.face = cardFace; // initialize face of card
       this.suit = cardSuit; // initialize suit of card
    } 
    
    public String getFace() {
      return this.face;
    }

    public String getSuit() {
      return this.suit;
    }

    public char getSuitIcon() {
      /*switch (this.suit) {
          case "Hearts":
              return "\u2665";
          case "Diamonds":
              return "\u2666";
          case "Clubs":
              return "\u2663";
          case "Spades":
              return "\u2660";
          default:
              return "";
      }*/
      char ch = ' ';
      if(this.suit.equals("Hearts")){
        ch = 3;
      }
      else if(this.suit.equals("Diamonds")){
        ch = 4;
      }
      else if(this.suit.equals("Clubs")){
        ch = 5;
      }
      else if(this.suit.equals("Spades")){
        ch = 6;
      }
      return ch;
  }
  

    // return String representation of Card
    public String toString() {             
       return face + " of " + suit;        
    }
    
    //displays card
    public void display(){
      System.out.println("---------");
      System.out.println("|...." + this.face + "....|");
      System.out.println("|.........|");
    }

    //changes the suit of the card (ONLY FOR EIGHTS)
    public void setSuit(String suit){
      this.suit = suit;
    }
 } 
 
 
 
 /**************************************************************************
  * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
  * Pearson Education, Inc. All Rights Reserved.                           *
  *                                                                        *
  * DISCLAIMER: The authors and publisher of this book have used their     *
  * best efforts in preparing the book. These efforts include the          *
  * development, research, and testing of the theories and programs        *
  * to determine their effectiveness. The authors and publisher make       *
  * no warranty of any kind, expressed or implied, with regard to these    *
  * programs or to the documentation contained in these books. The authors *
  * and publisher shall not be liable in any event for incidental or       *
  * consequential damages in connection with, or arising out of, the       *
  * furnishing, performance, or use of these programs.                     *
  *************************************************************************/
 