package test;

import model.DeckOfCards;
import model.Card;

public class HandOfPokerTest {

   public static void main (String[] args){
      DeckOfCards myDeck = new DeckOfCards();
      myDeck.suffle();

      Card[] hand = new Card[5];
      
      System.out.println("Mão de cartas:");
      for (int i = 0; i < 5; i++){
         hand[i] = myDeck.dealCard();
         System.out.printf("%-5s\n",hand[i]);
      }
      
      
   }
}
