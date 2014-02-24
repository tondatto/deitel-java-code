package model;

import java.util.Random;
import java.util.Arrays;

public class DeckOfCards {
	private final String faces[] = {"Ás", "Dois", "Três", "Quatro", "Cinco",
            "Seis", "Sete", "Oito", "Nove", "Dez", "Valete", "Damas", "Rei"};
   private final String suits[] = {"Copas", "Ouro", "Paus", "Espada"};
	
   private Card[] deck;
   private int currentCard;
   private final int NUMBER_OF_CARDS = 52;
   private Random randomNumbers;

   public DeckOfCards(){
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
   
   public boolean hasOnePair(Card[] hand){
   	for(int i=0; i < hand.length - 1; i++){
   		Card c = hand[i];
   		for(int j=i+1; j < hand.length; j++){
   			if(c.getFace().equals(hand[j].getFace())){
   				return true;
   			}
   		}
   	}
   	return false;
   }
   
   public boolean hasTwoPairs(Card[] hand){
   	Card firstPair = null, secondPair = null; 
   	
   	for(int i=0; i < hand.length - 1; i++){
   		Card c1 = hand[i];
   		for(int j=i+1; j < hand.length; j++){
   			if(c1.getFace().equals(hand[j].getFace())){
   				firstPair = c1;
   			}
   		}
   	}
   	
   	if (firstPair != null) {
			for(int i=0; i < hand.length - 1; i++){
				if(! hand[i].getFace().equals(firstPair.getFace()) ){
					Card c2 = hand[i];
					for(int j=i+1; j < hand.length; j++){
						if(c2.getFace().equals(hand[j].getFace())){
							return true;
						}
					}	
				}
			}
   	}
   	
   	return false;
   }
   
   public boolean hasTrinca(Card[] hand){
   	int count;
   	
   	for(int i=0; i < hand.length - 1; i++){
   		Card c = hand[i];
   		count = 1;
   		
   		for(int j=i+1; j < hand.length; j++){
   			if(c.getFace().equals(hand[j].getFace())){
   				count++;
   			}
   		}
   		
   		if (count >= 3) {
   			return true;
   		}
   		
   	}
   	return false;
   }
   
   public boolean hasQuadra(Card[] hand){
   	int count;
   	
   	for(int i=0; i < hand.length - 1; i++){
   		Card c = hand[i];
   		count = 1;
   		
   		for(int j=i+1; j < hand.length; j++){
   			if(c.getFace().equals(hand[j].getFace())){
   				count++;
   			}
   		}
   		
   		if (count >= 4) {
   			return true;
   		}
   		
   	}
   	return false;
   }
   
   // Retorna true se o array de cartas
   // contém um "flush" (cinco cartas do mesmo naipe)
   public boolean hasFlush(Card[] hand){
   	Card c = hand[0];
   	
   	for(int i=1; i < hand.length; i++){
   		if(!c.getSuit().equals(hand[i].getSuit())){
   			return false;
   		}
   		
   	}
   	return true;
   }
   
   // Retorna true se o array de cartas
   // contém um "straight" (cinco cartas com valores seguidos)
   public boolean hasStraight(Card[] hand){
   	// ordena cartas
   	for(int i=0; i < hand.length - 1; i++){
   		int first = Arrays.binarySearch(faces, hand[i].getFace());
   		for(int j=i; j < hand.length; j++){
   			int second = Arrays.binarySearch(faces, hand[j].getFace());
   			if (second < first){
   				Card temp = hand[i];
   				hand[i] = hand[j];
   				hand[j] = temp;
   			}
   			
   		}
   	}
   	
   	for (int i=0; i < hand.length - 1; i++){
   		int first = Arrays.binarySearch(faces, hand[i].getFace());
   		int second = Arrays.binarySearch(faces, hand[i+1].getFace());
   		if(second - first != 1)
   			return false;
   	}
   	
   	return true;
   }
   
   // Retorna true se o array de cartas
   // contém um "full house" (duas cartas de um valor 
   // e três cartas de outro valor)
   public boolean hasFullHouse(Card[] hand){
   	return false;
   }
}
