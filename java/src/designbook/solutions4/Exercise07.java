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

import java.util.IdentityHashMap;
import java.util.Map;

import designbook.chapter4.Rank;
import designbook.chapter4.Suit;

class Card7 {

	private static final Map<Rank, Map<Suit, Card7>> CARDS = new IdentityHashMap<>();
	
	static {
		for (Rank rank : Rank.values()) {
			CARDS.put(rank, new IdentityHashMap<>());
			for (Suit suit : Suit.values()) {
				CARDS.get(rank).put(suit, new Card7(rank, suit));
			}
		}
	}
	
	private Rank aRank;
	private Suit aSuit;
	
	public static Card7 get(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		return CARDS.get(pRank).get(pSuit);
	}

	private Card7(Rank pRank, Suit pSuit) {
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
}

public class Exercise07 {

	public static void main(String[] args) {
		Card7 card1 = Card7.get(Rank.ACE, Suit.CLUBS);
		Card7 card2 = Card7.get(Rank.ACE, Suit.CLUBS);
		IO.println("Are they the same object? " + (card1 == card2));
	}
}