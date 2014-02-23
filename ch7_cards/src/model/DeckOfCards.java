package model;

import java.util.Random;

public class DeckOfCards {

   private Card[] deck;
   private int currentCard;
   private final int NUMBER_OF_CARDS = 52;
   private Random randomNumbers;

   public DeckOfCards(){
      String faces[] = {"Ás", "Dois", "Três", "Quatro", "Cinco",
            "Seis", "Sete", "Oito", "Nove", "Dez", "Valete", "Damas", "Rei" };
      String suits[] = {"Copas", "Ouro", "Paus", "Espada"};

      deck = new Card[NUMBER_OF_CARDS];
      currentCard = 0;
      randomNumbers = new Random();

      for (int count = 0; count < deck.length; count++)
         deck[count] = new Card(faces[count%13], suits[count/13]);
   }

   // embaralha as cartas com um algoritmo de uma passagem
   public void suffle(){
      currentCard = 0;
      int randomCard;

      for (int i=0; i<NUMBER_OF_CARDS; i++){
         randomCard = randomNumbers.nextInt(NUMBER_OF_CARDS);

         Card temp = deck[i];
         deck[i] = deck[randomCard];
         deck[randomCard] = temp;
      }
   }

   // distribui um Card
   public Card dealCard(){
      if (currentCard < deck.length){
         return deck[currentCard++];
      } else {
         return null;
      }
   }
}
