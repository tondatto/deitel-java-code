package model;

public class Card {
   private String face; // face da carta
   private String suit; // naipe da carta

   public Card(String cardFace, String cardSuit){
      face = cardFace;
      suit = cardSuit;
   }
   
   public String getFace(){
   	return face;
   }
   
   public String getSuit(){
   	return suit;
   }

   public String toString(){
      return face + " de " + suit;
   }
}
