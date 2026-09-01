/*******************************************************************************
 * Java code samples on the essentials of Java programming.
 * https://codesample.info
 *
 * Copyright (C) 2026 by Martin Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package designbook.solutions4;

import java.util.HashSet;

import designbook.chapter4.Rank;
import designbook.chapter4.Suit;

/**
 * Implementation of a playing card. This class yields immutable objects. This
 * version of the class is checkable for equality.
 */
class Card6 {

	private Rank aRank;
	private Suit aSuit;

	public Card6(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		aRank = pRank;
		aSuit = pSuit;
	}

	public Rank rank() {
		return aRank;
	}

	public Suit suit() {
		return aSuit;
	}

	@Override
	public int hashCode() {
		return aSuit.ordinal() * Rank.values().length + aRank.ordinal();
	}

	@Override
	public boolean equals(Object pObject) {
		if (this == pObject) {
			return true;
		}
		if (pObject == null || getClass() != pObject.getClass()) {
			return false;
		}
		Card6 other = (Card6) pObject;
		return aSuit == other.aSuit && aRank == other.aRank;
	}
}

public class Exercise06 {

	/* Code that relies on the equals and hashCode methods */
	public static void main(String[] args) {
		Card6 card1 = new Card6(Rank.ACE, Suit.CLUBS);
		Card6 card2 = new Card6(Rank.ACE, Suit.DIAMONDS);
		Card6 card3 = new Card6(Rank.ACE, Suit.CLUBS);
		HashSet<Card6> set = new HashSet<>();
		set.add(card1);
		set.add(card2);
		assert card1.equals(card3);
		assert set.size() == 2;
		assert !set.add(card3);
		IO.println("No errors");
	}
}