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

public class Exercise08 {

	public static void main(String[] args) {
		IO.println(CardWithJoker2.createJoker(CardWithJoker2.Joker.LOW));
		IO.println(CardWithJoker2.createJoker(CardWithJoker2.Joker.HIGH));
	}
}

class CardWithJoker2 {
	
	enum Joker {
		NONE, LOW, HIGH;
	}
	
	private Rank aRank;
	private Suit aSuit;
	private Joker aJoker = Joker.NONE;
	
	/**
	 * Creates a new card object.
	 * 
	 * @param pRank The rank of the card.
	 * @param pSuit The suit of the card.
	 * @pre pRank != null
	 * @pre pSuit != null
	 */
	public CardWithJoker2(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		aRank = pRank;
		aSuit = pSuit;
	}
	
	private CardWithJoker2(Joker pJoker) {
		aRank = null;
		aSuit = null;
		aJoker = pJoker;
	}
	
	/**
	 * @param pJoker The type of joker to create.
	 * @return A joker card.
	 * @pre pJoker != Joker.NONE
	 */
	public static CardWithJoker2 createJoker(Joker pJoker) {
		assert pJoker != Joker.NONE;
		return new CardWithJoker2(pJoker);
	}
	
	public boolean isJoker() {
		return aJoker != Joker.NONE;
	}
	
	public Joker jokerType() {
		return aJoker;
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
			return aJoker + " Joker";
		}
		return String.format("%s of %s", aRank, aSuit);
	}
}