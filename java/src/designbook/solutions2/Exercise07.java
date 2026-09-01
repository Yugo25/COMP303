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

import designbook.chapter2.Rank;
import designbook.chapter2.Suit;

public class Exercise07 {

	public static void main(String[] args) {
		IO.println(CardWithJoker.createJoker());
	}
}

class CardWithJoker {
	
	private Rank aRank;
	private Suit aSuit;
	
	/**
	 * Creates a new card object.
	 * 
	 * @param pRank The rank of the card.
	 * @param pSuit The suit of the card.
	 * @pre pRank != null
	 * @pre pSuit != null
	 */
	public CardWithJoker(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		aRank = pRank;
		aSuit = pSuit;
	}
	
	private CardWithJoker() {
		aRank = null;
		aSuit = null;
	}
	
	public static CardWithJoker createJoker() {
		return new CardWithJoker();
	}
	
	public boolean isJoker() {
		return aRank == null;
	}
	
	/**
	 * @return The rank of the card.
	 * @pre !isJoker()
	 */
	public Rank rank() {
		assert !isJoker();
		return aRank;
	}
	
	/**
	 * @return The suit of the card.
	 * @pre !isJoker()
	 */
	public Suit suit() {
		assert !isJoker();
		return aSuit;
	}
	
	@Override
	public String toString() {
		if (isJoker()) {
			return "Joker";
		}
		return String.format("%s of %s", aRank, aSuit);
	}
}