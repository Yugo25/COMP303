/*******************************************************************************
 * Java code samples on the essentials of Java programming.
 * https://codesample.info
 *
 * Copyright (C) 2022 by Martin Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package chapter2e;

import java.util.Random;
/**
 * Implementation of a playing card. This class yields immutable objects.
 */
public class Card {
	private Rank aRank;
	private Suit aSuit;
	private Joker aJoker = Joker.NONE;
	private static Random aRandom = new Random();
	
	/**
	 * Creates a new card object.
	 * 
	 * @param pRank The rank of the card.
	 * @param pSuit The suit of the card.
	 * @pre pRank != null
	 * @pre pSuit != null
	 */
	public Card(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		aRank = pRank;
		aSuit = pSuit;
	}

	private Card(Joker pJoker) {
		aRank = null;
		aSuit = null;
		aJoker = pJoker;
	}

	/**
	 * 
	 * @param pJoker
	 * @return a joker card
	 * @pre pJoker != Joker.NONE;
	 */
	public static Card createJoker(Joker pJoker) {
		assert pJoker != Joker.NONE;
		return new Card(pJoker);
	}

	public boolean isJoker() {
		return aJoker != Joker.NONE;
	}

	public Joker getJoker() {
		return aJoker;
	}

	/**
	 * @return The rank of the card.
	 * @pre !isJoker();
	 */
	public Rank getRank() {
		assert !isJoker();
		return aRank;
	}
	
	/**
	 * @return The suit of the card.
	 * @pre !isJoker()
	 */
	public Suit getSuit() {
		assert !isJoker();
		return aSuit;
	}

	public static Card random() {
		return new Card(Rank.values()[aRandom.nextInt(Rank.values().length)], Suit.values()[aRandom.nextInt(Suit.values().length)]);
	}

	/**
	 * Returns the next card
	 * @return Card object of the next card
	 */
	public Card next() {
		return new Card(aRank.nextRank(), aSuit.nextSuit());
	}

	@Override
	public String toString() {
		if (isJoker()) {
			return aJoker + "Joker";
		} else {
			return String.format("%s of %s", aRank, aSuit);
		}
	}
}