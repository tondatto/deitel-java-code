package test;

import model.Card;
import model.DeckOfCards;

public class HandOfPokerTest2 {
	
	public static void main (String[] args){
		
		// Testa um par
		Card[] hand1 = new Card[5];
		hand1[0] = new Card("Ás", "Paus");
		hand1[1] = new Card("Rei", "Copas");
		hand1[2] = new Card("Sete", "Espada");
		hand1[3] = new Card("Seis", "Copas");
		hand1[4] = new Card("Seis", "Paus");
		
		DeckOfCards myDeck = new DeckOfCards();
		
		System.out.println("Tem um par? " + myDeck.hasOnePair(hand1));
		
		// Testa 2 pares
		Card[] hand2 = new Card[5];
		hand2[0] = new Card("Ás", "Paus");
		hand2[1] = new Card("Rei", "Copas");
		hand2[2] = new Card("Sete", "Espada");
		hand2[3] = new Card("Ás", "Copas");
		hand2[4] = new Card("Rei", "Paus");
		
		System.out.println("Tem dois pares? " + myDeck.hasTwoPairs(hand2));
		
		// Testa trinca
		Card[] hand3 = new Card[5];
		hand3[0] = new Card("Ás", "Paus");
		hand3[1] = new Card("Rei", "Copas");
		hand3[2] = new Card("Sete", "Espada");
		hand3[3] = new Card("Ás", "Copas");
		hand3[4] = new Card("Ás", "Ouro");
		
		System.out.println("Tem trinca? " + myDeck.hasTrinca(hand3));
		
		// Testa quadra
		Card[] hand4 = new Card[5];
		hand4[0] = new Card("Ás", "Paus");
		hand4[1] = new Card("Rei", "Copas");
		hand4[2] = new Card("Ás", "Espada");
		hand4[3] = new Card("Ás", "Copas");
		hand4[4] = new Card("Ás", "Ouro");
		
		System.out.println("Tem quadra? " + myDeck.hasQuadra(hand4));
		
		// Testa flush
		Card[] hand5 = new Card[5];
		hand5[0] = new Card("Ás", "Paus");
		hand5[1] = new Card("Rei", "Paus");
		hand5[2] = new Card("Dois", "Paus");
		hand5[3] = new Card("Dez", "Paus");
		hand5[4] = new Card("Valete", "Paus");
		
		System.out.println("Tem flush? " + myDeck.hasFlush(hand5));
		
		// Testa Straight
		Card[] hand6 = new Card[5];
		hand6[0] = new Card("Ás", "Paus");
		hand6[1] = new Card("Dois", "Ouro");
		hand6[2] = new Card("Três", "Espada");
		hand6[3] = new Card("Quatro", "Espada");
		hand6[4] = new Card("Cinco", "Ouro");
		
		System.out.println("Tem straight? " + myDeck.hasFlush(hand6));
	}
	
}
