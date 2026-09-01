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

import designbook.chapter2.Card;

public class Exercise10 {

	public static void main(String[] args) {
		MultiDeck original = new MultiDeck(2);
		MultiDeck copy = new MultiDeck(original);
	}
}

class MultiDeck {

	private Deck[] aDecks;

	/**
	 * Creates an initialized, shuffled multi-deck from pNumberOfDecks decks.
	 * 
	 * @param pNumberOfDecks The number of decks in the multi-deck
	 * @pre pNumberOfDecks > 0
	 */
	public MultiDeck(int pNumberOfDecks) {
		assert pNumberOfDecks > 0;
		aDecks = new Deck[pNumberOfDecks];
		for (int i = 0; i < aDecks.length; i++) {
			aDecks[i] = new Deck();
		}
	}
	
	/**
	 * Copy constructor.
	 * 
	 * @param pMultiDeck The instance we wish to copy.
	 * @pre pMultiDeck != null.
	 */
	public MultiDeck(MultiDeck pMultiDeck) {
		assert pMultiDeck != null;
		aDecks = new Deck[pMultiDeck.aDecks.length];
		for (int i = 0; i < aDecks.length; i++) {
			aDecks[i] = new Deck(pMultiDeck.aDecks[i]);
		}
	}

	/**
	 * @return The next card in the multi-deck
	 * @pre !isEmpty()
	 */
	public Card draw() {
		assert !isEmpty();
		for (Deck deck : aDecks) {
			if (deck.isEmpty()) {
				continue;
			}
			return deck.draw();
		}
		assert false;
		return null;
	}

	/**
	 * @return True if all decks in this multi-deck are empty
	 */
	public boolean isEmpty() {
		for (Deck deck : aDecks) {
			if (!deck.isEmpty()) {
				return false;
			}
		}
		return true;
	}
}