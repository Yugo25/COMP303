/*******************************************************************************
 * Java code samples on the essentials of Java programming.
 * https://codesample.info
 *
 * Copyright (C) 2025 by Martin Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package designbook.solutions2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import designbook.chapter2.Card;
import designbook.chapter2.Rank;
import designbook.chapter2.Suit;

public class Exercise09 {

	public static void main(String[] args) {
		Deck original = new Deck();
		Deck copy = new Deck(original);
	}
}

class Deck {
	
	private List<Card> aCards = new ArrayList<>();
	
	public Deck() {
		shuffle();
	}
	
	/**
	 * Copy constructor.
	 * 
	 * @param pDeck The instance we wish to copy.
	 * @pre pDeck != null
	 */
	public Deck(Deck pDeck) {
		assert pDeck != null;
		aCards.addAll(pDeck.aCards);
	}
	
	// The code below did not require modification 
	
	public void shuffle() {
		aCards.clear();
		for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                aCards.add( new Card(rank, suit));
            }
		}
		Collections.shuffle(aCards);
	}
	
	public void push(Card pCard) {
		assert pCard != null;
		aCards.add(pCard);
	}
	
	public Card draw() {
		assert !isEmpty();
		return aCards.removeLast();
	}
	
	public boolean isEmpty() {
		return aCards.isEmpty();
	}
	
	public List<Card> cards() {
		return Collections.unmodifiableList(aCards);
	}
}